package PackageResponsabile;

import PackageArmadietto.ArmadiettoFacade;
import PackageArmadietto.ArmadiettoGetDataInterface;
import PackageArmadietto.Sostanza;
import PackageArmadietto.SostanzaDataInterface;
import PackageGraphics.AppFrame;
import PackageGraphics.Homepage;
import PackageGraphics.ResponsabileHomepage;

public class NuovoOrdineControl {

    private AppFrame frame;
    private Responsabile responsabile;

    public NuovoOrdineControl(AppFrame frame, Responsabile responsabile) {
        this.frame = frame;
        this.responsabile = responsabile;
    }

    public void creaNuovoOrdine() {

        creaFormOrdine();

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
     */
    private void creaFormOrdine() {
        // acquisizione lista sostanze
        ArmadiettoGetDataInterface facadeInterface = new ArmadiettoFacade();
        OrdineForm ordineForm = new OrdineForm(frame , this);
        ordineForm.display(facadeInterface.getListaNomiSostanze());

    }

    public void annullaOrdine() {
        ResponsabileHomepage hm = new ResponsabileHomepage(this.frame , this.responsabile);
        hm.display();
    }

    public void setInfoNuovoOrdine(String sostanza , double purezza , double quantita , String priorita){
        // validazione



        creaOggettoOrdine();
    }

    public void creaOggettoOrdine(){

    }


    /**
     * Crea e stampa a schermo il riepilogo del nuovo ordine
     *
     * @return true se il nuovo ordine viene confermato, false se viene rifiutato
     */
    private void creaRiepilogoOrdine() {
        return;
    }

    /**
     * Crea popup di conferma di avvenuto inserimento del nuovo ordine nel sistema
     */
    private void creaPopup() {
        return;
    }
}


