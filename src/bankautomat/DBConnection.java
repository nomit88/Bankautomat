package bankautomat;

import java.sql.*;
/**
 *  Diese Klasse stellt eine Verbindung zur DB zur verfügung.
 * @author Timon Kindler & Lars Flury
 */
    public class DBConnection {

        private final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/bankautomat?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        private final String USER_DB = "root";
        private final String PASSWORD_DB = "";

        private Connection connection = null;
        /**
         * Gibt die Connection zurück
         * @return die Connection zur DB
         */
        public Connection getConnection() {
            return connection;
        }
        /**
         * Ertsellt die verbindung zu der DatenBank
         */
        public DBConnection() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                if (this.connection == null) {
                    this.connection = (Connection) DriverManager.getConnection(CONNECTION_STRING, USER_DB, PASSWORD_DB);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.exit(0);
            } catch (SQLException e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
    }

