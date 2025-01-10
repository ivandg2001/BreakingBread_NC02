package PackageArmadietto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class ArmadiettoFacade implements ArmadiettoSetDataInterface , ArmadiettoGetDataInterface {

    private final static LottoDataInterface lottoDataInterface = new LottoDAO();
    private final static SostanzaDataInterface sostanzaDataInterface = new SostanzaDAO();
    private Lotto lotto = null;
    private Sostanza sostanza = null;
    private Armadietto armadietto = null;

    public ArmadiettoFacade() {
    }

    //-- GetDataInterface --

    @Override
    public Lotto getLottoByID(int id) {
        return lottoDataInterface.getLottoById(id);
    }

    @Override
    public ArrayList<Lotto> getListaLotti() {
        return lottoDataInterface.getListaLotti();
    }

    @Override
    public Sostanza getSostanzaByID(int id) {
        return sostanzaDataInterface.getSostanzaByID(id);
    }

    @Override
    public Sostanza getSostanzaByName(String nome) {
        return sostanzaDataInterface.getSostanzaByNome(nome);
    }

    @Override
    public ArrayList<Sostanza> getListaSostanza() {
        return sostanzaDataInterface.getListaSostanze();
    }

    @Override
    public String[] getListaNomiSostanze(){
        return sostanzaDataInterface.getListaNomiSostanze();
    }

    @Override
    public double getLottoTotalCost(int id){

        return lottoDataInterface.getLottoById(id).getTotal();

    }

    @Override
    public double getTotalCostBySostanza(String nomeSostanza , double quantita , double purezza){
        Sostanza sostanza = getSostanzaByName(nomeSostanza);
        return sostanza.getCosto(quantita , purezza);
    }

    @Override
    public String getFormulaBySostanza(String nomeSostanza){
        Sostanza sostanza = sostanzaDataInterface.getSostanzaByNome(nomeSostanza);
        return sostanza.getFormula();
    }

    @Override
    public Lotto createLottoObjectNoPersistence(LocalDate dataDiScadenza , double quantita , Sostanza sostanza , double purezza){
        return new Lotto(dataDiScadenza , quantita , sostanza , purezza);

    }

    //-- SetDataInterface --
    @Override
    public void saveLotto(LocalDate dataScadenza, double quantita, String sostanzaNome , double purezza) {
        Sostanza sostanza = sostanzaDataInterface.getSostanzaByNome(sostanzaNome);
        Lotto lotto = new Lotto(dataScadenza, quantita, sostanza , purezza);
        lotto.storeLotto();
    }

    @Override
    public Lotto saveAndRetrievelotto(LocalDate dataScadenza, double quantita, String sostanzaNome , double purezza){

        Sostanza sostanza = sostanzaDataInterface.getSostanzaByNome(sostanzaNome);
        Lotto lotto = new Lotto(dataScadenza, quantita, sostanza , purezza);
        return lottoDataInterface.saveAndRetrieveLotto(lotto);
    }

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
        lotto = lottoDataInterface.getLottoById(idLotto);
        return lotto.getInfoLottoFormattate();
    }

    /**
     * Restituisce la quantità di un certo lotto.
     *
     * @param idLotto Id del lotto.
     * @return Quantità della sostanza nel lotto.
     */
    @Override
    public double getQuantitaLotto(int idLotto) {
        lotto = lottoDataInterface.getLottoById(idLotto);
        return lotto.getQuantita();
    }

    /**
     * Esegue il prelievo di una sostanza dall'armadietto.
     *
     * @param idLotto Id del lotto da cui prelevare.
     * @param quantita Quantità della sostanza da prelevare dal lotto.
     */
    @Override
    public void eseguiPrelievo(int idLotto, double quantita) {
        armadietto = new Armadietto();
        armadietto.eseguiPrelievo(idLotto, quantita);
    }
}
