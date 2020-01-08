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
        Anzeige anzeige = new Anzeige();
        anzeige.setVisible(true);
       ArrayList<Karte> karten = dbHelper.getKarten();
        for(Karte karte : karten){
            System.out.println(karte.getName()+1);
        }
    }
    public void geldAbheben(){

    }
    public void saldoAbfragen(){

    }
    public void pincodeAendern(){

    }
    public void karteEinlesenPrüefen(){

    }
}
