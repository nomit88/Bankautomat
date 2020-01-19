package bankautomat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBHelper {

    DBConnection dbConn = new DBConnection();
    private Connection connection;

    public DBHelper() {
        this.connection = dbConn.getConnection();
    }

    public ArrayList<Karte> getKarten() {
        ArrayList datas = new ArrayList();

        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM karte";
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                datas.add(new Karte(result.getString("name"), result.getString("vorname"),
                        result.getInt("kontonummer"), result.getString("iban"), result.getString("bankbezeichnung"),
                        result.getInt("kartennummer"), result.getString("gueltigbis"), result.getInt("pincode")));
            }
        } catch (SQLException ex) {
            System.err.println("Err:" + ex);
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return datas;
    }

    public void karteSperren(String iban) {
        Statement statement;
        try {
            statement = connection.createStatement();
            String query = "INSERT INTO `kartegesperrt` (`iban`) VALUES ('" + iban + "')";
            statement.execute(query);
        } catch (SQLException ex) {
            System.err.println("Err:" + ex);
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void pinAendern(String iban,int newPin ) {
        Statement statement;
        try {
            statement = connection.createStatement();
            String query = "UPDATE karte SET pincode='"+newPin+"' WHERE iban='"+iban+"'";
            statement.execute(query);
        } catch (SQLException ex) {
            System.err.println("Err:" + ex);
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }

    /**
     * 
     * @param iban Die Karte, von der die Bezugslimite geholt werden soll.
     * @return Ein Array, mit den Werten welche benötigt werden. 
     * [0] = Bezugslimite
     * [1] = Saldo
     * [2] = Bereits bezogenes Geld
     */
    public int [] getBankValues(String iban){
        int[] values = new int[3];
         try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM bank WHERE iban LIKE '"+iban+ "'";
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                values[2] = result.getInt("bereitsbezogenesgeld");
                values[0] = result.getInt("bezugslimite");
                values[1] = result.getInt("saldo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return values;
    }
    
    public void geldAbheben(int menge, String iban, int verfuegbarerSaldo, int bereitsBezogenesGeld){
        try {
            Statement statement = connection.createStatement();
            String query = "UPDATE bank SET saldo = "+verfuegbarerSaldo +", bereitsbezogenesgeld = " + bereitsBezogenesGeld + " WHERE iban LIKE '"+iban+"';";
            statement.executeUpdate(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String saldoAbfragen(String iban){
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT saldo FROM bank WHERE iban LIKE '"+iban+ "'";
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("saldo");
            }   
            
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    /**
     * Holt alle Ausgaben aus der DB
     *
     * @return
     */
}
