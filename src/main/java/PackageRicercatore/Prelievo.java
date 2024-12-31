package PackageRicercatore;

import PackageArmadietto.Lotto;

import java.time.LocalDate;


/**
 * Classe POJO che rappresenta un prelievo nel sistema, mappato da un adapter JPA.
 */
public class Prelievo {

    /**
     * Id del prelievo di una sostanza
     */
    private int ID;

    /**
     * Data in cui è stato effettuato il prelievo
     */
    private LocalDate date;

    /**
     * Quantità di sostanza prelevata dal prelievo
     */
    private double quantita;

    /**
     * Lotto su cui è stato effettuato il prelievo
     */
    private Lotto lotto;

    /**
     * ricercatore che ha effettuato l'ordine
     */
    private Ricercatore ricercatore;

    /**
     * Costruttore predefinito
     */
    public Prelievo(){}

    /**
     * Costruttore parametrico per inizializzare i campi
     * @param Date Data in cui è stato effettuato il prelievo
     * @param lotto Lotto su cui è stato effettuato il prelievo
     */
    public Prelievo(LocalDate Date , Lotto lotto , double quantita){
        this.date = Date;
        this.lotto = lotto;
        this.quantita = quantita;
    }

    /**
     * Ritorna l'ID del prelievo
     * @return ID prelievo
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Ritorna il lotto su cui è stato effettuato il prelievo
     * @return Oggetto lotto
     */
    public Lotto getLotto() {
        return this.lotto;
    }

    /**
     * Setta il lotto su cui effettuare il prelievo
     * @param lotto Oggetto lotto
     */
    public void setLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    /**
     * Ritorna la data in cui è stato effettuato il prelievo
     * @return campo Date
     */
    public LocalDate getDate() {
        return this.date;
    }

    /**
     * Setta la data i cui è stato effettuato l'ordine
     * @param date campo date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Ritorna la quantità prelevata con questo prelievo
     * @return campo quantità
     */
    public double getQuantita() {
        return this.quantita;
    }

    /**
     * Setta la quantità da prelevare con questo prelievo
     * @param quantita campo quantità
     */
    public void setQuantita(double quantita) {
        this.quantita = quantita;
    }

    /**
     * Ritorna il ricercatore che ha effettuato il prelievo
     * @return oggetto ricercatore
     */
    public Ricercatore getRicercatore() {
        return this.ricercatore;
    }

    /**
     * Setta il ricercatore che ha effettuato questo prelievo
     * @param ricercatore oggetto ricercatore
     */
    public void setRicercatore(Ricercatore ricercatore) {
        this.ricercatore = ricercatore;
    }
}
