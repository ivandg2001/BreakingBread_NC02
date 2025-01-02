package PackageArmadietto;

import java.sql.*;
import java.util.ArrayList;

/**
 * DAO che gestisce le sostanze
 */
public class SostanzaDAO implements SostanzaDataInterface {

    /**
     * URL del database
     */
    private static final String DB_URL = "jdbc:mysql://localhost:3306/breakingbread";
    /**
     * User del profilo per il Database
     */
    private static final String DB_USER = "root";
    /**
     * Password del database
     */
    private static final String DB_PASSWORD = "ivan2001";

    /**
     * Colonna id sostanza
     */
    private static final String COLUMN_ID = "id";
    /**
     * Colonna nome sostanza
     */
    private static final String COLUMN_NOME = "nome";
    /**
     * Colonna formula sostanza
     */
    private static final String COLUMN_FORMULA = "formula";
    /**
     * Colonna costo unitario sostanza
     */
    private static final String COLUMN_COSTO_UNITARIO = "costo_unitario";


    /**
     * Metodo che inserisce una sostanza nel Database
     * @param sostanza Oggetto sostanza
     * @throws SQLException Eccezione SQL
     */
    @Override
    public void addSostanza(Sostanza sostanza) throws SQLException {
        String query = "INSERT INTO sostanza (" + COLUMN_NOME + ", " + COLUMN_FORMULA + ", " + COLUMN_COSTO_UNITARIO + ") VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, sostanza.getNome());
            preparedStatement.setString(2, sostanza.getFormula());
            preparedStatement.setDouble(3, sostanza.getCostoUnitario());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Metodo per cercare una sostanza utilizzando il nome
     * @param nome nome della sostanza
     * @return Oggetto sostanza
     * @throws SQLException Eccezione SQL
     */
    @Override
    public Sostanza getSostanzaByNome(String nome) throws SQLException {
        String query = "SELECT * FROM sostanza WHERE " + COLUMN_NOME + " = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, nome);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Sostanza sostanza = new Sostanza();
                sostanza.setID(rs.getInt(COLUMN_ID));
                sostanza.setNome(rs.getString(COLUMN_NOME));
                sostanza.setFormula(rs.getString(COLUMN_FORMULA));
                sostanza.setCostoUnitario(rs.getDouble(COLUMN_COSTO_UNITARIO));
                return sostanza;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Metodo per cercare una sostanza utilizzando l'id
     * @param id id della sostanza
     * @return Oggetto sostanza
     * @throws SQLException Eccezione SQL
     */
    @Override
    public Sostanza getSostanzaByID(int id) throws SQLException {
        String query = "SELECT * FROM sostanza WHERE " + COLUMN_ID + " = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Sostanza sostanza = new Sostanza();
                sostanza.setID(rs.getInt(COLUMN_ID));
                sostanza.setNome(rs.getString(COLUMN_NOME));
                sostanza.setFormula(rs.getString(COLUMN_FORMULA));
                sostanza.setCostoUnitario(rs.getDouble(COLUMN_COSTO_UNITARIO));
                return sostanza;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Metodo per l'aggiornamento di un oggeto sostanza nel Database
     * @param sostanza Oggetto sostanza
     * @throws SQLException Eccezione SQL
     */
    @Override
    public void updateSostanza(Sostanza sostanza) throws SQLException {
        String query = "UPDATE sostanza SET " + COLUMN_NOME + " = ?, " + COLUMN_FORMULA + " = ?, " + COLUMN_COSTO_UNITARIO + " = ? WHERE " + COLUMN_ID + " = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, sostanza.getNome());
            preparedStatement.setString(2, sostanza.getFormula());
            preparedStatement.setDouble(3, sostanza.getCostoUnitario());
            preparedStatement.setInt(4, sostanza.getID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Metodo per eliminare una sostanza
     * @param id id della sostanza da eliminare
     * @throws SQLException Eccezione SQL
     */
    @Override
    public void deleteSostanza(int id) throws SQLException {
        String query = "DELETE FROM sostanza WHERE " + COLUMN_ID + " = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Metodo che ritorna una lista contenente tutte le sostanze del Database
     * @return Lista delle sostanze
     * @throws SQLException Eccezione SQL
     */
    @Override
    public ArrayList<Sostanza> getListaSostanze() throws SQLException {
        ArrayList<Sostanza> sostanze = new ArrayList<>();
        String query = "SELECT * FROM sostanza";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {
                Sostanza sostanza = new Sostanza();
                sostanza.setID(rs.getInt(COLUMN_ID));
                sostanza.setNome(rs.getString(COLUMN_NOME));
                sostanza.setFormula(rs.getString(COLUMN_FORMULA));
                sostanza.setCostoUnitario(rs.getDouble(COLUMN_COSTO_UNITARIO));

                sostanze.add(sostanza);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return sostanze;
    }
}
