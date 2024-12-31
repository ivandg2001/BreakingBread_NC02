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
     * Costruttore predefinito
     */
    public Lotto() {

    }

    /**
     * Costruttore parametrico per inizializzare i campi dell'entità
     * @param dataScadenza data di scadenza del lotto
     * @param quantita quantità rimanente della sostanza nel lotto
     * @param sostanza ID della sostanza contenuta nel lotto
     */
    public Lotto(LocalDate dataScadenza , double quantita , Sostanza sostanza){
        this.dataScadenza = dataScadenza;
        this.sostanza = sostanza;
        this.quantita = quantita;
    }

    /**
     * Restituisce l'id del lotto
     * @return ID del lotto
     */
    public Integer getID() {
        return this.ID;
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
     * Ritorna la sostanza contenuta ne lotto
     * @return oggetto sostanza
     */
    public Sostanza getSostanza() {
        return this.sostanza;
    }

    /**
     * Setta la sostanza contenuta nel lotto
     * @param sostanza oggetto sostanza
     */
    public void setSostanza(Sostanza sostanza) {
        this.sostanza = sostanza;
    }

    /**
     * Setta id del lotto
     * @param ID id lotto
     */
    public void setID(int ID) {
        this.ID = ID;
    }
}
