package PackageArmadietto;

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

    // implementato da Armadietto
    public ArrayList<Sostanza> getListaSostanze() {
        // TODO
        return null;
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
