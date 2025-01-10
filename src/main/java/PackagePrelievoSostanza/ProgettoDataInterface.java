package PackagePrelievoSostanza;

import java.util.ArrayList;

public interface ProgettoDataInterface {

    /**
     * Inserisce un nuovo Progetto nel database.
     *
     * @param progetto Oggetto Progetto da inserire.
     * @return true se l'inserimento è avvenuto con successo, false altrimenti.
     */
    boolean setProgetto(Progetto progetto);

    /**
     * Recupera un Progetto dal database tramite il suo ID.
     *
     * @param id L'ID del Progetto da recuperare.
     * @return Oggetto Progetto corrispondente all'ID; null in caso di errore.
     */
    Progetto getProgetto(int id);

    /**
     * Recupera tutti i Progetto presenti nel database.
     *
     * @return Una lista di oggetti Progetto.
     */
    ArrayList<Progetto> getAllProgetti();

    /**
     * Aggiorna le informazioni di un Progetto nel database.
     *
     * @param progetto Oggetto Progetto con le nuove informazioni.
     * @return true se l'aggiornamento è avvenuto con successo, false altrimenti.
     */
    boolean updateProgetto(Progetto progetto);

    /**
     * Elimina un Progetto dal database.
     *
     * @param progetto Il Progetto da eliminare.
     * @return true se l'eliminazione è avvenuta con successo, false altrimenti.
     */
    boolean deleteProgetto(Progetto progetto);

    /**
     * TODO
     */
    ArrayList<Progetto> getAllProgettiByTeam(Team team);
}
