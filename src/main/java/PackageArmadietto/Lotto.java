package PackageArmadietto;

import PackageResponsabile.Ordine;
import PackageRicercatore.Prelievo;


import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Classe POJO che rappresenta un lotto nel sistema, mappato da un adapter JPA.
 */


public class Lotto {

    /**
     * ID usato per identificare singolarmente i lotti
     */
    private int ID;
    /**
     * Data di scadenza del lotto
     */
    private LocalDate dataScadenza;
    /**
     * Quantità di sostanza attualmente presente nel lotto
     */
    private double quantita;

    /**
     * Sostanza contenuta nel lotto, si fa riferimento all'ID
     */
    private Sostanza sostanza;

    /**
     * Preleivi effettuati sul lotto
     */
    private ArrayList<Prelievo> prelievi;

    /**
     * Ordine associato al lotto
     */
    private Ordine ordine;

    /**
     * Armadietto dove si trova il lotto
     */
    private Armadietto armadietto;

    /**
     * Costruttore predefinito
     */
    public Lotto() {
        this.prelievi = new ArrayList<>();
    }

    /**
     * Costruttore parametrico per inizializzare i campi dell'entità
     * @param dataScadenza data di scadenza del lotto
     * @param quantita quantità rimanente della sostanza nel lotto
     * @param sostanza sostanza contenuta nel lotto
     */
    public Lotto(LocalDate dataScadenza , double quantita , Sostanza sostanza){
        this.dataScadenza = dataScadenza;
        this.sostanza = sostanza;
        this.quantita = quantita;
        this.prelievi = new ArrayList<>();
    }

    /**
     * Restituisce l'id del lotto
     * @return ID del lotto
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Setta id del lotto
     * @param ID id lotto
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Restituisce la data di scadenza del lotto
     *
     * @return data di scadenza dell'oggetto corrente
     */

    public LocalDate getDataScadenza() {return this.dataScadenza;}

    /**
     * Imposta la data di scadenza di un lotto
     *
     * @param dataScadenza data di scadenza
     */
    public void setDataScadenza(LocalDate dataScadenza) {this.dataScadenza = dataScadenza;}

    /**
     * Restituisce la quantità di sostanza presente nel lotto
     *
     * @return quantità della sostanza nel lotto
     */
    public double getQuantita() {return quantita;}

    /**
     * Imposta la data quantità di sostanza nel lotto
     *
     * @param quantita quantità di sostanza nel lotto
     */
    public void setQuantita(double quantita) {this.quantita = quantita;}

    /**
     * Setta l'id della sostanza associata al lotto
     * @param sostanza id sostanza
     */
    public void setSostanza(Sostanza sostanza) {
        this.sostanza = sostanza;
    }

    /**
     * Ritorna l'id della sostanza associata al lotto
     * @return id sostanza
     */
    public Sostanza getSostanza() {
        return this.sostanza;
    }

    /**
     * Setta l'ordine associato al lotto
     * @param ordine ordine lotto
     */
    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    /**
     * Ritorna l'ordine associato al lotto
     * @return ordine lotto
     */
    public Ordine getOrdine() {
        return this.ordine;
    }

    /**
     * Setta i prelievi associati al lotto
     * @param prelievi prelievi lotto
     */
    public void setPrelievi(ArrayList<Prelievo> prelievi) {
        this.prelievi = prelievi;
    }

    /**
     * Ritorna i prelievi associati al lotto
     * @return prelievi lotto
     */
    public ArrayList<Prelievo> getPrelievi() {
        return this.prelievi;
    }

    /**
     * Seta l'armadietto contenente il lotto
     * @param armadietto armadietto
     */
    public void setArmadietto(Armadietto armadietto) {
        this.armadietto = armadietto;
    }

    /**
     * Ritorn l'armadietto contenente il lotto
     * @return armadietto
     */
    public Armadietto getArmadietto() {
        return armadietto;
    }
}
