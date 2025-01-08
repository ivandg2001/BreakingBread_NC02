package PackageRicercatore;

import java.util.ArrayList;

public interface TeamDataInterface {

    /**
     * Inserisce un nuovo Team nel database.
     *
     * @param t Oggetto Team da inserire.
     * @return true se l'inserimento è avvenuto con successo, false altrimenti.
     */
    boolean setTeam(Team t);

    /**
     * Recupera un Team dal database tramite il suo ID.
     *
     * @param id L'ID del Team da recuperare.
     * @return Oggetto Team corrispondente all'ID; null in caso di errore.
     */
    Team getTeam(int id);

    /**
     * Recupera tutti i Team presenti nel database.
     *
     * @return Una lista di oggetti Team.
     */
    ArrayList<Team> getAllTeams();

    /**
     * Aggiorna le informazioni di un Team nel database.
     *
     * @param t Oggetto Team con le nuove informazioni.
     * @return true se l'aggiornamento è avvenuto con successo, false altrimenti.
     */
    boolean updateTeam(Team t);

    /**
     * Elimina un Team dal database.
     *
     * @param t Il Team da eliminare.
     * @return true se l'eliminazione è avvenuta con successo, false altrimenti.
     */
    boolean deleteTeam(Team t);

}
