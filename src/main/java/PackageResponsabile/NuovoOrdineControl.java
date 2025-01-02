package PackageResponsabile;

import PackageArmadietto.ArmadiettoFacade;
import PackageArmadietto.Sostanza;

import java.time.LocalDate;
import java.util.ArrayList;

public class NuovoOrdineControl {

    public static void creaNuovoOrdine(Responsabile responsabile) {





        // acquisizione lista sostanze
        ArmadiettoFacade armadiettoFacade = new ArmadiettoFacade();
        ArrayList<Sostanza> listaSostanze = armadiettoFacade.getListaSostanze();

        // crea form da compilare

        //info dal form


        // creazione dell'oggetto ordine
        //Lotto lotto = new Lotto(temp);
        LocalDate today = LocalDate.now();
        //Ordine ordine = new Ordine(today, 12.3, responsabile, lotto);

        // crea schermata di riepilogo
        String nomeSostanza = armadiettoFacade.getNomeSostanza();
        String formulaChimica = armadiettoFacade.getFormulaChimicaSostanza();
        Double purezza = armadiettoFacade.getPurezzaSostanza();
        int priorita = 8;
        // Stampa schermata di riepilogo

        // Inserimento dell'ordine nel sistema
        //DAO

        // Torna schermata Home
        // Stampa popup di Conferma
    }

    /**
     * Crea e stampa a schermo il form di inserimento di un nuovo ordine.
     *
     * @return 1 se la compilazione del form è avvenuta con successo; 0 se la funzionalità è stata annullata; -1 se la compilazione va ripetuta.
     */
    private static int creaFormOrdine() {
        return 0;
    }

    /**
     * Crea e stampa a schermo il riepilogo del nuovo ordine
     *
     * @return true se il nuovo ordine viene confermato, false se viene rifiutato
     */
    private static boolean creaRiepilogoOrdine() {
        return false;
    }

    /**
     * Crea popup di conferma di avvenuto inserimento del nuovo ordine nel sistema
     */
    private static void creaPopup() {
        return;
    }
}
