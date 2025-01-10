package PackageUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionDAO implements DatabaseConnectionInterface {

    /**
     * Url del database
     */
    private static final String DB_URL = "jdbc:mysql://localhost:3306/breakingbread";
    /**
     * Username profilo per il database.
     */
    private static final String DB_USER = "breakingBread";
    /**
     * password per il database.
     */
    private static final String DB_PASSWORD = "breakingbread1";

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

}
