package bankautomat;

import java.util.ArrayList;
/**
 * 
 * @author Timon Kindler & Lars Flury
 */
public class Kartenleser {
    /**
     * 
     * @param karten ein Array mit allen Karten
     * @param iban Die iban der einzulesenden Karte.
     * @return Gibt die richtige karte zurück.
     */
    public Karte einlesen(ArrayList<Karte> karten, String iban){
        Karte ausgewählteKarte = karten.get(0);
        for (Karte karte : karten) {
                if (karte.getIban() == iban) {
                    ausgewählteKarte = karte;
                }
            }
        return ausgewählteKarte;
    }
/**
 * Die Karte wird eingezogen und in der Db gesperrt.
 * @param db Instance des dbhelpers
 * @param karte die einzuziehende Karte
 */
    public void einziehen(DBHelper db, Karte karte){
        db.karteSperren(karte.getIban());
    }
    /**
     * Prüft den Pincode der Karte.
     * @param karte Die Karte mit dem richtigen Pin
     * @param eingegebenerPin Der zu prüfende Pin
     * @return 
     */
    public Boolean pincodePrüfen(Karte karte, int eingegebenerPin) {
        if (karte.getPincode() == eingegebenerPin) {
            return true;
        } else {
            return false;
        }
    }
}
