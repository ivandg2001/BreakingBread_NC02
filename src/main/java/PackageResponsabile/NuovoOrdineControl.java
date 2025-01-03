package PackageResponsabile;

import PackageArmadietto.ArmadiettoFacade;
import PackageArmadietto.ArmadiettoGetDataInterface;
import PackageArmadietto.Sostanza;

import java.time.LocalDate;
import java.util.ArrayList;



public class NuovoOrdineControl {

    public NuovoOrdineControl() {}

    public void creaNuovoOrdine() {

        /*
        * 1. Prendere dal database la lista delle sostanze
        * 2. Utilizzare tale lista per creare il form
        * 3. Prendere l'input dall'utente (tornare indietro nel caso)
        * 4. Creare l'oggetto ordine a seconda dell'input fornito dall'utente
        * 5. Creare schermata di riepilogo con l'ordine appena creato (tornare indietro se necessario)
        * 6. Aggiungere ordine nel sistema
        * 7. Mostrare pop-up di conferma
        * 8. Tornare nella homepage del responsabile
        * */

        // acquisizione lista sostanze
        ArmadiettoFacade armadiettoFacade = new ArmadiettoFacade();
        ArrayList<Sostanza> listaSostanze = armadiettoFacade.getListaSostanze();

        // InputUtente = new

        while (true) {
            // InputUtente inputUtente = new InputUtente()

            switch (creaFormOrdine()) {
                case 1:
            }
            while (true) {
                while (true) {

                }
            }
        }

        //OrdineForm ordineForm = new OrdineForm();
        //ordineForm

        //info dal form


        // creazione dell'oggetto ordine
        //Lotto lotto = new Lotto(temp);
       // LocalDate today = LocalDate.now();
        //Ordine ordine = new Ordine(today, 12.3, responsabile, lotto);

        // crea schermata di riepilogo
        //String nomeSostanza = armadiettoFacade.getNomeSostanza();
       // String formulaChimica = armadiettoFacade.getFormulaChimicaSostanza();
        //Double purezza = armadiettoFacade.getPurezzaSostanza();
        //int priorita = 8;
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
    private int creaFormOrdine() {
        return 0;
    }

    /**
     * Crea e stampa a schermo il riepilogo del nuovo ordine
     *
     * @return true se il nuovo ordine viene confermato, false se viene rifiutato
     */
    private boolean creaRiepilogoOrdine() {
        return false;
    }

    /**
     * Crea popup di conferma di avvenuto inserimento del nuovo ordine nel sistema
     */
    private void creaPopup() {
        return;
    }
}


