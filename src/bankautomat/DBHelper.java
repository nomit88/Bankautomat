package bankautomat;

import java.sql.Connection;

public class DBHelper {
    private Connection connection;

    public DBHelper(Connection connection) {
        this.connection = connection;
    }

    /**
     * Holt alle Ausgaben aus der DB
     *
     * @return
     */
}
