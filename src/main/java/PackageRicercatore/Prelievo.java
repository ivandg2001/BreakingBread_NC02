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
    private LocalDate data;

    /**
     * Quantità di sostanza prelevata dal prelievo
     */
    private double quantita;

    /**
     * Lotto su cui è stato effettuato il prelievo
     */
    private int lottoID;

    /**
     * ricercatore che ha effettuato l'ordine
     */
    private int ricercatoreID;

    /**
     * Costruttore predefinito
     */
    public Prelievo(){}

    /**
     * Costruttore parametrico per inizializzare i campi
     * @param data Data in cui è stato effettuato il prelievo
     * @param lottoID Lotto su cui è stato effettuato il prelievo
     * @param quantita quantita' prelevata con il prelievo
     * @param ricercatoreID id del ricercatore
     */
    public Prelievo(LocalDate data , int lottoID , double quantita , int ricercatoreID){
        this.data = data;
        this.lottoID = lottoID;
        this.quantita = quantita;
        this.ricercatoreID = ricercatoreID;
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
     * Setta l'id del lotto associato al prelievo
     * @param lottoID id del lotto
     */
    public void setLottoID(int lottoID) {
        this.lottoID = lottoID;
    }

    /**
     * Setta la data in cui e' stato effettuato il prelievo
     * @param data data del prelievo
     */
    public void setData(LocalDate data) {
        this.data = data;
    }

    /**
     * Setta l'id del ricercatore
     * @param ricercatoreID
     */
    public void setRicercatoreID(int ricercatoreID) {
        this.ricercatoreID = ricercatoreID;
    }

    /**
     * Ritorna l'id del lotto associato al prelievo
     * @return id del lotto
     */
    public int getLottoID() {
        return this.lottoID;
    }

    /**
     * Ritorna l'id del ricercatore assoviato al prelievo
     * @return id ricercatore
     */
    public int getRicercatoreID() {
        return this.ricercatoreID;
    }

    /**
     * Ritorna la data in cui e' stato effettuato il prelievo
     * @return data del prelievo
     */
    public LocalDate getData() {
        return this.data;
    }
}
