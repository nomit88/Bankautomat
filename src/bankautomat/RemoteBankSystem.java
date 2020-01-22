package bankautomat;

public class RemoteBankSystem {
    private static DBHelper dbHelper = new DBHelper();
    
    public void pruefeKonto(){

    }
    public void saldoAbfragen(){

    }
    
    public String geldAbheben(int menge, Karte karte){
     int[] values = dbHelper.getBankValues(karte.getIban());
        int bezugslimite = values[0];
        int verfuegbarerSaldo = values[1];
        int bereitsBezogenesGeld = values[2];
        verfuegbarerSaldo -= menge;
        if((menge + bereitsBezogenesGeld) <= bezugslimite){
            bereitsBezogenesGeld += menge;
            dbHelper.geldAbheben(menge, karte.getIban(), verfuegbarerSaldo, bereitsBezogenesGeld);
        }else{
            return "Bezugslimite überschritten! Ihr Konto wird gesperrt.";
        }
        return "";
    }
}
