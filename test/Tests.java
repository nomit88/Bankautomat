/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import bankautomat.Anzeige;
import bankautomat.Bancomat;
import bankautomat.DBConnection;
import bankautomat.DBHelper;
import bankautomat.Karte;
import bankautomat.LokalePruefung;
import bankautomat.OnlinePruefung;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author timon
 */
public class Tests {

    private String testIban = "TEST0Valid0000000000088";
    private String testIban2 = "TEST0Valid0000000000099";
    private String testIban3 = "TEST0Valid0000000000100";
    private String testIban4 = "TEST0Valid0000000000120";

    public Tests() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void checkDbConnect() {
        bankautomat.DBConnection dBConnection = new DBConnection();
        assertTrue(dBConnection.getConnection() != null);
    }

    @Test
    public void lokalePruefungKarteValid() {
        bankautomat.DBConnection dBConnection = new DBConnection();
        Connection connection = dBConnection.getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            String query = "INSERT INTO `karte` (`iban`,`gueltigbis`) VALUES ('" + testIban + "','10/22')";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }

        bankautomat.LokalePruefung lokalePruefung = new LokalePruefung();
        lokalePruefung.fuehrePruefungDurch(testIban);
        assertTrue(lokalePruefung.pruefungsresultat());

        // Cleanup
        try {

            statement = connection.createStatement();
            String query = "Delete FROM `karte` WHERE iban = '" + testIban + "'";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void lokalePruefungKarteInValidYear() {
        bankautomat.DBConnection dBConnection = new DBConnection();
        Connection connection = dBConnection.getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            String query = "INSERT INTO `karte` (`iban`,`gueltigbis`) VALUES ('" + testIban2 + "','10/10')";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }

        bankautomat.LokalePruefung lokalePruefung = new LokalePruefung();
        lokalePruefung.fuehrePruefungDurch(testIban2);
        assertFalse(lokalePruefung.pruefungsresultat());

        // Cleanup
        try {
            statement = connection.createStatement();
            String query = "Delete FROM `karte` WHERE iban = '" + testIban2 + "'";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void lokalePruefungKarteInValidMonth() {
        bankautomat.DBConnection dBConnection = new DBConnection();
        Connection connection = dBConnection.getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            String query = "INSERT INTO `karte` (`iban`,`gueltigbis`) VALUES ('" + testIban2 + "','00/20')";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }

        bankautomat.LokalePruefung lokalePruefung = new LokalePruefung();
        lokalePruefung.fuehrePruefungDurch(testIban2);
        assertFalse(lokalePruefung.pruefungsresultat());

        // Cleanup
        try {

            statement = connection.createStatement();
            String query = "Delete FROM `karte` WHERE iban = '" + testIban2 + "'";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void gesperteKartenContainsSpecificCard() {
        bankautomat.DBConnection dBConnection = new DBConnection();
        Connection connection = dBConnection.getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            String query = "INSERT INTO `karte` (`iban`) VALUES ('" + testIban + "')";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }
        bankautomat.DBHelper dbHelper = new DBHelper();
        Karte specificCard = dbHelper.getKarte(testIban);
        dbHelper.karteSperren(specificCard.getIban());
        ArrayList<String> gesperteKarten = dbHelper.getGesperteKarten();
        assertTrue(gesperteKarten.contains(specificCard.getIban()));

        // Cleanup
        try {
            statement = connection.createStatement();
            String query = "Delete FROM `kartegesperrt` WHERE iban = '" + testIban + "'";
            statement.execute(query);
            statement = connection.createStatement();
            query = "Delete FROM `karte` WHERE iban = '" + testIban + "'";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void onlinePruefungInValid() {

        bankautomat.DBConnection dBConnection = new DBConnection();

        Connection connection = dBConnection.getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            String query = "INSERT INTO `bank` (`iban`) VALUES ('" + testIban + "')";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }

        bankautomat.OnlinePruefung onlinePruefung = new OnlinePruefung();
        onlinePruefung.fuehrePruefungDurch(testIban);
        assertFalse(onlinePruefung.pruefungsresultat());

        // Cleanup
        try {
            statement = connection.createStatement();
            String query = "Delete FROM `bank` WHERE iban = '" + testIban + "'";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void pinAendernNewValid() {
        int pincode = 12345;
        bankautomat.DBConnection dBConnection = new DBConnection();
        DBHelper helper = new DBHelper();

        Connection connection = dBConnection.getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            String query = "INSERT INTO `karte` (`iban`,`pincode`) VALUES ('" + testIban + "','" + pincode + "')";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }

        bankautomat.Bancomat bankomat = new Bancomat();

        assertTrue(bankomat.pincodeAendern(helper.getKarte(testIban), "123654")[1] == "1" && helper.getKarte(testIban).getPincode() != pincode);

        // Cleanup
        try {
            statement = connection.createStatement();
            String query = "Delete FROM `karte` WHERE iban = '" + testIban + "'";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void pinAendernInValid() {
        int pincode = 12345;
        bankautomat.DBConnection dBConnection = new DBConnection();
        DBHelper helper = new DBHelper();

        Connection connection = dBConnection.getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            String query = "INSERT INTO `karte` (`iban`,`pincode`) VALUES ('" + testIban + "','" + pincode + "')";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }

        bankautomat.Bancomat bankomat = new Bancomat();

        String[] result = bankomat.pincodeAendern(helper.getKarte(testIban), "123654");
        assertFalse(result[1] == "0");

        // Cleanup
        try {
            statement = connection.createStatement();
            String query = "Delete FROM `karte` WHERE iban = '" + testIban + "'";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void pinPruefenValid() {
        int pincode = 12345;
        bankautomat.DBConnection dBConnection = new DBConnection();
        DBHelper helper = new DBHelper();

        Connection connection = dBConnection.getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            String query = "INSERT INTO `karte` (`iban`,`pincode`) VALUES ('" + testIban3 + "','" + pincode + "')";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }

        bankautomat.Bancomat bankomat = new Bancomat();

        assertTrue(bankomat.pincodePrüfen(helper.getKarte(testIban3), pincode));

        // Cleanup
        try {
            statement = connection.createStatement();
            String query = "Delete FROM `karte` WHERE iban = '" + testIban3 + "'";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void pinPruefenInValid() {
        int pincode = 12345;
        bankautomat.DBConnection dBConnection = new DBConnection();
        DBHelper helper = new DBHelper();

        Connection connection = dBConnection.getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            String query = "INSERT INTO `karte` (`iban`,`pincode`) VALUES ('" + testIban3 + "','" + pincode + "')";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }

        bankautomat.Bancomat bankomat = new Bancomat();
        pincode++;
        assertFalse(bankomat.pincodePrüfen(helper.getKarte(testIban3), pincode));

        // Cleanup
        try {
            statement = connection.createStatement();
            String query = "Delete FROM `karte` WHERE iban = '" + testIban3 + "'";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void geldAbhebenMoreThanSaldoInvalid() {
        bankautomat.DBConnection dBConnection = new DBConnection();

        Connection connection = dBConnection.getConnection();
         DBHelper helper = new DBHelper();

        Statement statement;
        try {
            statement = connection.createStatement();
            String query = "INSERT INTO `bank` (`iban`,`gesperrt`,`saldo`,`bezugslimite`,`bereitsbezogenesgeld`) VALUES ('" + testIban4 + "',0,50,5000,10)";
            statement.execute(query);
            statement = connection.createStatement();
            query = "INSERT INTO `karte` (`iban`) VALUES ('" + testIban4 + "')";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }

        bankautomat.Bancomat bancomat = new Bancomat();
        System.out.println(helper.getAllKassetten().get(1).getNote());
        int anz50 = helper.getAllKassetten().get(1).getMenge();
        bancomat.geldAbheben(70, helper.getKarte(testIban4));
        assertTrue(anz50 == helper.getAllKassetten().get(1).getMenge());

        // Cleanup
        try {
            statement = connection.createStatement();
            String query = "Delete FROM `bank` WHERE iban = '" + testIban4 + "'";
            statement.execute(query);
            statement = connection.createStatement();
            query = "Delete FROM `karte` WHERE iban = '" + testIban4 + "'";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void geldAbhebenMoreThanBezugslimiteInvalid() {
        bankautomat.DBConnection dBConnection = new DBConnection();

        Connection connection = dBConnection.getConnection();
         DBHelper helper = new DBHelper();

        Statement statement;
        try {
            statement = connection.createStatement();
            String query = "INSERT INTO `bank` (`iban`,`gesperrt`,`saldo`,`bezugslimite`,`bereitsbezogenesgeld`) VALUES ('" + testIban4 + "',0,5000,50,10)";
            statement.execute(query);
            statement = connection.createStatement();
            query = "INSERT INTO `karte` (`iban`) VALUES ('" + testIban4 + "')";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }

        bankautomat.Bancomat bancomat = new Bancomat();
        System.out.println(helper.getAllKassetten().get(1).getNote());
        int anz50 = helper.getAllKassetten().get(1).getMenge();
        bancomat.geldAbheben(70, helper.getKarte(testIban4));
        assertTrue(anz50 == helper.getAllKassetten().get(1).getMenge());

        // Cleanup
        try {
            statement = connection.createStatement();
            String query = "Delete FROM `bank` WHERE iban = '" + testIban4 + "'";
            statement.execute(query);
            statement = connection.createStatement();
            query = "Delete FROM `karte` WHERE iban = '" + testIban4 + "'";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
