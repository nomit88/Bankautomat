package bankautomat;

import java.util.ArrayList;

public class Bancomat {

    private static DBHelper dbHelper = new DBHelper();

    public Bancomat() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Karte> karten = dbHelper.getKarten();
        Anzeige anzeige = new Anzeige(karten,new Bancomat());
        anzeige.setVisible(true);

    }
    

    public void geldAbheben() {

    }

    public void saldoAbfragen() {

    }

    public void pincodeAendern() {

    }

    public Boolean pincodePrüfen(Karte karte, int eingegebenerPin) {
        if (karte.getPincode() == eingegebenerPin) {
            return true;
        } else {
            return false;
        }
    }

    public void karteEinlesenPrüefen() {

    }
}
