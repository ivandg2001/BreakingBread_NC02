package PackageResponsabile;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResponsabileDAO implements ResponsabileDataInterface{

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/breakingbread";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "ivan2001";

    private static final String INSERT_ORDINE_SQL = """
        INSERT INTO ordine (data_ordine, costo, lotto_id, responsabile_id, priorita)
        VALUES (?, ?, ?, ?, ?);
    """;



    public void creaOrdine(Ordine ordine) throws SQLException {

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDINE_SQL)) {

            preparedStatement.setDate(1, java.sql.Date.valueOf(ordine.getDataOrdine()));
            preparedStatement.setDouble(2, ordine.getCosto());
            preparedStatement.setInt(3, ordine.getLotto().getID());
            preparedStatement.setInt(4, ordine.getResponsabile().getID());
            preparedStatement.setInt(5, ordine.getPriorita());

            preparedStatement.executeUpdate();
        }
    }
}
