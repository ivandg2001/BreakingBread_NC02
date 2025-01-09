package PackageResponsabile;

import PackageArmadietto.*;
import PackageGraphics.AppFrame;
import PackageGraphics.ResponsabileHomepage;

import java.time.LocalDate;

public class NuovoOrdineControl implements ResponsabileInterface{

    private AppFrame frame;
    private Responsabile responsabile;


    public NuovoOrdineControl(AppFrame frame, Responsabile responsabile) {
        this.frame = frame;
        this.responsabile = responsabile;
    }

    public void creaNuovoOrdine() {
        creaFormOrdine();
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
    public void setInfoNuovoOrdine(String sostanza , double purezza , double quantita , Integer priorita){

        System.out.println(isValidOrdineInfos(sostanza,purezza,quantita,priorita));
        if( isValidOrdineInfos(sostanza,purezza,quantita,priorita) ){
            creaRiepilogoOrdine(creaOggettoOrdine(sostanza,purezza,quantita,priorita) , sostanza , purezza , quantita , priorita);
        }else {
            creaPopup("Qualcosa e'andato storto");
            creaFormOrdine();
        }

    }

    public boolean isValidOrdineInfos(String sostanza, double purezza, double quantita, Integer priorita) {

        ArmadiettoGetDataInterface facadeInterface = new ArmadiettoFacade();

        if (!isValidSostanza(sostanza, facadeInterface)) {
            System.out.println(1);
            return false;
        }

        if (!isValidPurezza(purezza)) {
            System.out.println(2);
            return false;
        }

        if (!isValidQuantita(quantita)) {
            System.out.println(3);
            return false;
        }

        if (!isValidPriorita(priorita)) {
            System.out.println(4);
            return false;
        }

        return true;
    }

    public boolean isValidSostanza(String sostanza, ArmadiettoGetDataInterface facadeInterface) {
        return facadeInterface.getSostanzaByName(sostanza) != null;
    }

    public boolean isValidPurezza(double purezza) {
        return purezza > 0 && purezza <= 100;
    }

    public boolean isValidQuantita(double quantita) {
        return quantita > 0 && quantita <= 100000;
    }

    public boolean isValidPriorita(Integer priorita) {
        return priorita != null && (priorita == 1 || priorita == 2 || priorita == 3);
    }









    public Ordine creaOggettoOrdine(String sostanza , double purezza , double quantita , Integer priorita){

        ArmadiettoGetDataInterface facadeInterface = new ArmadiettoFacade();

        double costo = facadeInterface.getTotalCostBySostanza(sostanza , quantita , purezza);
        return new Ordine(LocalDate.now() , priorita , costo , this.responsabile);

    }

    /**
     * Crea e stampa a schermo il riepilogo del nuovo ordine
     *
     * @return true se il nuovo ordine viene confermato, false se viene rifiutato
     */
    public void creaRiepilogoOrdine(Ordine nuovoOrdine , String sostanza , double purezza , double quantita , Integer priorita) {

        RiepilogoOrdine riepilogo = new RiepilogoOrdine(this.frame , this , nuovoOrdine , sostanza , purezza , quantita , priorita);
        riepilogo.display();
    }

    /**
     * Metodo che finalizza l'inserimneto del nuovo ordine, viene chiamato dall'action listener per la conferma nel riepilogo finale
     * @param nuovoOrdine nuovo ordine che si tenta di inserire
     */
    public void finalizzaOrdine(Ordine nuovoOrdine , String sostanza , double purezza , double quantita , Integer priorita) {

        ArmadiettoSetDataInterface i = new ArmadiettoFacade();
        LocalDate dataScadenzaLotto = LocalDate.now().plusYears(5);
        nuovoOrdine.setLotto(i.saveAndRetrievelotto(dataScadenzaLotto , quantita , sostanza , purezza));
        nuovoOrdine.storeOrdine();

        ResponsabileHomepage hm = new ResponsabileHomepage(this.frame , this.responsabile);
        hm.display();

    }

    /**
     * Crea popup di conferma di avvenuto inserimento del nuovo ordine nel sistema
     */
    public void creaPopup(String message) {
        this.frame.showErrorDialog(message);
    }

    public void confermaPopup(String message){
        this.frame.showConfirmDialog(message);
    }
}


