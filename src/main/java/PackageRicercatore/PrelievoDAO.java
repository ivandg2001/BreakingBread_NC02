package PackageRicercatore;

import java.sql.*;
import java.util.ArrayList;

public class PrelievoDAO implements PrelievoDataInterface {

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
            "INSERT INTO prelievo (data, quantita, lotto_id, ricercatore_id) VALUES (?, ?, ?, ?)";
    private static final String SELECT_BY_ID =
            "SELECT * FROM prelievo WHERE id = ?";
    private static final String SELECT_ALL =
            "SELECT * FROM prelievo";
    private static final String UPDATE =
            "UPDATE prelievo SET data = ?, quantita = ?, lotto_id = ?, ricercatore_id = ? WHERE id = ?";
    private static final String DELETE =
            "DELETE FROM prelievo WHERE id = ?";
    private static final String SELECT_ALL_BY_RICERCATORE =
            "SELECT * FROM prelievo WHERE ricercatore_id = ?";

    public PrelievoDAO() {}

    /**
     * Inserisce un nuovo Prelievo nel database.
     *
     * @param prelievo Oggetto Prelievo da inserire.
     * @return true se l'inserimento è avvenuto con successo, false altrimenti.
     */
    @Override
    public boolean setPrelievo(Prelievo prelievo) {
        try {

            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);

            preparedStatement.setDate(1, Date.valueOf(prelievo.getData()));
            preparedStatement.setDouble(2, prelievo.getQuantita());
            preparedStatement.setInt(3, prelievo.getLotto().getID());
            preparedStatement.setInt(4, prelievo.getRicercatore().getID());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Recupera un Prelievo dal database tramite il suo ID.
     *
     * @param id L'ID del Prelievo da recuperare.
     * @return Oggetto Prelievo corrispondente all'ID; null in caso di errore.
     */
    @Override
    public Prelievo getPrelievo(int id) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Prelievo prelievo = new Prelievo();

                prelievo.setID(rs.getInt("id"));
                prelievo.setData(rs.getDate("data").toLocalDate());
                prelievo.setQuantita(rs.getDouble("quantita"));

                //da gestire nell'oggetto entity stesso
                /*
                ArmadiettoGetDataInterface armadiettoDAO = new ArmadiettoFacade();
                Lotto lotto = armadiettoDAO.getLottoByID(rs.getInt("lotto_id"));
                prelievo.setLotto(lotto);

                RicercatoreDataInterface ricercatoreDAO = new RicercatoreDAO();
                Ricercatore ricercatore = ricercatoreDAO.getRicercatore(rs.getInt("responsabile_id"));
                prelievo.setRicercatore(ricercatore);

                 */

                return prelievo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Recupera tutti i Prelievo presenti nel database.
     *
     * @return Una lista di oggetti Prelievo.
     */
    @Override
    public ArrayList<Prelievo> getAllPrelievi() {
        ArrayList<Prelievo> prelievi = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL);

            while (rs.next()) {
                Prelievo prelievo = new Prelievo();
                prelievo.setID(rs.getInt("id"));
                prelievo.setData(rs.getDate("data").toLocalDate());
                prelievo.setQuantita(rs.getDouble("quantita"));

                prelievi.add(prelievo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prelievi;
    }

    /**
     * Aggiorna le informazioni di un Prelievo nel database.
     *
     * @param prelievo Oggetto Prelievo con le nuove informazioni.
     * @return true se l'aggiornamento è avvenuto con successo, false altrimenti.
     */
    @Override
    public boolean updatePrelievo(Prelievo prelievo) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);

            preparedStatement.setDate(1, Date.valueOf(prelievo.getData()));
            preparedStatement.setDouble(2, prelievo.getQuantita());
            preparedStatement.setInt(3, prelievo.getLotto().getID());
            preparedStatement.setInt(4, prelievo.getRicercatore().getID());
            preparedStatement.setInt(5, prelievo.getID());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Elimina un Prelievo dal database.
     *
     * @param prelievo Il Prelievo da eliminare.
     * @return true se l'eliminazione è avvenuta con successo, false altrimenti.
     */
    @Override
    public boolean deletePrelievo(Prelievo prelievo) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);

            preparedStatement.setInt(1, prelievo.getID());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * TODO
     */
    @Override
    public ArrayList<Prelievo> getAllPrelieviByRicercatore(Ricercatore ricercatore) {
        ArrayList<Prelievo> prelievi = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL_BY_RICERCATORE);

            while (rs.next()) {
                Prelievo prelievo = new Prelievo();
                prelievo.setID(rs.getInt("id"));
                prelievo.setData(rs.getDate("data").toLocalDate());
                prelievo.setQuantita(rs.getDouble("quantita"));

                prelievi.add(prelievo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prelievi;
    }
}
