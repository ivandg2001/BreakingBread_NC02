package PackagePrelievoSostanza;

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
    private LocalDate data;

    /**
     * Quantità di sostanza prelevata dal prelievo
     */
    private double quantita;

    /**
     * Lotto su cui è stato effettuato il prelievo
     */
    private Lotto lotto;

    /**
     * Ricercatore che ha effettuato l'ordine
     */
    private Ricercatore ricercatore;

    /**
     * Costruttore predefinito
     */
    public Prelievo(){}

    /**
     * Costruttore parametrico per inizializzare i campi.
     *
     * @param data Data in cui è stato effettuato il prelievo.
     * @param quantita quantità prelevata.
     * @param lotto Lotto da cui è stato effettuato il prelievo.
     * @param ricercatore Ricercatore che ha effettuato il prelievo.
     */
    public Prelievo(LocalDate data, double quantita, Lotto lotto, Ricercatore ricercatore) {
        this.data = data;
        this.quantita = quantita;
        this.lotto = lotto;
        this.ricercatore = ricercatore;
    }

    /**
     * Ritorna l'ID del prelievo
     * @return ID prelievo
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Setta l'id del prelievo
     * @param ID id prelievo
     */
    public void setID(int ID) {
        this.ID = ID;
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
     * Setta la data in cui e' stato effettuato il prelievo
     * @param data data del prelievo
     */
    public void setData(LocalDate data) {
        this.data = data;
    }

    /**
     * Ritorna la data in cui e' stato effettuato il prelievo
     * @return data del prelievo
     */
    public LocalDate getData() {
        return this.data;
    }

    /**
     * Setta il lotto associato al prelievo
     * @param lotto lotto prelievo
     */
    public void setLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    /**
     * Ritorna il lotto associato al prelievo
     * @return lotto prelievo
     */
    public Lotto getLotto() {
        return this.lotto;
    }

    /**
     * Setta il ricercatore associato al prelievo
     * @param ricercatore ricercatore prelievo
     */
    public void setRicercatore(Ricercatore ricercatore) {
        this.ricercatore = ricercatore;
    }

    /**
     * Ritorna il ricercatore associato al prelievo
     * @return ricercatore prelievo
     */
    public Ricercatore getRicercatore() {
        return this.ricercatore;
    }

    /**
     * Salva il Prelievo corrente nel database.
     */
    public void store() {
        PrelievoDataInterface prelievoDI = new PrelievoDAO();
        prelievoDI.setPrelievo(this);
    }
}
