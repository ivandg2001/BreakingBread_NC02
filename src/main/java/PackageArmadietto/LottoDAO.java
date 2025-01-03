package PackageArmadietto;

import java.sql.*;
import java.util.ArrayList;

public class LottoDAO implements LottoDataInterface {

    /**
     * Url del database
     */
    private static final String DB_URL = "jdbc:mysql://localhost:3306/breakingbread";
    /**
     * Username profilo per il database
     */
    private static final String DB_USER = "root";
    /**
     * password per il database
     */
    private static final String DB_PASSWORD = "ivan2001";

    /**
     * Query SQL per inserire un nuovo lotto nel Database
     */
    private static final String INSERT_LOTTO_SQL = "INSERT INTO lotti (data_scadenza, quantita, sostanza_id) VALUES (?, ?, ?)";
    /**
     * Query SQL per la ricerca di un lotto per ID
     */
    private static final String SELECT_LOTTO_BY_ID = "SELECT * FROM lotti WHERE id = ?";
    /**
     * QUery SQL per ottenere tutti i lotti
     */
    private static final String SELECT_ALL_LOTTI = "SELECT * FROM lotti";
    /**
     * Query SQL per l'aggiornamento di un lotto
     */
    private static final String UPDATE_LOTTO_SQL = "UPDATE lotti SET data_scadenza = ?, quantita = ?, sostanza_id = ? WHERE id = ?";
    /**
     * Query SQL per la cancellazione di un lotto
     */
    private static final String DELETE_LOTTO_SQL = "DELETE FROM lotti WHERE id = ?";

    /**
     * Inserisce un nuovo lotto nel database.
     *
     * @param lotto Oggetto Lotto da inserire nel database.
     * @return true se l'inserimento è avvenuto con successo, false altrimenti.
     */
    @Override
    public boolean setLotto(Lotto lotto) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(INSERT_LOTTO_SQL)) {

            stmt.setDate(1, Date.valueOf(lotto.getDataScadenza()));
            stmt.setDouble(2, lotto.getQuantita());
            stmt.setInt(3, lotto.getSostanza().getID());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Recupera un lotto dal database tramite il suo ID.
     *
     * @param id L'ID del lotto da recuperare.
     * @return Lotto corrispondente all'ID specificato.
     */
    @Override
    public Lotto getLottoById(int id) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(SELECT_LOTTO_BY_ID)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Lotto lotto = new Lotto();
                lotto.setID(rs.getInt("id"));
                lotto.setDataScadenza(rs.getDate("data_scadenza").toLocalDate());
                lotto.setQuantita(rs.getDouble("quantita"));

                // Assumendo che la sostanza sia una relazione esterna
                Sostanza sostanza = new Sostanza();
                sostanza.setID(rs.getInt("sostanza_id"));
                lotto.setSostanza(sostanza);

                return lotto;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Recupera tutti i lotti presenti nel database.
     *
     * @return Una lista di oggetti Lotto.
     */
    @Override
    public ArrayList<Lotto> getListaLotti() {
        ArrayList<Lotto> lotti = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_LOTTI);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Lotto lotto = new Lotto();
                lotto.setID(rs.getInt("id"));
                lotto.setDataScadenza(rs.getDate("data_scadenza").toLocalDate());
                lotto.setQuantita(rs.getDouble("quantita"));

                // Assumendo che la sostanza sia una relazione esterna
                Sostanza sostanza = new Sostanza();
                sostanza.setID(rs.getInt("sostanza_id"));
                lotto.setSostanza(sostanza);

                lotti.add(lotto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lotti;
    }

    /**
     * Aggiorna le informazioni di un lotto nel database.
     *
     * @param lotto Oggetto Lotto con le nuove informazioni da aggiornare.
     * @return true se l'aggiornamento è avvenuto con successo, false altrimenti.
     */
    @Override
    public boolean updateLotto(Lotto lotto) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(UPDATE_LOTTO_SQL)) {

            stmt.setDate(1, Date.valueOf(lotto.getDataScadenza()));
            stmt.setDouble(2, lotto.getQuantita());
            stmt.setInt(3, lotto.getSostanza().getID());
            stmt.setInt(4, lotto.getID());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Elimina un lotto dal database tramite il suo ID.
     *
     * @param id L'ID del lotto da eliminare.
     * @return true se l'eliminazione è avvenuta con successo, false altrimenti.
     */
    @Override
    public boolean deleteLotto(int id) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(DELETE_LOTTO_SQL)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
