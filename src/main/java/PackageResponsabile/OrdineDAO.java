package PackageResponsabile;

import PackageArmadietto.ArmadiettoFacade;
import PackageArmadietto.ArmadiettoGetDataInterface;
import PackageArmadietto.Lotto;
import PackageArmadietto.LottoDAO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrdineDAO implements OrdineDataInterface {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/breakingbread";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "ivan2001";

    private static final String INSERT_ORDINE =
            "INSERT INTO ordine (data_ordine, costo, lotto_id, responsabile_id, priorita) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ORDINE_BY_ID =
            "SELECT * FROM ordine WHERE id = ?";
    private static final String SELECT_ALL_ORDINI =
            "SELECT * FROM ordine";
    private static final String UPDATE_ORDINE =
            "UPDATE ordine SET data_ordine = ?, costo = ?, lotto_id = ?, responsabile_id = ?, priorita = ? WHERE id = ?";
    private static final String DELETE_ORDINE =
            "DELETE FROM ordine WHERE id = ?";

    @Override
    public boolean setOrdine(Ordine ordine) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
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

    @Override
    public Ordine getOrdineById(int id) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
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

                Responsabile responsabile = new ResponsabileDAO().getResponsabileById(rs.getInt("responsabile_id"));
                ordine.setResponsabile(responsabile);

                return ordine;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Ordine> getAllOrdini() {
        ArrayList<Ordine> ordini = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(SELECT_ALL_ORDINI)) {

            while (rs.next()) {
                Ordine ordine = new Ordine();
                ordine.setID(rs.getInt("id"));
                ordine.setDataOrdine(rs.getDate("data_ordine").toLocalDate());
                ordine.setCosto(rs.getDouble("costo"));
                ordine.setPriorita(rs.getInt("priorita"));

                Lotto lotto = new LottoDAO().getLottoById(rs.getInt("lotto_id"));
                ordine.setLotto(lotto);

                Responsabile responsabile = new ResponsabileDAO().getResponsabileById(rs.getInt("responsabile_id"));
                ordine.setResponsabile(responsabile);

                ordini.add(ordine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordini;
    }

    @Override
    public boolean updateOrdine(Ordine ordine) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
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

    @Override
    public boolean deleteOrdine(int id) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDINE)) {

            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
