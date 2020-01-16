package bankautomat;

import java.util.ArrayList;

public class Bancomat {

    private static DBHelper dbHelper = new DBHelper();
    private Kartenleser kartenleser = new Kartenleser();

    public Bancomat() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Karte> karten = dbHelper.getKarten();
        Anzeige anzeige = new Anzeige(karten, new Bancomat());
        anzeige.setVisible(true);

    }

    public void geldAbheben() {

    }

    public void saldoAbfragen() {

    }

    public void pincodeAendern() {

    }
    
    public void karteEinziehen(Karte karte){
        kartenleser.einziehen(dbHelper,karte);
    }
    
     public ArrayList<String> getGesperteKarten(){
        return dbHelper.getGesperteKarten();
    }

    public Boolean pincodePrüfen(Karte karte, int eingegebenerPin) {
        return kartenleser.pincodePrüfen(karte, eingegebenerPin);
    }

    public Karte karteEinlesen(ArrayList<Karte> karten, String iban) {
        return kartenleser.einlesen(karten, iban);

    }

    public void karteEinlesenPrüefen() {

    }
}
