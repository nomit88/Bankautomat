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
    
    public ArrayList<Karte> getKarten(){
          ArrayList datas = new ArrayList();

        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM karte";
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                datas.add(new Karte(result.getString("name"),result.getString("vorname"),
                result.getInt("kontonummer"),result.getString("iban"),result.getString("bankbezeichnung"),
                result.getInt("kartennummer"),result.getString("gueltigbis"),result.getInt("pincode")));
            }
        } catch (SQLException ex) {
            System.err.println("Err:" + ex);
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return datas;
    }

    /**
     * Holt alle Ausgaben aus der DB
     *
     * @return
     */
}
