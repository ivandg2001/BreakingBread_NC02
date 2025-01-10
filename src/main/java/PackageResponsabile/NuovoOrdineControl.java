package PackageResponsabile;

import PackageArmadietto.*;
import PackageUtils.AppFrame;
import PackageUtils.ResponsabileHomepage;

import java.time.LocalDate;

/**
 * Classa controller che gestisce gli eventi per l'aggiunta di un nuovo ordine.
 */
public class NuovoOrdineControl implements ResponsabileInterface{

    /**
     * Frame della GUI.
     */
    private AppFrame frame;
    /**
     * Responsabile loggato.
     */
    private Responsabile responsabile;


    /**
     * Costruttore parametrico che inizializza gli attributi.
     * @param frame oggetto AppFrame.
     * @param responsabile oggetto Responsabile.
     */
    public NuovoOrdineControl(AppFrame frame, Responsabile responsabile) {
        this.frame = frame;
        this.responsabile = responsabile;
    }

    /**
     * Metodo da cui parte l'inserimento di un nuovo ordine.
     */
    public void creaNuovoOrdine() {
        creaFormOrdine();
    }

    /**
     * Crea e stampa a schermo il form di inserimento di un nuovo ordine.
     */
    private void creaFormOrdine() {

        ArmadiettoGetDataInterface facadeInterface = new ArmadiettoFacade();
        OrdineForm ordineForm = new OrdineForm(frame , this);
        ordineForm.display(facadeInterface.getListaNomiSostanze());

    }

    /**
     * Metodo che annulla l'inserimento del nuovo ordine.
     */
    public void annullaOrdine() {
        ResponsabileHomepage hm = new ResponsabileHomepage(this.frame , this.responsabile);
        hm.display();
    }

    /**
     * Metodo che prende le informazioni dal form, le passa alla validazione e se va tutto bene li setta in un oggetto Ordine, questo oggetto ordine sara' sempicememente compilato e non ancora inserito nel database.
     * @param sostanza nome della sostanza.
     * @param purezza purezza della sostanza.
     * @param quantita quantita della sostanza.
     * @param priorita priorita' dell'ordine.
     */
    public void setInfoNuovoOrdine(String sostanza , double purezza , double quantita , Integer priorita){

        System.out.println(isValidOrdineInfos(sostanza,purezza,quantita,priorita));
        if( isValidOrdineInfos(sostanza,purezza,quantita,priorita) ){
            creaRiepilogoOrdine(creaOggettoOrdine(sostanza,purezza,quantita,priorita) , sostanza , purezza , quantita , priorita);
        }else {
            creaPopup("Qualcosa e'andato storto, valori inseriti non validi, riprova . . .");
            creaFormOrdine();
        }

    }

    /**
     * Metodo di validazione delle informazioni che l'utente ha inserito nel form.
     * @param sostanza nome della sostanza.
     * @param purezza purezza della sostanza.
     * @param quantita quantita della sostanza.
     * @param priorita priorita' dell'ordine.
     * @return true se va tutto bene , false se qualcosa va storto.
     */
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

    /**
     * Valida la sostanza inserita nel form.
     * @param sostanza nome della sostanza.
     * @param facadeInterface interfaccia facade ch emi permette di comunciare con il package armadietto.
     * @return true se la validazione va a buon fine, false se non l'informazione inserita e' errata
     */
    public boolean isValidSostanza(String sostanza, ArmadiettoGetDataInterface facadeInterface) {
        return facadeInterface.getSostanzaByName(sostanza) != null;
    }

    /**
     * Valida la purezza inserita nel form, non deve essere negativa o superiore al 100, non puo' essere null e non puo' essere di un formato diverso da double
     * @param purezza purezza inserita
     * @return true se la validazione va a buon fine, false se non l'informazione inserita e' errata
     */
    public boolean isValidPurezza(Object purezza) {

        if(purezza == null){
            return false;
        }

        try {

            double valore = Double.parseDouble(purezza.toString());

            return valore > 0 && valore <= 100;
        } catch (NumberFormatException e) {

            return false;
        }

    }

