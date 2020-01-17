package bankautomat;

import java.util.ArrayList;

public class Kartenleser {
    public Karte einlesen(ArrayList<Karte> karten, String iban){
        Karte ausgewählteKarte = karten.get(0);
        for (Karte karte : karten) {
                if (karte.getIban() == iban) {
                    ausgewählteKarte = karte;
                }
            }
        return ausgewählteKarte;
    }

    public void einziehen(DBHelper db, Karte karte){
        db.karteSperren(karte.getIban());
    }
    public Boolean pincodePrüfen(Karte karte, int eingegebenerPin) {
        if (karte.getPincode() == eingegebenerPin) {
            return true;
        } else {
            return false;
        }
    }
}
