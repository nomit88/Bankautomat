package bankautomat;

public class RemoteBankSystem {

    private static DBHelper dbHelper = new DBHelper();

    public boolean pruefeKonto(String iban) {
        return dbHelper.pruefeKonto(iban);
    }

    public String saldoAbfragen(String iban) {
        return dbHelper.saldoAbfragen(iban);
    }

    public String geldAbheben(int menge, Karte karte) {
        int[] values = dbHelper.getBankValues(karte.getIban());
        int bezugslimite = values[0];
        int verfuegbarerSaldo = values[1];
        int bereitsBezogenesGeld = values[2];
        int saldoZumAbheben = menge + bereitsBezogenesGeld;
        if (saldoZumAbheben <= bezugslimite || saldoZumAbheben < verfuegbarerSaldo) {
            verfuegbarerSaldo -= menge;
            bereitsBezogenesGeld += menge;
            dbHelper.geldAbheben(menge, karte.getIban(), verfuegbarerSaldo, bereitsBezogenesGeld);
        } else {
            if (saldoZumAbheben > bezugslimite) {
                kontoSperren(karte.getIban());
                return "Bezugslimite überschritten! Ihr Konto wird gesperrt.";
            } else {
                return "Den Betrag, welchen Sie abheben möchten ist grösser, als Ihr verfügbarer Saldo!";
            }
        }
        return "";
    }

    public void kontoSperren(String iban) {
        dbHelper.kontoSperren(iban);
    }
}
