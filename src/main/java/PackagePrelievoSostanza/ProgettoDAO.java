package PackagePrelievoSostanza;

import PackageUtils.DatabaseConnectionDAO;
import PackageUtils.DatabaseConnectionInterface;

import java.sql.*;
import java.util.ArrayList;

public class ProgettoDAO implements ProgettoDataInterface {



    private static final String INSERT =
            "INSERT INTO progetto (nome_progetto, team_id) VALUES (?, ?)";
    private static final String SELECT_BY_ID =
            "SELECT * FROM progetto WHERE id = ?";
    private static final String SELECT_ALL =
            "SELECT * FROM progetto";
    private static final String UPDATE =
            "UPDATE progetto SET nome_progetto = ?, team_id = ? WHERE id = ?";
    private static final String DELETE =
            "DELETE FROM progetto WHERE id = ?";
    private static final String SELECT_ALL_BY_TEAM =
            "SELECT p.* FROM progetto p JOIN team_progetto tp ON p.id = tp.progetto_id WHERE tr.team_id = ?";

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

    public ProgettoDAO() {}

    /**
     * Inserisce un nuovo Progetto nel database.
     *
     * @param progetto Oggetto Progetto da inserire.
     * @return true se l'inserimento è avvenuto con successo, false altrimenti.
     */
    @Override
    public boolean setProgetto(Progetto progetto) {
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {

            preparedStatement.setString(1, progetto.getNomeProgetto());
            //preparedStatement.setInt(2, progetto.getTeam().getID());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Recupera un Progetto dal database tramite il suo ID.
     *
     * @param id L'ID del Progetto da recuperare.
     * @return Oggetto Progetto corrispondente all'ID; null in caso di errore.
     */
    @Override
    public Progetto getProgetto(int id) {
        try {
            Connection connection = createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Progetto progetto = new Progetto();

                progetto.setID(rs.getInt("id"));
                progetto.setNomeProgetto(rs.getString("nome_progetto"));

                //inserimento del team da gestire nell'oggetto entity stesso

                return progetto;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Recupera tutti i Progetto presenti nel database.
     *
     * @return Una lista di oggetti Progetto.
     */
    @Override
    public ArrayList<Progetto> getAllProgetti() {
        ArrayList<Progetto> progetti = new ArrayList<>();
        try {
            Connection connection = createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL);

            while (rs.next()) {
                Progetto progetto = new Progetto();

                progetto.setID(rs.getInt("id"));
                progetto.setNomeProgetto(rs.getString("nome_progetto"));

                //inserimento del team da gestire nell'oggetto entity stesso

                progetti.add(progetto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return progetti;
    }

    /**
     * Aggiorna le informazioni di un Progetto nel database.
     *
     * @param progetto Oggetto Progetto con le nuove informazioni.
     * @return true se l'aggiornamento è avvenuto con successo, false altrimenti.
     */
    @Override
    public boolean updateProgetto(Progetto progetto) {
        try {
            Connection connection = createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);

            preparedStatement.setString(1, progetto.getNomeProgetto());
           // preparedStatement.setInt(2, progetto.getTeam().getID());
            preparedStatement.setInt(3, progetto.getID());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Elimina un Progetto dal database.
     *
     * @param progetto Il Progetto da eliminare.
     * @return true se l'eliminazione è avvenuta con successo, false altrimenti.
     */
    @Override
    public boolean deleteProgetto(Progetto progetto) {
        try {
            Connection connection = createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);

            preparedStatement.setInt(1, progetto.getID());
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
    public ArrayList<Progetto> getAllProgettiByTeam(Team team) {
        ArrayList<Progetto> progetti = new ArrayList<>();
        try {
            Connection connection = createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_TEAM);

            preparedStatement.setInt(1, team.getID());
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Progetto progetto = new Progetto();

                progetto.setID(rs.getInt("id"));
                progetto.setNomeProgetto(rs.getString("nome_progetto"));

                progetti.add(progetto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return progetti;
    }
}
