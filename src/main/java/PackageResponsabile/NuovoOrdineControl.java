package PackageResponsabile;

import PackageArmadietto.*;
import PackageGraphics.AppFrame;
import PackageGraphics.Homepage;
import PackageGraphics.ResponsabileHomepage;

import java.time.LocalDate;
import java.time.temporal.TemporalAmount;

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

    /**
     *
     * @param sostanza
     * @param purezza
     * @param quantita
     * @param priorita
     * @return
     */
    public Ordine setInfoNuovoOrdine(String sostanza , double purezza , double quantita , Integer priorita){


        if( isValidOrdineInfos(sostanza,purezza,quantita,priorita) ){
            return creaOggettoOrdine(sostanza,purezza,quantita,priorita);
        }else {
            creaPopup();
        }

        return null;

    }

    public boolean isValidOrdineInfos(String sostanza , double purezza , double quantita , Integer priorita){

        ArmadiettoGetDataInterface facadeInterface = new ArmadiettoFacade();

        if(!(facadeInterface.getSostanzaByName(sostanza) != null)){

            return false;

        }

        else if(purezza > 100 || purezza < 0){
            return false;
        }

        else if (quantita > 100000 || quantita < 0){
            return false;
        }

        else if (priorita == null){
            return false;
        }

        else
            return true;


    }

    public Ordine creaOggettoOrdine(String sostanza , double purezza , double quantita , Integer priorita){

        ArmadiettoGetDataInterface facadeInterface = new ArmadiettoFacade();
        int nuovoLottoID = creaOggettoNuovoLotto(sostanza , quantita , purezza);

        double costo = facadeInterface.getLottoTotalCost(nuovoLottoID);

        return new Ordine(LocalDate.now() , priorita , costo , this.responsabile , nuovoLottoID);


    }

    public int creaOggettoNuovoLotto(String sostanza , double quantita , double purezza){

        ArmadiettoSetDataInterface facadeSetInterface = new ArmadiettoFacade();

        LocalDate dataDiScadenza = LocalDate.now().plusYears(5);
        return facadeSetInterface.saveAndRetrievelotto(dataDiScadenza , quantita , sostanza , purezza).getID();

    }


    /**
     * Crea e stampa a schermo il riepilogo del nuovo ordine
     *
     * @return true se il nuovo ordine viene confermato, false se viene rifiutato
     */
    private void creaRiepilogoOrdine(Ordine nuovoOrdine) {

        // qui devee creare la schermata riepilogo e la schermata dovra' chiamare un metodo per finalizzare l'inserimneto

    }

    /**
     * Metodo che finalizza l'inserimneto del nuovo ordine, viene chiamato dall'action listener per la conferma nel riepilogo finale
     * @param nuovoOrdine nuovo ordine che si tenta di inserire
     */
    private void finalizzaOrdine(Ordine nuovoOrdine) {
        nuovoOrdine.storeOrdine();
    }

    /**
     * Crea popup di conferma di avvenuto inserimento del nuovo ordine nel sistema
     */
    private void creaPopup() {
        return;
    }
}


