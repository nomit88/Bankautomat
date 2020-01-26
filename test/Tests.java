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

    private String testIban1 = "TEST0Valid0000000000088";

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
            String query = "INSERT INTO `karte` (`iban`,`gueltigbis`) VALUES ('" + testIban1 + "','10/22')";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }

        bankautomat.LokalePruefung lokalePruefung = new LokalePruefung();
        lokalePruefung.fuehrePruefungDurch(testIban1);

        // Cleanup
        try {

            statement = connection.createStatement();
            String query = "Delete FROM `karte` WHERE iban = '" + testIban1 + "'";
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
            String query = "INSERT INTO `karte` (`iban`) VALUES ('" + testIban1 + "')";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }
        bankautomat.DBHelper dbHelper = new DBHelper();
        Karte specificCard = dbHelper.getKarte(testIban1);
        dbHelper.karteSperren(specificCard.getIban());
        ArrayList<String> gesperteKarten = dbHelper.getGesperteKarten();
        assertTrue(gesperteKarten.contains(specificCard.getIban()));

        // Cleanup
        try {
            statement = connection.createStatement();
            String query = "Delete FROM `kartegesperrt` WHERE iban = '" + testIban1 + "'";
            statement.execute(query);
            statement = connection.createStatement();
            query = "Delete FROM `karte` WHERE iban = '" + testIban1 + "'";
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
