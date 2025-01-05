package PackageResponsabile;

import java.sql.*;
import java.util.ArrayList;

public class ResponsabileDAO implements ResponsabileDataInterface {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/breakingbread";
    private static final String DB_USERNAME = "brakingBread"; // Cambia con il tuo username
    private static final String DB_PASSWORD = "breakingbread1"; // Cambia con la tua password

    private static final String INSERT_RESPONSABILE = "INSERT INTO responsabile (nome, username, password) VALUES (?, ?, ?)";
    private static final String SELECT_RESPONSABILE_BY_ID = "SELECT * FROM responsabile WHERE id = ?";
    private static final String SELECT_RESPONSABILE_BY_USERNAME = "SELECT * FROM responsabile WHERE username = ?";
    private static final String SELECT_ALL_RESPONSABILI = "SELECT * FROM responsabile";
    private static final String UPDATE_RESPONSABILE = "UPDATE responsabile SET nome = ?, username = ?, password = ? WHERE id = ?";
    private static final String DELETE_RESPONSABILE = "DELETE FROM responsabile WHERE id = ?";

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    @Override
    public boolean setResponsabile(Responsabile responsabile) {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_RESPONSABILE)) {
            statement.setString(1, responsabile.getNome());
            statement.setString(2, responsabile.getUsername());
            statement.setString(3, responsabile.getPassword());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Responsabile getResponsabileById(int id) {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_RESPONSABILE_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Responsabile responsabile = new Responsabile();
                int idTMP = resultSet.getInt("id");
                responsabile.setID(idTMP);
                responsabile.setNome(resultSet.getString("nome"));
                responsabile.setUsername(resultSet.getString("username"));
                responsabile.setPassword(resultSet.getString("password"));

                OrdineDataInterface ordineDataInterface = new OrdineDAO();
                responsabile.setOrdini(ordineDataInterface.getAllOrdiniByResponsabileId(idTMP));

                return responsabile;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Responsabile> getAllResponsabili() {
        ArrayList<Responsabile> responsabili = new ArrayList<>();
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_RESPONSABILI);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Responsabile responsabile = new Responsabile();
                int idTMP = resultSet.getInt("id");
                responsabile.setID(idTMP);
                responsabile.setNome(resultSet.getString("nome"));
                responsabile.setUsername(resultSet.getString("username"));
                responsabile.setPassword(resultSet.getString("password"));

                OrdineDataInterface ordineDataInterface = new OrdineDAO();
                responsabile.setOrdini(ordineDataInterface.getAllOrdiniByResponsabileId(idTMP));

                responsabili.add(responsabile);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return responsabili;
    }

    @Override
    public boolean updateResponsabile(Responsabile responsabile) {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_RESPONSABILE)) {
            statement.setString(1, responsabile.getNome());
            statement.setString(2, responsabile.getUsername());
            statement.setString(3, responsabile.getPassword());
            statement.setInt(4, responsabile.getID());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteResponsabile(int id) {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_RESPONSABILE)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
