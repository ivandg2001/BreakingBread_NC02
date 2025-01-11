package PackageArmadietto;

import PackageUtils.DatabaseConnectionDAO;
import PackageUtils.DatabaseConnectionInterface;

import java.sql.*;
import java.util.ArrayList;

/**
 * DAO che gestisce le sostanze
 */
public class SostanzaDAO implements SostanzaDataInterface {


    /**
     * Query SQL per l'inserimento di una sostanza
     */
    private static final String INSERT_QUERY = "INSERT INTO sostanza (nome, formula, costo_unitario) VALUES (?, ?, ?)";

    /**
     * Query SQL per la ricerca di una sostanza per nome
     */
    private static final String SELECT_BY_NOME_QUERY = "SELECT * FROM sostanza WHERE nome = ?";

    /**
     * Query SQL per la ricerca di una sostanza per ID
     */
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM sostanza WHERE id = ?";

    /**
     * Query SQL per l'aggiornamento di una sostanza
     */
    private static final String UPDATE_QUERY = "UPDATE sostanza SET nome = ?, formula = ?, costo_unitario = ? WHERE id = ?";

    /**
     * Query SQL per la cancellazione di una sostanza
     */
    private static final String DELETE_QUERY = "DELETE FROM sostanza WHERE id = ?";

    /**
     * Query SQL per ottenere tutte le sostanze
     */
    private static final String SELECT_ALL_QUERY = "SELECT * FROM sostanza";

    /**
     * Query SQL per ottenere tutti i nomi delle sostanze
     */
    private static final String SELECT_ALL_NAMES = "SELECT nome FROM sostanza";

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
     * Metodo che inserisce una sostanza nel Database
     * @param sostanza Oggetto sostanza
     * @return true se l'inserimento è avvenuto con successo, false altrimenti.
     */
    @Override
    public boolean addSostanza(Sostanza sostanza) {
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {

            preparedStatement.setString(1, sostanza.getNome());
            preparedStatement.setString(2, sostanza.getFormula());
            preparedStatement.setDouble(3, sostanza.getCostoUnitario());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Metodo per cercare una sostanza utilizzando il nome
     * @param nome nome della sostanza
     * @return Oggetto sostanza
     */
    @Override
    public Sostanza getSostanzaByNome(String nome) {
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_NOME_QUERY)) {

            preparedStatement.setString(1, nome);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Sostanza sostanza = new Sostanza();
                sostanza.setID(rs.getInt("id"));
                sostanza.setNome(rs.getString("nome"));
                sostanza.setFormula(rs.getString("formula"));
                sostanza.setCostoUnitario(rs.getDouble("costo_unitario"));
                return sostanza;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Metodo per cercare una sostanza utilizzando l'id
     * @param id id della sostanza
     * @return Oggetto sostanza
     */
    @Override
    public Sostanza getSostanzaByID(int id){
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Sostanza sostanza = new Sostanza();
                sostanza.setID(rs.getInt("id"));
                sostanza.setNome(rs.getString("nome"));
                sostanza.setFormula(rs.getString("formula"));
                sostanza.setCostoUnitario(rs.getDouble("costo_unitario"));
                return sostanza;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Metodo per l'aggiornamento di un oggeto sostanza nel Database
     * @param sostanza Oggetto sostanza
     * @return true se l'aggiornamento è avvenuto con successo, false altrimenti.
     */
    @Override
    public boolean updateSostanza(Sostanza sostanza){
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {

            preparedStatement.setString(1, sostanza.getNome());
            preparedStatement.setString(2, sostanza.getFormula());
            preparedStatement.setDouble(3, sostanza.getCostoUnitario());
            preparedStatement.setInt(4, sostanza.getID());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Metodo per eliminare una sostanza
     * @param id id della sostanza da eliminare
     * @return true se l'eliminazione è avvenuta con successo, false altrimenti.
     */
    @Override
    public boolean deleteSostanza(int id){
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY)) {

            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Metodo che ritorna una lista contenente tutte le sostanze del Database
     * @return Lista delle sostanze
     */
    @Override
    public ArrayList<Sostanza> getListaSostanze(){
        ArrayList<Sostanza> sostanze = new ArrayList<>();
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(SELECT_ALL_QUERY)) {

            while (rs.next()) {
                Sostanza sostanza = new Sostanza();
                sostanza.setID(rs.getInt("id"));
                sostanza.setNome(rs.getString("nome"));
                sostanza.setFormula(rs.getString("formula"));
                sostanza.setCostoUnitario(rs.getDouble("costo_unitario"));

                sostanze.add(sostanza);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sostanze;
    }

    /**
     * metodo che ritorna una lista dei nomi di tutte le sostanze
     * @return lista di stringhe
     */
    @Override
    public String[] getListaNomiSostanze() {
        ArrayList<Sostanza> sostanze = getListaSostanze();
        String[] nomi = new String[sostanze.size()];

        for (int i = 0; i < sostanze.size(); i++) {
            nomi[i] = sostanze.get(i).getNome();
        }

        return nomi;
    }

}
