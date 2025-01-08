package PackageRicercatore;

import java.util.ArrayList;

public class RicercatoreDAO implements RicercatoreDataInterface{

    private static final String DB_URL = "jdbc:mysql://localhost:3306/breakingbread";
    private static final String DB_USER = "breakingBread";
    private static final String DB_PASSWORD = "breakingbread1";

    private static final String INSERT_RCERCATORE =
            "INSERT INTO prelievo (data, quantita, lotto_id, ricercatore_id) VALUES (?, ?, ?, ?)";
    private static final String SELECT_PRELIEVO_BY_ID =
            "SELECT * FROM prelievo WHERE id = ?";
    private static final String SELECT_ALL_PRELIEVI =
            "SELECT * FROM prelievo";
    private static final String UPDATE_PRELIEVO =
            "UPDATE prelievo SET data = ?, quantita = ?, lotto_id = ?, ricercatore_id = ? WHERE id = ?";
    private static final String DELETE_PRELIEVO =
            "DELETE FROM prelievo WHERE id = ?";

    public RicercatoreDAO() {

    }

    @Override
    public boolean setRicercatore(Ricercatore r) {
        return false;
    }

    @Override
    public Ricercatore getRicercatore(int id) {
        return null;
    }

    @Override
    public ArrayList<Ricercatore> getAllRicercatore() {
        return null;
    }

    @Override
    public boolean updateRicercatore(Ricercatore r) {
        return false;
    }

    @Override
    public boolean deleteRicercatore(Ricercatore r) {
        return false;
    }
}
