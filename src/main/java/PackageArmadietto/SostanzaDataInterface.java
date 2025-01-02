package PackageArmadietto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SostanzaDataInterface {

    /**
     * Metodo che inserisce una sostanza nel Database
     * @param sostanza Oggetto sostanza
     * @throws SQLException Eccezione SQL
     */
    void addSostanza(Sostanza sostanza) throws SQLException;

    /**
     * Metodo per cercare una sostanza utilizzando il nome
     * @param nome nome della sostanza
     * @return Oggetto sostanza
     * @throws SQLException Eccezione SQL
     */
    Sostanza getSostanzaByNome(String nome) throws SQLException;

    /**
     * Metodo per cercare una sostanza utilizzando l'id
     * @param id id della sostanza
     * @return Oggetto sostanza
     * @throws SQLException Eccezione SQL
     */
    Sostanza getSostanzaByID(int id) throws SQLException;

    /**
     * Metodo per l'aggiornamento di un oggeto sostanza nel Database
     * @param sostanza Oggetto sostanza
     * @throws SQLException Eccezione SQL
     */
    void updateSostanza(Sostanza sostanza) throws SQLException;

    /**
     * Metodo per eliminare una sostanza
     * @param id id della sostanza da eliminare
     * @throws SQLException Eccezione SQL
     */
    void deleteSostanza(int id) throws SQLException;

    /**
     * Metodo che ritorna una lista contenente tutte le sostanze del Database
     * @return Lista delle sostanze
     * @throws SQLException Eccezione SQL
     */
    ArrayList<Sostanza> getListaSostanze() throws SQLException;
}
