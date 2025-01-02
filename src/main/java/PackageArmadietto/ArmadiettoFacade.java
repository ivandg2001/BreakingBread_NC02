package PackageArmadietto;

import java.sql.SQLException;
import java.util.ArrayList;

public class ArmadiettoFacade {

    private Armadietto armadietto;
    private Lotto lotto;
    private Sostanza sostanza;

    // Costruttore
    public ArmadiettoFacade() {
        this.armadietto = new Armadietto();
        this.lotto = new Lotto();
        this.sostanza = new Sostanza();
    }

    // elenco servizi

    /**
     * Metodo che permette di ottenre la lista di tutte le sostanze resenti nell'armadietto
     * @return lista sostanze
     */
    public ArrayList<Sostanza> getListaSostanze() {
        return this.armadietto.getListaSostanze();
    }

    public String getNomeSostanza() {
        // TODO
        return null;
    }

    public String getFormulaChimicaSostanza() {
        // TODO
        return null;
    }

    public Double getPurezzaSostanza() {
        // TODO
        return null;
    }


}
