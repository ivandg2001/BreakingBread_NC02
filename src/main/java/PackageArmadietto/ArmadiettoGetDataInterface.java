package PackageArmadietto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

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
     * 1. ID del lotto;
     * 2. Nome della sostanza contenuta nel lotto;
     * 3. Formula chimica della sostanza contenuta nel lotto;
     * 4. Purezza della sostanza contenuta nel lotto.
     *
     * @return Una ArrayList di Array dì stringhe.
     */
    public ArrayList<String[]> getListaLottiFormattati();

    public String[] getListaNomiSostanze();

    public double getLottoTotalCost(int id);

    public Lotto createLottoObjectNoPersistance(LocalDate dataDiScadenza , double quantita , Sostanza sostanza , double purezza);

    public double getTotalCostBySostanza(String nomeSostanza , double quantita , double purezza);

    public String getFormulaBySostanza(String nomeSostanza);
}
