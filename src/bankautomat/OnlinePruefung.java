package bankautomat;

public class OnlinePruefung implements Pruefung {

    Boolean pruefungsResult = false;

    /**
     * Führt die Prüfung durch, ob das Konto gesperrt ist
     *
     * @param iban die Iban des Kontos
     */
    @Override
    public void fuehrePruefungDurch(String iban) {
        DBHelper dbHelper = new DBHelper();
        pruefungsResult = dbHelper.pruefeKonto(iban);
    }

    public void istOnline() {

    }

    /**
     * Gibt das Prüfungsresultat zurück
     * @return das Prüfungsresultat
     */
    @Override
    public boolean pruefungsresultat() {
        return pruefungsResult;
    }
}
