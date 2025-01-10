package PackageNuovoOrdine;

import java.util.ArrayList;

/**
 * Interfaccia che definisce i metodi per gestire i responsabili nel database.
 */
public interface ResponsabileDataInterface {

    /**
     * Inserisce un nuovo responsabile nel database.
     *
     * @param responsabile Oggetto Responsabile da inserire.
     * @return true se l'inserimento è avvenuto con successo, false altrimenti.
     */
    boolean setResponsabile(Responsabile responsabile);

    /**
     * Recupera un responsabile dal database tramite il suo ID.
     *
     * @param id L'ID del responsabile da recuperare.
     * @return Oggetto Responsabile corrispondente all'ID.
     */
    Responsabile getResponsabileById(int id);

    /**
     * Recupera tutti i responsabili presenti nel database.
     *
     * @return Una lista di oggetti Responsabile.
     */
    ArrayList<Responsabile> getAllResponsabili();

    /**
     * Aggiorna le informazioni di un responsabile nel database.
     *
     * @param responsabile Oggetto Responsabile con le nuove informazioni.
     * @return true se l'aggiornamento è avvenuto con successo, false altrimenti.
     */
    boolean updateResponsabile(Responsabile responsabile);

    /**
     * Elimina un responsabile dal database tramite il suo ID.
     *
     * @param id L'ID del responsabile da eliminare.
     * @return true se l'eliminazione è avvenuta con successo, false altrimenti.
     */
    boolean deleteResponsabile(int id);
}
