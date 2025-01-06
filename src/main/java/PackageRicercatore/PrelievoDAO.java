package PackageRicercatore;

import java.util.ArrayList;

public class PrelievoDAO implements PrelievoDataInterface {

    /**
     * URL del database
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

    private static final String INSERT_PRELIEVO =
            "INSERT INTO prelievo (data_prelievo, importo, descrizione, responsabile_id) VALUES (?, ?, ?, ?)";
    private static final String SELECT_PRELIEVO_BY_ID =
            "SELECT * FROM prelievo WHERE id = ?";
    private static final String SELECT_ALL_PRELIEVI =
            "SELECT * FROM prelievo";
    private static final String UPDATE_PRELIEVO =
            "UPDATE prelievo SET data_prelievo = ?, importo = ?, descrizione = ?, responsabile_id = ? WHERE id = ?";
    private static final String DELETE_PRELIEVO =
            "DELETE FROM prelievo WHERE id = ?";

    public PrelievoDAO() {}

    @Override
    public boolean setPrelievo(Prelievo prelievo) {
        return false;
    }

    @Override
    public Prelievo getPrelievo(int id) {
        return null;
    }

    @Override
    public ArrayList<Prelievo> getAllPrelievi() {
        return null;
    }

    @Override
    public boolean updatePrelievo(Prelievo p) {
        return false;
    }

    @Override
    public boolean deletePrelievo(Prelievo p) {
        return false;
    }
}
