package PackageRicercatore;

import java.sql.*;
import java.util.ArrayList;

public class RicercatoreDAO implements RicercatoreDataInterface{

    /**
     * URL database
     */
    private static final String DB_URL = "jdbc:mysql://localhost:3306/breakingbread";
    /**
     * Username profilo per il database
     */
    private static final String DB_USER = "breakingBread";
    /**
     * Password per il database
     */
    private static final String DB_PASSWORD = "breakingbread1";

    private static final String INSERT =
            "INSERT INTO ricercatore (nome, username, password, team_id) VALUES (?, ?, ?, ?)";
    private static final String SELECT_BY_ID =
            "SELECT * FROM ricercatore WHERE id = ?";
    private static final String SELECT_ALL =
            "SELECT * FROM ricercatore";
    private static final String UPDATE =
            "UPDATE ricercatore SET data = ?, quantita = ?, lotto_id = ?, ricercatore_id = ? WHERE id = ?";
    private static final String DELETE =
            "DELETE FROM ricercatore WHERE id = ?";

    public RicercatoreDAO() {}

    /**
     * Inserisce un nuovo Ricercatore nel database.
     *
     * @param ricercatore Oggetto Ricercatore da inserire.
     * @return true se l'inserimento è avvenuto con successo, false altrimenti.
     */
    @Override
    public boolean setRicercatore(Ricercatore ricercatore) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {

            preparedStatement.setString(1, ricercatore.getNome());
            preparedStatement.setString(2, ricercatore.getUsername());
            preparedStatement.setString(3, ricercatore.getPassword());
            preparedStatement.setInt(4, ricercatore.getTeam().getID());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Recupera un Ricercatore dal database tramite il suo ID.
     *
     * @param id L'ID del Ricercatore da recuperare.
     * @return Oggetto Ricercatore corrispondente all'ID; null in caso di errore.
     */
    @Override
    public Ricercatore getRicercatore(int id) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Ricercatore ricercatore = new Ricercatore();

                ricercatore.setID(rs.getInt("id"));
                ricercatore.setNome(rs.getString("username"));
                ricercatore.setPassword(rs.getString("password"));

                return ricercatore;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Recupera tutti i Ricercatore presenti nel database.
     *
     * @return Una lista di oggetti Ricercatore.
     */
    @Override
    public ArrayList<Ricercatore> getAllRicercatore() {
        ArrayList<Ricercatore> ricercatori = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL);

            while (rs.next()) {
                Ricercatore ricercatore = new Ricercatore();

                ricercatore.setID(rs.getInt("id"));
                ricercatore.setNome(rs.getString("username"));
                ricercatore.setPassword(rs.getString("password"));

                //da gestire nell'oggetto entity stesso
                /*
                ArmadiettoGetDataInterface armadiettoDAO = new ArmadiettoFacade();
                Lotto lotto = armadiettoDAO.getLottoByID(rs.getInt("lotto_id"));
                prelievo.setLotto(lotto);

                ResponsabileDataInterface responsabileDAO = new ResponsabileDAO();
                Responsabile responsabile = responsabileDAO.getResponsabileById(rs.getInt("responsabile_id"));
                prelievo.setResponsabile(responsabile);

                 */

                ricercatori.add(ricercatore);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ricercatori;
    }

    /**
     * Aggiorna le informazioni di un Ricercatore nel database.
     *
     * @param ricercatore Oggetto Ricercatore con le nuove informazioni.
     * @return true se l'aggiornamento è avvenuto con successo, false altrimenti.
     */
    @Override
    public boolean updateRicercatore(Ricercatore ricercatore) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);

            preparedStatement.setInt(5, ricercatore.getID());
            preparedStatement.setString(1, ricercatore.getNome());
            preparedStatement.setString(2, ricercatore.getUsername());
            preparedStatement.setString(3, ricercatore.getPassword());
            preparedStatement.setInt(4, ricercatore.getTeam().getID());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Elimina un Ricercatore dal database.
     *
     * @param ricercatore Il Ricercatore da eliminare.
     * @return true se l'eliminazione è avvenuta con successo, false altrimenti.
     */
    @Override
    public boolean deleteRicercatore(Ricercatore ricercatore) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);

            preparedStatement.setInt(1, ricercatore.getID());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
