package PackageResponsabile;

import java.util.ArrayList;

/**
 * Interfaccia che definisce i metodi per gestire gli ordini nel database.
 */
public interface OrdineDataInterface {

    /**
     * Inserisce un nuovo ordine nel database.
     *
     * @param ordine Oggetto Ordine da inserire nel database.
     * @return true se l'inserimento è avvenuto con successo, false altrimenti.
     */
    boolean setOrdine(Ordine ordine);

    /**
     * Recupera un ordine dal database tramite il suo ID.
     *
     * @param id L'ID dell'ordine da recuperare.
     * @return Ordine corrispondente all'ID specificato.
     */
    Ordine getOrdineById(int id);

    /**
     * Recupera tutti gli ordini presenti nel database.
     *
     * @return Una lista di oggetti Ordine.
     */
    ArrayList<Ordine> getAllOrdini();

    /**
     * Aggiorna le informazioni di un ordine nel database.
     *
     * @param ordine Oggetto Ordine con le nuove informazioni da aggiornare.
     * @return true se l'aggiornamento è avvenuto con successo, false altrimenti.
     */
    boolean updateOrdine(Ordine ordine);

    /**
     * Elimina un ordine dal database tramite il suo ID.
     *
     * @param id L'ID dell'ordine da eliminare.
     * @return true se l'eliminazione è avvenuta con successo, false altrimenti.
     */
    boolean deleteOrdine(int id);

    /**
     * Metodo che ritorn ala lista di tutti gli ordini per un determinato responsabile
     * @param id id del responsabile
     * @return arraylist di ordini
     */
    public ArrayList<Ordine> getAllOrdiniByResponsabileId(int id);
}

