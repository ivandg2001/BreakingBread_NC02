package PackageArmadietto;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Interfaccia che specifica l'accesso al facade per ricevere i dati
 */
public interface ArmadiettoGetDataInterface {
    /**
     * Metodo che permette di trovareun lotto per l'id
     * @param id id lotto
     * @return oggetto Lotto
     */
    public Lotto getLottoByID(int id);

    /**
     * Metodo che permette di ricevere la lista dei lotti
     * @return Lista dei lotti
     */
    public ArrayList<Lotto> getListaLotti();

    /**
     * Metodo che permette di ricevere la sostanza per l'id
     * @param id id sostanza
     * @return Oggetto sostanza
     */
    public Sostanza getSostanzaByID(int id);

    /**
     * Metodo che permette di ricevere la sostanza per il nome
     * @param nome nome della sostanza
     * @return Oggetto sostanza
     */
    public Sostanza getSostanzaByName(String nome);

    /**
     * Metodo che permette di ricevere la lista delle sostanze presenti nel database
     * @return lista di oggetti Sostanza
     */
    public ArrayList<Sostanza> getListaSostanza();

    /**
     * Questo metodo restituisce una lista, i cui elementi sono degli Array di Stringhe.
     * Ciascun elemento di questo array rappresenta un lotto presente nell'armadietto.
     * Ogni array contiene i seguenti elementi:
     * 0. ID del lotto;
     * 1. Nome della sostanza contenuta nel lotto;
     * 2. Formula chimica della sostanza contenuta nel lotto;
     * 3. Purezza della sostanza contenuta nel lotto.
     *
     * @return Una ArrayList di Array dì stringhe.
     */
    public ArrayList<String[]> getListaLottiFormattati();

    public String[] getListaNomiSostanze();

    public double getLottoTotalCost(int id);

    public Lotto createLottoObjectNoPersistence(LocalDate dataDiScadenza , double quantita , Sostanza sostanza , double purezza);

    public double getTotalCostBySostanza(String nomeSostanza , double quantita , double purezza);

    public String getFormulaBySostanza(String nomeSostanza);

    /**
     * Restituisce informazioni formattate riguardo un certo lotto.
     * Le informazioni sono organizzate in un array di stringhe, e nel seguente ordine:
     * 0. Nome della sostanza nel lotto;
     * 1. Formula della sostanza nel lotto;
     * 2. ID del lotto;
     * 3. Purezza del lotto;
     * 4. Data di scadenza del lotto;
     * 5. Quantità attuale della sostanza nel lotto.
     *
     * @param idLotto Id del lotto.
     * @return Informazioni riguardo al lotto, formattate in un array di stringhe.
     */
    String[] getInfoLottoFormattate(int idLotto);

    /**
     * Restituisce la quantità di un certo lotto.
     *
     * @param idLotto Id del lotto.
     * @return Quantità della sostanza nel lotto.
     */
    public double getQuantitaLotto(int idLotto);
}
