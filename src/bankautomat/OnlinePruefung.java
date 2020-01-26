package bankautomat;

public class OnlinePruefung implements Pruefung{
    Boolean pruefungsResult = false;
    
    @Override
    public void fuehrePruefungDurch(String iban) {
        DBHelper dbHelper = new DBHelper();
        pruefungsResult = dbHelper.pruefeKonto(iban);
    }
    public void istOnline(){
        
    }

    @Override
    public boolean pruefungsresultat() {
        return pruefungsResult;
    }
}
