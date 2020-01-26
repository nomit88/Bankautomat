package bankautomat;

import java.awt.Label;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.JLabel;

public class RemoteBankSystem {

    private static DBHelper dbHelper = new DBHelper();

    public boolean pruefeKonto(String iban) {
        return dbHelper.pruefeKonto(iban);
    }

    public String saldoAbfragen(String iban) {
        return dbHelper.saldoAbfragen(iban);
    }

    public String geldAbheben(int menge, Karte karte) {
        int[] values = dbHelper.getBankValues(karte.getIban());
        int bezugslimite = values[0];
        int verfuegbarerSaldo = values[1];
        int bereitsBezogenesGeld = values[2];
        int saldoZumAbheben = menge + bereitsBezogenesGeld;
        if (saldoZumAbheben <= bezugslimite || saldoZumAbheben < verfuegbarerSaldo) {
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

    public void kontoSperren(String iban) {
        dbHelper.kontoSperren(iban);
    }

    public boolean istMengeMoeglichZumBeziehen(int menge){
        int mengeInDatenbank = 0;
        for(Geldkassette kassette : dbHelper.getAllKassetten()){
            mengeInDatenbank += kassette.getMenge() * kassette.getNote();
        }
        return mengeInDatenbank > menge;
    }
    public ArrayList<Geldkassette> notenAusgeben(int menge, ArrayList<Geldkassette> kassetten, boolean isBigNotes) {
        ArrayList<Integer[]> list = new ArrayList<>();
        ArrayList<Integer> notes = new ArrayList<>();
        ArrayList<Integer> anzahl = new ArrayList<>();
        
        for(int i= 0; i < kassetten.size(); i++){
            notes.add(kassetten.get(i).getNote());
            anzahl.add(kassetten.get(i).getMenge());
        }
        
        ArrayList<Integer[]> results = solutions(notes, anzahl, new int[4], menge, 0);
        
        int index = results.size();
        if(isBigNotes){
            return getSpecificNotes(kassetten, results, notes, index - 1);
        }else{
            index -= 2;
            Random rndm = new Random();
            int rndmIndex = rndm.nextInt(index);
            return getSpecificNotes(kassetten, results, notes, index);
        }
    }

    public ArrayList<Geldkassette> getSpecificNotes(ArrayList<Geldkassette> kassetten, ArrayList<Integer[]> results, ArrayList<Integer> notes, int index){
        ArrayList<Geldkassette> geldkassetten = new ArrayList<>();
        Integer[] temp = results.get(index);
        ArrayList<Integer> result = new ArrayList<Integer>(Arrays.asList(temp));
        for(int i = 0; i < result.size(); i++){
            if(result.get(i) != 0){
                int amount = result.get(i);
                Geldkassette kassette = kassetten.get(i);
                kassette.setMenge(kassette.getMenge() - amount);
                System.out.println(amount + " x CHF " + notes.get(i));
                geldkassetten.add(new Geldkassette(amount, notes.get(i)));
                dbHelper.updateGeldkassette(kassette);
            }
        }
        
        return geldkassetten;
    }
    
    public static ArrayList<Integer[]> solutions(ArrayList<Integer> notes, ArrayList<Integer> anzahl, int[] variation, int price, int position) {
        ArrayList<Integer[]> list = new ArrayList<>();
        
        int value = compute(notes, variation);
        if (value < price) {
            for (int i = position; i < notes.size(); i++) {
                if (anzahl.get(i) > variation[i]) {
                    int[] newvariation = variation.clone();
                    newvariation[i]++;
                    List<Integer[]> newList = solutions(notes, anzahl, newvariation, price, i);
                    if (newList != null) {
                        list.addAll(newList);
                    }
                }
            }
        } else if (value == price) {
            list.add(myCopy(variation));
        }
        return list;
    }

    public static int compute(ArrayList<Integer> notes, int[] variation) {
        int ret = 0;
        for (int i = 0; i < variation.length; i++) {
            ret += notes.get(i) * variation[i];
        }
        return ret;
    }

    public static Integer[] myCopy(int[] ar) {
        Integer[] ret = new Integer[ar.length];
        for (int i = 0; i < ar.length; i++) {
            ret[i] = ar[i];
        }
        return ret;
    }
}
