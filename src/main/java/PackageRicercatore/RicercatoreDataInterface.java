package PackageRicercatore;

import java.util.ArrayList;

public interface RicercatoreDataInterface {

    /**
     * Inserisce un nuovo Ricercatore nel database.
     *
     * @param r Oggetto Ricercatore da inserire.
     * @return true se l'inserimento è avvenuto con successo, false altrimenti.
     */
    boolean setRicercatore(Ricercatore r);

    /**
     * Recupera un Ricercatore dal database tramite il suo ID.
     *
     * @param id L'ID del Ricercatore da recuperare.
     * @return Oggetto Ricercatore corrispondente all'ID; null in caso di errore.
     */
    Ricercatore getRicercatore(int id);

    /**
     * Recupera tutti i Ricercatore presenti nel database.
     *
     * @return Una lista di oggetti Ricercatore.
     */
    ArrayList<Ricercatore> getAllRicercatore();

    /**
     * Aggiorna le informazioni di un Ricercatore nel database.
     *
     * @param r Oggetto Ricercatore con le nuove informazioni.
     * @return true se l'aggiornamento è avvenuto con successo, false altrimenti.
     */
    boolean updateRicercatore(Ricercatore r);

    /**
     * Elimina un Ricercatore dal database.
     *
     * @param r Il Ricercatore da eliminare.
     * @return true se l'eliminazione è avvenuta con successo, false altrimenti.
     */
    boolean deleteRicercatore(Ricercatore r);

}
