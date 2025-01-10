package PackageUtils;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseConnectionInterface {
    public Connection createConnection() throws SQLException;
}
