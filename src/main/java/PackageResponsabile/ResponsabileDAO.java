package PackageResponsabile;

import java.sql.*;
import java.util.ArrayList;

/**
 * Classe dao che gestisce il database per gli oggetti Responsabile
 */
public class ResponsabileDAO implements ResponsabileDataInterface {

    /**
     * Url del database
     */
    private static final String DB_URL = "jdbc:mysql://localhost:3306/breakingbread";
    /**
     * User del database
     */
    private static final String DB_USER = "breakingBread";
    /**
     * Password per l'user
     */
    private static final String DB_PASSWORD = "breakingbread1";

    /**
     * Query per l'inserimneto di un Responsabile
     */
    private static final String INSERT_RESPONSABILE = "INSERT INTO responsabile (nome, username, password) VALUES (?, ?, ?)";
    /**
     * Query per la selezione di un Responsabile tramite ID
     */
    private static final String SELECT_RESPONSABILE_BY_ID = "SELECT * FROM responsabile WHERE id = ?";
    /**
     * Query per la selezione di tutti i responsabili
     */
    private static final String SELECT_ALL_RESPONSABILI = "SELECT * FROM responsabile";
    /**
     * Query per l'update di un responsabile tramite ID
     */
    private static final String UPDATE_RESPONSABILE = "UPDATE responsabile SET nome = ?, username = ?, password = ? WHERE id = ?";
    /**
     * Query per l'eliminazione di un reposabile tramite ID
     */
    private static final String DELETE_RESPONSABILE = "DELETE FROM responsabile WHERE id = ?";

    /**
     * Metodo che crea la connessione al database
     * @return oggetto Connection
     * @throws SQLException
     */
    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    /**
     * Inserisce un nuovo responsabile nel database.
     *
     * @param responsabile Oggetto Responsabile da inserire.
     * @return true se l'inserimento è avvenuto con successo, false altrimenti.
     */
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

    /**
     * Recupera un responsabile dal database tramite il suo ID.
     *
     * @param id L'ID del responsabile da recuperare.
     * @return Oggetto Responsabile corrispondente all'ID.
     */
    @Override
    public Responsabile getResponsabileById(int id) {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_RESPONSABILE_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Responsabile responsabile = new Responsabile();
                responsabile.setID(resultSet.getInt("id"));
                responsabile.setNome(resultSet.getString("nome"));
                responsabile.setUsername(resultSet.getString("username"));
                responsabile.setPassword(resultSet.getString("password"));


                return responsabile;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Recupera tutti i responsabili presenti nel database.
     *
     * @return Una lista di oggetti Responsabile.
     */
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



                responsabili.add(responsabile);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return responsabili;
    }

    /**
     * Aggiorna le informazioni di un responsabile nel database.
     *
     * @param responsabile Oggetto Responsabile con le nuove informazioni.
     * @return true se l'aggiornamento è avvenuto con successo, false altrimenti.
     */
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

    /**
     * Elimina un responsabile dal database tramite il suo ID.
     *
     * @param id L'ID del responsabile da eliminare.
     * @return true se l'eliminazione è avvenuta con successo, false altrimenti.
     */
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
