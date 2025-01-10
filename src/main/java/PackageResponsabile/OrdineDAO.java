package PackageResponsabile;

import PackageArmadietto.ArmadiettoFacade;
import PackageArmadietto.ArmadiettoGetDataInterface;
import PackageArmadietto.Lotto;
import PackageUtils.DatabaseConnectionDAO;
import PackageUtils.DatabaseConnectionInterface;

import java.sql.*;
import java.util.ArrayList;

/**
 * Classe DAO che gestisce il database per gli oggetti Ordine
 */
public class OrdineDAO implements OrdineDataInterface {



    /**
     * Query per l'inserimento in database di un nuovo Ordine.
     */
    private static final String INSERT_ORDINE =
            "INSERT INTO ordine (data_ordine, costo, lotto_id, responsabile_id, priorita) VALUES (?, ?, ?, ?, ?)";
    /**
     * QUery per riprendere un ordine dal database per ID.
     */
    private static final String SELECT_ORDINE_BY_ID =
            "SELECT * FROM ordine WHERE id = ?";
    /**
     * Query per riprendere tutti gli ordini dal database.
     */
    private static final String SELECT_ALL_ORDINI =
            "SELECT * FROM ordine";
    /**
     * Query per aggiornare un ordine nel database , selezionato dall'ID.
     */
    private static final String UPDATE_ORDINE =
            "UPDATE ordine SET data_ordine = ?, costo = ?, lotto_id = ?, responsabile_id = ?, priorita = ? WHERE id = ?";
    /**
     * Query per eliminare un ordine dal database tramite ID.
     */
    private static final String DELETE_ORDINE =
            "DELETE FROM ordine WHERE id = ?";
    /**
     * Query per rirpendere tutti gli ordini di un responsabile tramite ID del responsabile.
     */
    private static final String SELECT_ALL_ORDINI_BY_RESPONSABILE_ID =
            "SELECT * FROM ordine WHERE responsabile_id = ?";

    /**
     * Interfaccia che accede al DAO database per creare una connessione
     */
    private DatabaseConnectionInterface databaseConnectionInterface = new DatabaseConnectionDAO();


    /**
     * Metodo che crea la connessione al database
     * @return oggetto Connection
     * @throws SQLException
     */
    private Connection createConnection() throws SQLException {
        return databaseConnectionInterface.createConnection();
    }
    /**
     * Inserisce un nuovo ordine nel database.
     *
     * @param ordine Oggetto Ordine da inserire nel database.
     * @return true se l'inserimento è avvenuto con successo, false altrimenti.
     */
    @Override
    public boolean setOrdine(Ordine ordine) {
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDINE)) {

            preparedStatement.setDate(1, Date.valueOf(ordine.getDataOrdine()));
            preparedStatement.setDouble(2, ordine.getCosto());
            preparedStatement.setInt(3, ordine.getLotto().getID());
            preparedStatement.setInt(4, ordine.getResponsabile().getID());
            preparedStatement.setInt(5, ordine.getPriorita());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Recupera un ordine dal database tramite il suo ID.
     *
     * @param id L'ID dell'ordine da recuperare.
     * @return Ordine corrispondente all'ID specificato.
     */
    @Override
    public Ordine getOrdineById(int id) {
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDINE_BY_ID)) {

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Ordine ordine = new Ordine();
                ordine.setID(rs.getInt("id"));
                ordine.setDataOrdine(rs.getDate("data_ordine").toLocalDate());
                ordine.setCosto(rs.getDouble("costo"));
                ordine.setPriorita(rs.getInt("priorita"));

                ArmadiettoGetDataInterface i = new ArmadiettoFacade();
                Lotto lotto = i.getLottoByID(rs.getInt("lotto_id"));
                ordine.setLotto(lotto);

                ResponsabileDataInterface responsabileDataInterface = new ResponsabileDAO();
                Responsabile responsabile = responsabileDataInterface.getResponsabileById(rs.getInt("responsabile_id"));
                ordine.setResponsabile(responsabile);

                return ordine;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Recupera tutti gli ordini presenti nel database.
     *
     * @return Una lista di oggetti Ordine.
     */
    @Override
    public ArrayList<Ordine> getAllOrdini() {
        ArrayList<Ordine> ordini = new ArrayList<>();
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(SELECT_ALL_ORDINI)) {

            while (rs.next()) {
                Ordine ordine = new Ordine();
                ordine.setID(rs.getInt("id"));
                ordine.setDataOrdine(rs.getDate("data_ordine").toLocalDate());
                ordine.setCosto(rs.getDouble("costo"));
                ordine.setPriorita(rs.getInt("priorita"));

                ArmadiettoGetDataInterface i = new ArmadiettoFacade();
                Lotto lotto = i.getLottoByID(rs.getInt("lotto_id"));
                ordine.setLotto(lotto);

                ResponsabileDataInterface responsabileDataInterface = new ResponsabileDAO();
                Responsabile responsabile = responsabileDataInterface.getResponsabileById(rs.getInt("responsabile_id"));
                ordine.setResponsabile(responsabile);

                ordini.add(ordine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordini;
    }

    /**
     * Metodo che ritorn ala lista di tutti gli ordini per un determinato responsabile
     * @param id id del responsabile
     * @return arraylist di ordini
     */
    @Override
    public ArrayList<Ordine> getAllOrdiniByResponsabileId(int id) {
        ArrayList<Ordine> ordini = new ArrayList<>();
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDINI_BY_RESPONSABILE_ID)) {

            // Imposta il parametro nella query
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            // Itera attraverso il ResultSet per costruire la lista di ordini
            while (rs.next()) {
                Ordine ordine = new Ordine();
                ordine.setID(rs.getInt("id"));
                ordine.setDataOrdine(rs.getDate("data_ordine").toLocalDate());
                ordine.setCosto(rs.getDouble("costo"));
                ordine.setPriorita(rs.getInt("priorita"));

                // Ottieni il lotto associato
                ArmadiettoGetDataInterface armadiettoDAO = new ArmadiettoFacade();
                Lotto lotto = armadiettoDAO.getLottoByID(rs.getInt("lotto_id"));
                ordine.setLotto(lotto);

                // Ottieni il responsabile associato
                ResponsabileDataInterface responsabileDAO = new ResponsabileDAO();
                Responsabile responsabile = responsabileDAO.getResponsabileById(rs.getInt("responsabile_id"));
                ordine.setResponsabile(responsabile);

                // Aggiungi l'ordine alla lista
                ordini.add(ordine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordini;
    }

    /**
     * Aggiorna le informazioni di un ordine nel database.
     *
     * @param ordine Oggetto Ordine con le nuove informazioni da aggiornare.
     * @return true se l'aggiornamento è avvenuto con successo, false altrimenti.
     */
    @Override
    public boolean updateOrdine(Ordine ordine) {
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDINE)) {

            preparedStatement.setDate(1, Date.valueOf(ordine.getDataOrdine()));
            preparedStatement.setDouble(2, ordine.getCosto());
            preparedStatement.setInt(3, ordine.getLotto().getID());
            preparedStatement.setInt(4, ordine.getResponsabile().getID());
            preparedStatement.setInt(5, ordine.getPriorita());
            preparedStatement.setInt(6, ordine.getID());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Elimina un ordine dal database tramite il suo ID.
     *
     * @param id L'ID dell'ordine da eliminare.
     * @return true se l'eliminazione è avvenuta con successo, false altrimenti.
     */
    @Override
    public boolean deleteOrdine(int id) {
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDINE)) {

            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
