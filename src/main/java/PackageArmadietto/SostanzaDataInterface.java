package PackageArmadietto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SostanzaDataInterface {

    /**
     * Metodo che inserisce una sostanza nel Database
     * @param sostanza Oggetto sostanza
     * @return boolean
     */
    boolean addSostanza(Sostanza sostanza);

    /**
     * Metodo per cercare una sostanza utilizzando il nome
     * @param nome nome della sostanza
     * @return Oggetto sostanza
     */
    Sostanza getSostanzaByNome(String nome);

    /**
     * Metodo per cercare una sostanza utilizzando l'id
     * @param id id della sostanza
     * @return Oggetto sostanza
     */
    Sostanza getSostanzaByID(int id);

    /**
     * Metodo per l'aggiornamento di un oggeto sostanza nel Database
     * @param sostanza Oggetto sostanza
     * @return boolean
     */
    boolean updateSostanza(Sostanza sostanza);

    /**
     * Metodo per eliminare una sostanza
     * @param id id della sostanza da eliminare
     * @return boolean
     */
    boolean deleteSostanza(int id);

    /**
     * Metodo che ritorna una lista contenente tutte le sostanze del Database
     * @return Lista delle sostanze
     */
    ArrayList<Sostanza> getListaSostanze();
}
