package PackageArmadietto;

import java.time.LocalDate;
import java.util.ArrayList;

public class ArmadiettoFacade implements ArmadiettoSetDataInterface , ArmadiettoGetDataInterface {

    private final static LottoDataInterface lottoDataInterface = new LottoDAO();
    private final static SostanzaDataInterface sostanzaDataInterface = new SostanzaDAO();
    private final Armadietto armadietto;

    public ArmadiettoFacade() {
        this.armadietto = new Armadietto(lottoDataInterface.getListaLotti());
    }

    //-- GetDataInterface --

    @Override
    public Lotto getLottoByID(int id) {
        return lottoDataInterface.getLottoById(id);
    }

    @Override
    public ArrayList<Lotto> getListaLotti() {
        return this.armadietto.getLotti();
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

    //-- SetDataInterface --
    @Override
    public void saveLotto(LocalDate dataScadenza, double quantita, Sostanza sostanza) {
        Lotto lotto = new Lotto(dataScadenza, quantita, sostanza);
        lotto.storeLotto();
        updateArmadietto();
    }

    @Override
    public void saveSostanza(String nome, String formula, double costoUnitario) {
        Sostanza sostanza = new Sostanza(nome, formula, costoUnitario);
        sostanza.storeSostanza();
    }

    //--------

    /**
     * Metodo che aggiorna l'armadietto, viene chiamato quando si ha un aggiunta di un lotto.
     */
    public void updateArmadietto() {
        this.armadietto.setLotti(lottoDataInterface.getListaLotti());
    }
}
