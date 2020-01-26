package bankautomat;

import java.awt.Label;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JLabel;

public class Bancomat {

    private static DBHelper dbHelper = new DBHelper();
    private Kartenleser kartenleser = new Kartenleser();
    private static Anzeige anzeige;
    private RemoteBankSystem remoteBankSystem = new RemoteBankSystem();
    
    public Bancomat() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Karte> karten = dbHelper.getKarten();
        anzeige = new Anzeige(karten, new Bancomat());
        anzeige.setVisible(true);

    }

    public String geldAbheben(int menge, Karte karte) {
        return remoteBankSystem.geldAbheben(menge, karte);
    }

    public String saldoAbfragen(Karte ausgewaehlteKarte) {
        return remoteBankSystem.saldoAbfragen(ausgewaehlteKarte.getIban());
    }

    public boolean pruefeKonto(Karte ausgewaehlteKarte){
        return remoteBankSystem.pruefeKonto(ausgewaehlteKarte.getIban());
    }
    /**
     *
     * @param karte
     * @param newPin
     * @return Gibt ein String Array zurück. Der erste Teil ist die
     * Nachricht(erfolgreich oder die Entsprechende Fehlermeldung). Der zweite
     * Teil Gibt 0 = Erfolgreich oder 1 = nicht erfolgreich zurück.
     */
    public String[] pincodeAendern(Karte karte, String newPin) {
        int pin = 0;
        try {
            if (karte.getPincode() == Integer.parseInt(newPin)) {
                return new String[]{"Es darf nicht der gleiche Pin gesetzt werden.", "1"};

            } else if (newPin.startsWith("0")) {
                return new String[]{"Ein Pin der mit 0 beginnt ist ungültig.", "1"};
            } else if (newPin.length() < 4 || newPin.length() > 6) {
                return new String[]{"Der Pin muss min 4 und max 6 Stellig sein.", "1"};

            } else {
                pin = Integer.parseInt(newPin);
                dbHelper.pinAendern(karte.getIban(), pin);
                anzeige.setKarten(dbHelper.getKarten());
            }

        } catch (Exception ex) {
            return new String[]{"Es ist ein Fehler bei Ändern des Pins aufgetreten", "1"};
        }
        return new String[]{"Pin erfolgreich geändert", "0"};
    }
    public void setKarten(){
        ArrayList<Karte> karten = dbHelper.getKarten();
        anzeige.setKarten(karten);
    }
    public void karteEinziehen(Karte karte) {
        kartenleser.einziehen(dbHelper, karte);
    }

    public ArrayList<String> getGesperteKarten() {
        return dbHelper.getGesperteKarten();
    }
    /**
     * Diese Funktion lässt den Kartenleser den Pin einer Karte überprüfen.
     * @param karte Die Karte wessen Pin überprüft werden soll.
     * @param eingegebenerPin Der vom User eingegebene Pin.
     * @return Gibt zurück ob der eingegebene Pin mit der der Karte übereinstimmt.
     */
    public Boolean pincodePrüfen(Karte karte, int eingegebenerPin) {
        return kartenleser.pincodePrüfen(karte, eingegebenerPin);
    }
    /**
     * Diese Funktion lässt den Kartenleser die Karte einlesen.
     * Danach gibt Sie die eingelesen Karte zurück.
     * @param karten Alle nicht gesperten Karten.
     * @param iban Die iban der einzulesenden Karte
     * @return gibt die eingelesen Karte zurück
     */
    public Karte karteEinlesen(ArrayList<Karte> karten, String iban) {
        return kartenleser.einlesen(karten, iban);

    }

    public boolean kartePrüefen(Karte karte) {
        LokalePruefung lokalePruefung = new LokalePruefung();
        lokalePruefung.fuehrePruefungDurch(karte.getIban());
        return lokalePruefung.pruefungsresultat();
    }
    
    public ArrayList<Geldkassette> notenAusgeben(int menge, boolean isBigNotes){
       if(remoteBankSystem.istMengeMoeglichZumBeziehen(menge)){
            return remoteBankSystem.notenAusgeben(menge, dbHelper.getAllKassetten(), isBigNotes);
       }
       return (ArrayList) Collections.EMPTY_LIST;
    }
    
    public boolean istMengeMoeglichZumBeziehen(int menge){
        return remoteBankSystem.istMengeMoeglichZumBeziehen(menge);
    }
    
    public int getNaechstMoeglicherBetragZumAbheben(){
        return dbHelper.getAllKassetten().stream().mapToInt(kassette -> kassette.getMenge() * kassette.getNote()).sum();
    }
}
