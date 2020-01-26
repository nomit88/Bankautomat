package bankautomat;

import java.awt.Label;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.JLabel;

public class RemoteBankSystem {

    private static DBHelper dbHelper = new DBHelper();

    /**
     * Überprüft, ob das Konto, mit der Iban von der Karte gesperrt ist.
     *
     * @param ausgewaehlteKarte Die Karte, von der die IBan verwendet wird
     * @return true, wenn das Konto nicht gesperrt ist, false wenn es gesperrt
     * ist
     */
    public boolean pruefeKonto(String iban) {
        OnlinePruefung onlinePruefung  = new OnlinePruefung();
        onlinePruefung.fuehrePruefungDurch(iban);
        return onlinePruefung.pruefungsresultat();
    }

    /**
     * Gibt den Saldo zurück
     *
     * @param ausgewaehlteKarte Die Karte, von der die IBan verwendet wird
     * @return der Saldo, welcher auf dem Konto ist
     */
    public String saldoAbfragen(String iban) {
        return dbHelper.saldoAbfragen(iban);
    }

    /**
     * Hebt einen bestimmten Betrag ab
     *
     * @param menge Der Betrag, welcher abgehoben werden soll
     * @param karte Die Karte, von der die Iban benutzt wird
     * @return Ein String, mit der Statusmeldung
     */
    public String geldAbheben(int menge, Karte karte) {
        int[] values = dbHelper.getBankValues(karte.getIban());
        int bezugslimite = values[0];
        int verfuegbarerSaldo = values[1];
        int bereitsBezogenesGeld = values[2];
        int saldoZumAbheben = menge + bereitsBezogenesGeld;
        if (saldoZumAbheben <= bezugslimite && saldoZumAbheben < verfuegbarerSaldo) {
            verfuegbarerSaldo -= menge;
            bereitsBezogenesGeld += menge;
            dbHelper.geldAbheben(menge, karte.getIban(), verfuegbarerSaldo, bereitsBezogenesGeld);
        } else {
            if (saldoZumAbheben > bezugslimite) {
                kontoSperren(karte.getIban());
                return "Bezugslimite überschritten! Ihr Konto wird gesperrt.";
            } else {
                return "Den Betrag, welchen Sie abheben möchten ist grösser, als Ihr verfügbarer Saldo!";
            }
        }
        return "";
    }

    /**
     * Sperrt ein Konto an Hand der übergebenen Iban
     *
     * @param iban Die Iban des Kontos, welches gesperrt werden soll
     */
    public void kontoSperren(String iban) {
        dbHelper.kontoSperren(iban);
    }

    /**
     * Summiert alle Verfügbaren Geldkassetten und überprüft, die Menge, welche
     * man abheben möchte, möglich zum abheben ist.
     *
     * @param menge Die Menge zum abheben
     * @return true, wenn möglich, false wenn nicht
     */
    public boolean istMengeMoeglichZumBeziehen(int menge) {
        int mengeInDatenbank = 0;
        for (Geldkassette kassette : dbHelper.getAllKassetten()) {
            mengeInDatenbank += kassette.getMenge() * kassette.getNote();
        }
        return mengeInDatenbank > menge;
    }

    /**
     * Gibt eine ArrayList, von allen Geldkassetten welche benötigt werden um
     * den Betrag abzuheben zurück.
     *
     * @param menge Der Betrag, welcher abgehoben werden soll
     * @param isBigNotes true wenn grosse noten zurückgegeben werden sollen,
     * false wenn nicht
     * @return Alle benötigten Geldkassetten
     */
    public ArrayList<Geldkassette> notenAusgeben(int menge, ArrayList<Geldkassette> kassetten, boolean isBigNotes) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        ArrayList<Integer[]> list = new ArrayList<>();
        ArrayList<Integer> notes = new ArrayList<>();
        ArrayList<Integer> anzahl = new ArrayList<>();

        for (int i = 0; i < kassetten.size(); i++) {
            notes.add(kassetten.get(i).getNote());
            anzahl.add(kassetten.get(i).getMenge());
        }

        ArrayList<Integer[]> results = solutions(notes, anzahl, new int[4], menge, 0);
        int index = results.size();
        System.out.println(index);
        if (isBigNotes) {
            return getSpecificNotes(kassetten, results, notes, index - 1);
        } else {
            if (index == 1) {
                return getSpecificNotes(kassetten, results, notes, index - 1);
            } else {
                index -= results.size() == 1 ? 0 : 2;
                Random rndm = new Random();
                int rndmIndex = rndm.nextInt(index);
                return getSpecificNotes(kassetten, results, notes, index);

            }
        }
    }

    /**
     * Gibt eine ArrayList mit Geldkassetten zurück welche benötigt werden um
     * den Betrag abzuheben
     *
     * @param kassetten Alle Verfügbaren Kassetten
     * @param resultate Die Berechneten
     * @param noten
     * @param index
     * @return
     */
    public ArrayList<Geldkassette> getSpecificNotes(ArrayList<Geldkassette> kassetten, ArrayList<Integer[]> resultate, ArrayList<Integer> noten, int index) {
        ArrayList<Geldkassette> geldkassetten = new ArrayList<>();
        Integer[] temp = resultate.get(index);
        ArrayList<Integer> result = new ArrayList<Integer>(Arrays.asList(temp));
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) != 0) {
                int amount = result.get(i);
                Geldkassette kassette = kassetten.get(i);
                kassette.setMenge(kassette.getMenge() - amount);
                geldkassetten.add(new Geldkassette(amount, noten.get(i)));
                dbHelper.updateGeldkassette(kassette);
            }
        }

        return geldkassetten;
    }

    /**
     * Gibt verschiedene Möglichkeiten zurück, wie ein Betrag bezogen werden
     * kann.
     *
     * @param notes Die Verfügbaren Noten
     * @param anzahl Die Anzahl der Verfügbaren Noten
     * @param variation Die Anzahl, wie viele verschiedene Noten es gibt
     * @param betrag Der Betrag, welcher bezogen werden soll
     * @param position position
     * @return Ein ArrayList, mit möglichen Kombinationen, wie ein Betrag mit
     * Noten bezogen werden kann
     */
    public static ArrayList<Integer[]> solutions(ArrayList<Integer> notes, ArrayList<Integer> anzahl, int[] variation, int betrag, int position) {
        ArrayList<Integer[]> list = new ArrayList<>();

        int value = compute(notes, variation);
        if (value < betrag) {
            for (int i = position; i < notes.size(); i++) {
                if (anzahl.get(i) > variation[i]) {
                    int[] newvariation = variation.clone();
                    newvariation[i]++;
                    List<Integer[]> newList = solutions(notes, anzahl, newvariation, betrag, i);
                    if (newList != null) {
                        list.addAll(newList);
                    }
                }
            }
        } else if (value == betrag) {
            list.add(myCopy(variation));
        }
        return list;
    }

    /**
     * Gibt Anzahl der benötigten Note zurück
     *
     * @param noten Noten
     * @param variation variation
     * @return anzahl Noten
     */
    public static int compute(ArrayList<Integer> noten, int[] variation) {
        int ret = 0;
        for (int i = 0; i < variation.length; i++) {
            ret += noten.get(i) * variation[i];
        }
        return ret;
    }

    /**
     * Erstellt eine Kopie, der Möglichkeiten für eine Note
     *
     * @param ar
     * @return
     */
    public static Integer[] myCopy(int[] ar) {
        Integer[] ret = new Integer[ar.length];
        for (int i = 0; i < ar.length; i++) {
            ret[i] = ar[i];
        }
        return ret;
    }
}
