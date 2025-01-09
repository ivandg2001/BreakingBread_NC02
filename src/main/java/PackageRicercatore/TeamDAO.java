package PackageRicercatore;

import java.sql.*;
import java.util.ArrayList;

public class TeamDAO implements TeamDataInterface {

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
            "INSERT INTO team (nome_team) VALUES (?)";
    private static final String SELECT_BY_ID =
            "SELECT * FROM team WHERE id = ?";
    private static final String SELECT_ALL =
            "SELECT * FROM team";
    private static final String UPDATE =
            "UPDATE team SET nome_team = ? WHERE id = ?";
    private static final String DELETE =
            "DELETE FROM team WHERE id = ?";
    private static final String SELECT_ALL_BY_RICERCATORE =
            "SELECT t.* FROM team t JOIN team_ricercatore tr ON t.id = tr.team_id WHERE tr.ricercatore_id = ?";
    private static final String SELECT_ALL_BY_PROGETTO =
            "SELECT t.* FROM team t JOIN team_progetto tp ON t.id = tp.team_id WHERE tp.ricercatore_id = ?";

    public TeamDAO() {}

    /**
     * Inserisce un nuovo Team nel database.
     *
     * @param team Oggetto Team da inserire.
     * @return true se l'inserimento è avvenuto con successo, false altrimenti.
     */
    @Override
    public boolean setTeam(Team team) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {

            preparedStatement.setString(1, team.getNomeTeam());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Recupera un Team dal database tramite il suo ID.
     *
     * @param id L'ID del Team da recuperare.
     * @return Oggetto Team corrispondente all'ID; null in caso di errore.
     */
    @Override
    public Team getTeam(int id) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Team team = new Team();

                team.setID(rs.getInt("id"));
                team.setNomeTeam(rs.getString("nome_team"));

                //inserimento del team da gestire nell'oggetto entity stesso

                return team;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Recupera tutti i Team presenti nel database.
     *
     * @return Una lista di oggetti Team.
     */
    @Override
    public ArrayList<Team> getAllTeams() {
        ArrayList<Team> teams = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL);

            while (rs.next()) {
                Team team = new Team();

                team.setID(rs.getInt("id"));
                team.setNomeTeam(rs.getString("nome_team"));

                //inserimento di altri campi da gestire nell'oggetto entity stesso

                teams.add(team);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teams;
    }

    /**
     * Aggiorna le informazioni di un Team nel database.
     *
     * @param team Oggetto Team con le nuove informazioni.
     * @return true se l'aggiornamento è avvenuto con successo, false altrimenti.
     */
    @Override
    public boolean updateTeam(Team team) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);

            preparedStatement.setString(1, team.getNomeTeam());
            preparedStatement.setInt(2, team.getID());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Elimina un Team dal database.
     *
     * @param team Il Team da eliminare.
     * @return true se l'eliminazione è avvenuta con successo, false altrimenti.
     */
    @Override
    public boolean deleteTeam(Team team) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);

            preparedStatement.setInt(1, team.getID());
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
    public ArrayList<Team> getAllTeamsByRicercatore(Ricercatore ricercatore) {
        ArrayList<Team> teams = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_RICERCATORE);

            preparedStatement.setInt(1, ricercatore.getID());
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Team team = new Team();

                team.setID(rs.getInt("id"));
                team.setNomeTeam(rs.getString("nome_team"));

                teams.add(team);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teams;
    }

    /**
     * TODO
     */
    public ArrayList<Team> getAllTeamsByProgetto(Progetto progetto) {
        ArrayList<Team> teams = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_PROGETTO);

            preparedStatement.setInt(1, progetto.getID());
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Team team = new Team();

                team.setID(rs.getInt("id"));
                team.setNomeTeam(rs.getString("nome_team"));

                teams.add(team);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teams;
    }
}
