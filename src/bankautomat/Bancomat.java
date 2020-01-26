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

    /**
     * Hebt einen bestimmten Betrag ab
     * @param menge Der Betrag, welcher abgehoben werden soll
     * @param karte Die Karte, von der die Iban benutzt wird
     * @return Ein String, mit der Statusmeldung
     */
    public String geldAbheben(int menge, Karte karte) {
        return remoteBankSystem.geldAbheben(menge, karte);
    }

    /**
     * Gibt den Saldo zurück
     * @param ausgewaehlteKarte Die Karte, von der die IBan verwendet wird
     * @return der Saldo, welcher auf dem Konto ist
     */
    public String saldoAbfragen(Karte ausgewaehlteKarte) {
        return remoteBankSystem.saldoAbfragen(ausgewaehlteKarte.getIban());
    }

    /**
     * Überprüft, ob das Konto, mit der Iban von der Karte gesperrt ist.
     * @param ausgewaehlteKarte Die Karte, von der die IBan verwendet wird
     * @return true, wenn das Konto nicht gesperrt ist, false wenn es gesperrt ist
     */
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
    
    /**
     * Holt alle Karten und gibt diese der Anzeige weiter
     */
    public void setKarten(){
        ArrayList<Karte> karten = dbHelper.getKarten();
        anzeige.setKarten(karten);
    }
    
    /**
     * Zieht die Karte ein und sperrt diese
     * @param karte Die Karte, welche eingezogen und gesperrt werden soll
     */
    public void karteEinziehen(Karte karte) {
        kartenleser.einziehen(dbHelper, karte);
    }

    /**
     * Gibt alle gesperrten Karte zurück.
     * @return alle gesperrten Karten
     */
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

    /**
     * Üperprüft, ob die Karte gesperrt ist oder nicht
     * @param karte
     * @return 
     */
    public boolean kartePrüefen(Karte karte) {
        LokalePruefung lokalePruefung = new LokalePruefung();
        lokalePruefung.fuehrePruefungDurch(karte.getIban());
        return lokalePruefung.pruefungsresultat();
    }
    
    /**
     * Gibt eine ArrayList, von allen Geldkassetten welche benötigt werden um den
     * Betrag abzuheben zurück. 
     * @param menge Der Betrag, welcher abgehoben werden soll
     * @param isBigNotes true wenn grosse noten zurückgegeben werden sollen, false wenn nicht
     * @return Alle benötigten Geldkassetten
     */
    public ArrayList<Geldkassette> notenAusgeben(int menge, boolean isBigNotes){
       if(remoteBankSystem.istMengeMoeglichZumBeziehen(menge)){
            return remoteBankSystem.notenAusgeben(menge, dbHelper.getAllKassetten(), isBigNotes);
       }
       return (ArrayList) Collections.EMPTY_LIST;
    }
    
    /**
     * Summiert alle Verfügbaren Geldkassetten und überprüft, die Menge, welche man abheben möchte,
     * möglich zum abheben ist.
     * @param menge Die Menge zum abheben
     * @return true, wenn möglich, false wenn nicht
     */
    public boolean istMengeMoeglichZumBeziehen(int menge){
        return remoteBankSystem.istMengeMoeglichZumBeziehen(menge);
    }
    
    /**
     * Gibt den nächsten, möglichen Betrag zum abheben zurück
     * @return den nächst möglichen, abhebbaren Betrag
     */
    public int getNaechstMoeglicherBetragZumAbheben(){
        return dbHelper.getAllKassetten().stream().mapToInt(kassette -> kassette.getMenge() * kassette.getNote()).sum();
    }
    
    /**
     * Gibt alle Geldkassetten zurück
     * @return alle Geldkassetten 
     */
    public ArrayList<Geldkassette> getAllKassetten(){
        return dbHelper.getAllKassetten();
    }
    
    /**
     * Updated die Geldkassette, welche mitgegeben wird
     * @param kassette die Geldkassette, welche geupdatet werden soll.
     */
    public void updateGeldkassette(Geldkassette kassette){
        dbHelper.updateGeldkassette(kassette);
    }
}
