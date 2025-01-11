package PackageArmadietto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *Classe che implementa il design pattern facade
 */
public class ArmadiettoFacade implements ArmadiettoSetDataInterface , ArmadiettoGetDataInterface {

    /**
     * Interfaccia per comunicare con i DAO Lotto
     */
    private final static LottoDataInterface lottoDataInterface = new LottoDAO();
    /**
     * Interfaccia per comunicare con i DAO sostanza
     */
    private final static SostanzaDataInterface sostanzaDataInterface = new SostanzaDAO();




    /**
     * Costruttore predefinito
     */
    public ArmadiettoFacade() {
    }

    //-- GetDataInterface --

    /**
     * Metodo che permette di trovareun lotto per l'id
     * @param id id lotto
     * @return oggetto Lotto
     */
    @Override
    public Lotto getLottoByID(int id) {
        return lottoDataInterface.getLottoById(id);
    }

    /**
     * Metodo che permette di ricevere la lista dei lotti
     * @return Lista dei lotti
     */
    @Override
    public ArrayList<Lotto> getListaLotti() {
        return lottoDataInterface.getListaLotti();
    }

    /**
     * Metodo che permette di ricevere la sostanza per l'id
     * @param id id sostanza
     * @return Oggetto sostanza
     */
    @Override
    public Sostanza getSostanzaByID(int id) {
        return sostanzaDataInterface.getSostanzaByID(id);
    }

    /**
     * Metodo che permette di ricevere la sostanza per il nome
     * @param nome nome della sostanza
     * @return Oggetto sostanza
     */
    @Override
    public Sostanza getSostanzaByName(String nome) {
        return sostanzaDataInterface.getSostanzaByNome(nome);
    }

    /**
     * Metodo che permette di ricevere la lista delle sostanze presenti nel database
     * @return lista di oggetti Sostanza
     */
    @Override
    public ArrayList<Sostanza> getListaSostanza() {
        return sostanzaDataInterface.getListaSostanze();
    }

    /**
     * Ritorna la lista dei nomi delle sostanze presenti
     * @return lista Nomi sostanza
     */
    @Override
    public String[] getListaNomiSostanze(){
        return sostanzaDataInterface.getListaNomiSostanze();
    }

    /**
     * Ritorna il costo totale per un lotto
     * @param id id del lotto
     * @return costo del lotto
     */
    @Override
    public double getLottoTotalCost(int id){

        return lottoDataInterface.getLottoById(id).getTotal();

    }

    /**
     * Calcola il costo partendo dalla sostamza
     * @param nomeSostanza nome della sostanza
     * @param quantita quantita della sostanza
     * @param purezza purezza della sostanza
     * @return costo totale
     */
    @Override
    public double getTotalCostBySostanza(String nomeSostanza , double quantita , double purezza){
        Sostanza sostanza = getSostanzaByName(nomeSostanza);
        return sostanza.getCosto(quantita , purezza);
    }

    /**
     * Ritorn ala formula della sostanz
     * @param nomeSostanza nome della sostanza
     * @return formula della sostanza
     */
    @Override
    public String getFormulaBySostanza(String nomeSostanza){
        Sostanza sostanza = sostanzaDataInterface.getSostanzaByNome(nomeSostanza);
        return sostanza.getFormula();
    }

    /**
     * Crea un ogetto lotto senza persistenza
     * @param dataDiScadenza data di scadenza del lotto
     * @param quantita quantita del lotto
     * @param sostanza sostanza presente nel lotto
     * @param purezza purezza della sostanza nel lotto
     * @return Oggetto Lotto
     */
    @Override
    public Lotto createLottoObjectNoPersistence(LocalDate dataDiScadenza , double quantita , Sostanza sostanza , double purezza){
        return new Lotto(dataDiScadenza , quantita , sostanza , purezza);

    }

    //-- SetDataInterface --

    /**
     * Metodo che crea un nuovo oggetto lotto e lo salva nel database
     * @param dataScadenza data si scadenza
     * @param quantita quantita nel lotto
     * @param sostanzaNome sostanza nel lotto
     * @param purezza purezza sostanza
     */
    @Override
    public void saveLotto(LocalDate dataScadenza, double quantita, String sostanzaNome , double purezza) {
        Sostanza sostanza = sostanzaDataInterface.getSostanzaByNome(sostanzaNome);
        Lotto lotto = new Lotto(dataScadenza, quantita, sostanza , purezza);
        lotto.storeLotto();
    }

    /**
     * Permette di salvare in database e far ritornare un oggetto riferimento del lotto appena creato
     * @param dataScadenza data scadenza del lotto
     * @param quantita quantita del lotto
     * @param sostanzaNome sostanza nel lotto
     * @param purezza purezza della sostanza
     * @return Oggetto Lotto
     */
    @Override
    public Lotto saveAndRetrievelotto(LocalDate dataScadenza, double quantita, String sostanzaNome , double purezza){

        Sostanza sostanza = sostanzaDataInterface.getSostanzaByNome(sostanzaNome);
        Lotto lotto = new Lotto(dataScadenza, quantita, sostanza , purezza);
        return lottoDataInterface.saveAndRetrieveLotto(lotto);
    }

    /**
     * Metodo che crea un nuovo oggetto sostanza e lo salva nel database
     * @param nome nome della sostanza
     * @param formula formula chimica della sostanza
     * @param costoUnitario costo unitario della sostanza
     */
    @Override
    public void saveSostanza(String nome, String formula, double costoUnitario) {
        Sostanza sostanza = new Sostanza(nome, formula, costoUnitario);
        sostanza.storeSostanza();
    }

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
    @Override
    public ArrayList<String[]> getListaLottiFormattati() {
        Armadietto armadietto = new Armadietto();
        return armadietto.getListaLottiFormattati();
    }

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
    @Override
    public String[] getInfoLottoFormattate(int idLotto) {
        return lottoDataInterface.getLottoById(idLotto).getInfoLottoFormattate();

    }

    /**
     * Restituisce la quantità di un certo lotto.
     *
     * @param idLotto Id del lotto.
     * @return Quantità della sostanza nel lotto.
     */
    @Override
    public double getQuantitaLotto(int idLotto) {
        return lottoDataInterface.getLottoById(idLotto).getQuantita();

    }

    /**
     * Esegue il prelievo di una sostanza dall'armadietto.
     *
     * @param idLotto Id del lotto da cui prelevare.
     * @param quantita Quantità della sostanza da prelevare dal lotto.
     */
    @Override
    public void eseguiPrelievo(int idLotto, double quantita) {
        Armadietto armadietto = new Armadietto();
        armadietto.eseguiPrelievo(idLotto, quantita);
    }
}
