package PackagePrelievoSostanza;

import java.util.ArrayList;

public interface PrelievoDataInterface {

    /**
     * Inserisce un nuovo Prelievo nel database.
     *
     * @param prelievo Oggetto Prelievo da inserire.
     * @return true se l'inserimento è avvenuto con successo, false altrimenti.
     */
    boolean setPrelievo(Prelievo prelievo);

    /**
     * Recupera un Prelievo dal database tramite il suo ID.
     *
     * @param id L'ID del Prelievo da recuperare.
     * @return Oggetto Prelievo corrispondente all'ID; null in caso di errore.
     */
    Prelievo getPrelievo(int id);

    /**
     * Recupera tutti i Prelievo presenti nel database.
     *
     * @return Una lista di oggetti Prelievo.
     */
    ArrayList<Prelievo> getAllPrelievi();

    /**
     * Aggiorna le informazioni di un Prelievo nel database.
     *
     * @param prelievo Oggetto Prelievo con le nuove informazioni.
     * @return true se l'aggiornamento è avvenuto con successo, false altrimenti.
     */
    boolean updatePrelievo(Prelievo prelievo);

    /**
     * Elimina un Prelievo dal database.
     *
     * @param prelievo Il Prelievo da eliminare.
     * @return true se l'eliminazione è avvenuta con successo, false altrimenti.
     */
    boolean deletePrelievo(Prelievo prelievo);

    /**
     * TODO
     */
    ArrayList<Prelievo> getAllPrelieviByRicercatore(Ricercatore ricercatore);

}
