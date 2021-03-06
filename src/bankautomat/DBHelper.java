package bankautomat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Die Klasse DBHelper. Diese Klasse kann implementiert werden um funktionen auf
 * der Db durchzuführen.
 *
 * @author Timon Kindler & Lars Flury
 */
public class DBHelper {

    DBConnection dbConn = new DBConnection();
    private Connection connection;

    public DBHelper() {
        this.connection = dbConn.getConnection();
    }

    /**
     * Holt alle Karten aus der Db
     *
     * @return gibt die Karten als ArrayList zurück
     */
    public ArrayList<Karte> getKarten() {
        ArrayList datas = new ArrayList();

        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM karte";
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                datas.add(new Karte(result.getString("name"), result.getString("vorname"), result.getString("iban"), result.getString("bankbezeichnung"),
                        result.getInt("kartennummer"), result.getString("gueltigbis"), result.getInt("pincode")));
            }
        } catch (SQLException ex) {
            System.err.println("Err:" + ex);
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return datas;
    }

    /**
     * Holt eine Spezifische Karte aus der Db
     *
     * @param iban iban der Karte
     * @return Gibt die spezifische Karte zurück
     */
    public Karte getKarte(String iban) {
        Karte karte = null;
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM karte WHERE iban = '"+iban+"'";
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
            karte = new Karte(result.getString("name"), result.getString("vorname"), result.getString("iban"), result.getString("bankbezeichnung"),
                    result.getInt("kartennummer"), result.getString("gueltigbis"), result.getInt("pincode"));
            }
        } catch (SQLException ex) {
            System.err.println("Err:" + ex);
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return karte;
    }

    /**
     * Sperrt eine Karte auf der DB
     *
     * @param iban Die iban der zu sperenden Karte
     */
    public void karteSperren(String iban) {
        Statement statement;
        try {
            statement = connection.createStatement();
            String query = "INSERT INTO `kartegesperrt` (`iban`) VALUES ('" + iban + "')";
            statement.execute(query);
        } catch (SQLException ex) {
            System.err.println("Err:" + ex);
            Logger
                    .getLogger(DBHelper.class
                            .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Ändert den Pin einer Karte
     *
     * @param iban die iban der Karte
     * @param newPin der Neue Pin für die Karte
     */
    public void pinAendern(String iban, int newPin) {
        Statement statement;
        try {
            statement = connection.createStatement();
            String query = "UPDATE karte SET pincode='" + newPin + "' WHERE iban='" + iban + "'";
            statement.execute(query);
        } catch (SQLException ex) {
            System.err.println("Err:" + ex);
            Logger
                    .getLogger(DBHelper.class
                            .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Hollt alle ibans der gesperten Karten aus der DB
     *
     * @return Gibt die ibans der gesperten Karten als ArrayList zurück.
     */
    public ArrayList<String> getGesperteKarten() {
        ArrayList datas = new ArrayList();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM kartegesperrt";
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                datas.add(result.getString("iban"));
            }
        } catch (SQLException ex) {
            System.err.println("Err:" + ex);
            Logger
                    .getLogger(DBHelper.class
                            .getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }

    /**
     *
     * @param iban Die Karte, von der die Bezugslimite geholt werden soll.
     * @return Ein Array, mit den Werten welche benötigt werden. [0] =
     * Bezugslimite [1] = Saldo [2] = Bereits bezogenes Geld
     */
    public int[] getBankValues(String iban) {
        int[] values = new int[3];
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM bank WHERE iban LIKE '" + iban + "'";
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                values[2] = result.getInt("bereitsbezogenesgeld");
                values[0] = result.getInt("bezugslimite");
                values[1] = result.getInt("saldo");

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return values;
    }

    /**
     * Hebt einen gewissen Betrag von dem Konto ab
     *
     * @param menge Die Menge, welche abgehoben werden soll
     * @param iban Die Iban, mit der das Konto, von dem Geld abgehoben werden
     * soll verbunden ist
     * @param verfuegbarerSaldo Der verfügbare Saldo, welche noch abgehoben
     * werden kann
     * @param bereitsBezogenesGeld Das Bereits bezogene Geld auf diesem Konto
     */
    public void geldAbheben(int menge, String iban, int verfuegbarerSaldo, int bereitsBezogenesGeld) {
        try {
            Statement statement = connection.createStatement();
            String query = "UPDATE bank SET saldo = " + verfuegbarerSaldo + ", bereitsbezogenesgeld = " + bereitsBezogenesGeld + " WHERE iban LIKE '" + iban + "';";
            statement.executeUpdate(query);

        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Gibt den verfügbaren Saldo eines Kontos zurück
     *
     * @param iban Die Iban, welche mit dem Konto verbunden ist
     * @return Der verfügbare Saldo
     */
    public String saldoAbfragen(String iban) {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT saldo FROM bank WHERE iban LIKE '" + iban + "'";
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("saldo");

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    /**
     * Sperrt ein Konto
     *
     * @param iban Die Iban der Karte von dem Konto, was gesperrt werden soll.
     */
    public void kontoSperren(String iban) {
        try {
            Statement statement = connection.createStatement();
            String query = "UPDATE bank SET gesperrt = 1 WHERE iban LIKE '" + iban + "';";
            statement.executeUpdate(query);

        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Prüft ob das Konto gespert ist.
     *
     * @param iban iban des Kontos
     * @return bool ob das Konto gespert ist
     */
    public boolean pruefeKonto(String iban) {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT gesperrt FROM bank WHERE iban LIKE '" + iban + "'";
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                return result.getInt("gesperrt") == 1 ? true : false;

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Hollt alle Geldkasseten aus der DB
     *
     * @return Gibt die Geldkasseten als ArrayList zurück.
     */
    public ArrayList<Geldkassette> getAllKassetten() {
        ArrayList<Geldkassette> kassetten = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM geldkassette";
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                kassetten.add(new Geldkassette(result.getInt("anzahl"), result.getInt("note")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return kassetten;
    }

    /**
     * Updated die Geldkasseten
     *
     * @param kassette die zu updatende Geldkassete
     */
    public void updateGeldkassette(Geldkassette kassette) {
        try {
            Statement statement = connection.createStatement();
            String query = "UPDATE geldkassette SET anzahl = " + kassette.getMenge() + " WHERE note = " + kassette.getNote();
            statement.executeUpdate(query);

        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
