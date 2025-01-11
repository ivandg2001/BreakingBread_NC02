package PackageArmadietto;

import java.util.ArrayList;

/**
 * Interfaccia che definisce i metodi per gestire i lotti nel database.
 */
public interface LottoDataInterface {

    /**
     * Inserisce un nuovo lotto nel database.
     *
     * @param lotto Oggetto Lotto da inserire nel database.
     * @return true se l'inserimento è avvenuto con successo, false altrimenti.
     */
    boolean setLotto(Lotto lotto);

    /**
     * Recupera un lotto dal database tramite il suo ID.
     *
     * @param id L'ID del lotto da recuperare.
     * @return Lotto corrispondente all'ID specificato.
     */
    Lotto getLottoById(int id);

    /**
     * Recupera tutti i lotti presenti nel database.
     *
     * @return Una lista di oggetti Lotto.
     */
    ArrayList<Lotto> getListaLotti();

    /**
     * Aggiorna le informazioni di un lotto nel database.
     *
     * @param lotto Oggetto Lotto con le nuove informazioni da aggiornare.
     * @return true se l'aggiornamento è avvenuto con successo, false altrimenti.
     */
    boolean updateLotto(Lotto lotto);

    /**
     * Elimina un lotto dal database tramite il suo ID.
     *
     * @param id L'ID del lotto da eliminare.
     * @return true se l'eliminazione è avvenuta con successo, false altrimenti.
     */
    boolean deleteLotto(int id);

    /**
     * Metodo che salva nel database il lotto e poi ne ritorn ail riferimento all'oggetto
     * @param lotto lotto da salvare
     * @return Oggetto lotto
     */
    public Lotto saveAndRetrieveLotto(Lotto lotto);
}
