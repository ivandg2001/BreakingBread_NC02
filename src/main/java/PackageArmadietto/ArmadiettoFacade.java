package PackageArmadietto;

import java.time.LocalDate;
import java.util.ArrayList;

public class ArmadiettoFacade implements ArmadiettoSetDataInterface , ArmadiettoGetDataInterface {

    private final static LottoDataInterface lottoDataInterface = new LottoDAO();
    private final static SostanzaDataInterface sostanzaDataInterface = new SostanzaDAO();


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
    public Lotto createLottoObjectNoPersistance(LocalDate dataDiScadenza , double quantita , Sostanza sostanza , double purezza){
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


}