    /**
     * Metodo che valida la quantita inserita nel form, non deve essere nulla, non deve essere negativa o superiore a 100000 , non deve essere di un formato diverso da double
     * @param quantita quantita inserita
     * @return true se la validazione va a buon fine, false se non l'informazione inserita e' errata
     */
    public boolean isValidQuantita(Object quantita) {

        if(quantita == null){
            return false;
        }

        try {

            double valore = Double.parseDouble(quantita.toString());

            return valore > 0 && valore <= 100000;
        } catch (NumberFormatException e) {

            return false;
        }



    }

    /**
     * Metodo che valida la priorita, questa puo essere solo tra 1 , 2 e 3 qualsiasi altro valore e' invalido, non puo' essere null e non puo' essere di un formato diverso da int
     * @param priorita priorita inserita
     * @return true se la validazione va a buon fine, false se non l'informazione inserita e' errata
     */
    public boolean isValidPriorita(Object priorita) {

        if (priorita == null){
            return false;
        }

        try {

            int valore = Integer.parseInt(priorita.toString());

            return (valore == 1 || valore == 2 || valore == 3);
        } catch (NumberFormatException e) {

            return false;
        }


    }

    /**
     * Metodo che crea l'oggetto ordine dalle informazioni inserite nel form. Inserisce anche il costo a partire dalle informazioni inserite.
     * @param sostanza nome della sostanza.
     * @param purezza purezza della sostanza.
     * @param quantita quantita della sostanza.
     * @param priorita priorita' dell'ordine.
     * @return oggetto ordine compilato
     */
    public Ordine creaOggettoOrdine(String sostanza , double purezza , double quantita , Integer priorita){

        ArmadiettoGetDataInterface facadeInterface = new ArmadiettoFacade();

        double costo = facadeInterface.getTotalCostBySostanza(sostanza , quantita , purezza);
        return new Ordine(LocalDate.now() , priorita , costo , this.responsabile);

    }

    /**
     * Metodo che apre il riepilogo del nuovo ordine costruito a partire dalle informazioni inserite nel form.
     * @param nuovoOrdine oggetto Ordine compilato
     * @param sostanza nome della sostanza.
     * @param purezza purezza della sostanza.
     * @param quantita quantita della sostanza.
     * @param priorita priorita' dell'ordine.
     */
    public void creaRiepilogoOrdine(Ordine nuovoOrdine , String sostanza , double purezza , double quantita , Integer priorita) {

        RiepilogoOrdine riepilogo = new RiepilogoOrdine(this.frame , this , nuovoOrdine , sostanza , purezza , quantita , priorita);
        riepilogo.display();
    }

    /**
     * Metodo che finalizza l'inserimento del nuovo ordine nel database, crea il nuovo lotto mediante l'interfaccia facade e poi salva l'ordine corrispondente
     * @param nuovoOrdine Ordine da inserire nel database
     * @param sostanza nome della sostanza.
     * @param purezza purezza della sostanza.
     * @param quantita quantita della sostanza.
     * @param priorita priorita' dell'ordine.
     */
    public void finalizzaOrdine(Ordine nuovoOrdine , String sostanza , double purezza , double quantita , Integer priorita) {

        ArmadiettoSetDataInterface i = new ArmadiettoFacade();
        LocalDate dataScadenzaLotto = LocalDate.now().plusYears(5);

        try{
            nuovoOrdine.setLotto(i.saveAndRetrievelotto(dataScadenzaLotto , quantita , sostanza , purezza));
            nuovoOrdine.storeOrdine();
        } catch (Exception e) {
            creaPopup("Errore imprevisto nella finalizzazione dell'ordine, controlla il server database e riprova . . .");
            annullaOrdine();
        }


        ResponsabileHomepage hm = new ResponsabileHomepage(this.frame , this.responsabile);
        hm.display();

    }

    /**
     * Crea popup all'avvento di errori
     * @param message messaggio da far visualizzare nel popup
     */
    public void creaPopup(String message) {
        this.frame.showErrorDialog(message);
    }

    /**
     * Crea il popup di conferma per l'inserimento dell'ordine
     * @param message messaggio da far visualizzare nel popup
     */
    public void confermaPopup(String message){
        this.frame.showConfirmDialog(message);
    }
}


