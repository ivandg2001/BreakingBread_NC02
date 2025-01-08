package PackageRicercatore;

import java.sql.*;
import java.util.ArrayList;

public class PrelievoDAO implements PrelievoDataInterface {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/breakingbread";
    private static final String DB_USER = "breakingBread";
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

    public PrelievoDAO() {

    }

    @Override
    public boolean setPrelievo(Prelievo prelievo) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {

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

    @Override
    public Prelievo getPrelievo(int id) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {

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

    @Override
    public ArrayList<Prelievo> getAllPrelievi() {
        ArrayList<Prelievo> prelievi = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(SELECT_ALL)) {

            while (rs.next()) {
                Prelievo prelievo = new Prelievo();
                prelievo.setID(rs.getInt("id"));
                prelievo.setData(rs.getDate("data_prelievo").toLocalDate());
                prelievo.setQuantita(rs.getDouble("quantita"));

                //da gestire nell'oggetto entity stesso
                /*
                ArmadiettoGetDataInterface armadiettoDAO = new ArmadiettoFacade();
                Lotto lotto = armadiettoDAO.getLottoByID(rs.getInt("lotto_id"));
                prelievo.setLotto(lotto);

                ResponsabileDataInterface responsabileDAO = new ResponsabileDAO();
                Responsabile responsabile = responsabileDAO.getResponsabileById(rs.getInt("responsabile_id"));
                prelievo.setResponsabile(responsabile);

                 */

                prelievi.add(prelievo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prelievi;
    }

    @Override
    public boolean updatePrelievo(Prelievo prelievo) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {

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

    @Override
    public boolean deletePrelievo(Prelievo prelievo) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {

            preparedStatement.setInt(1, prelievo.getID());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
