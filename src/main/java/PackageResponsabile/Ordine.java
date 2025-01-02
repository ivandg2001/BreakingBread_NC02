package PackageResponsabile;

import PackageArmadietto.Lotto;
import java.time.LocalDate;

/**
 * Classe POJO che rappresenta un Ordine nel sistema, mappato da un adapter JPA.
 */

public class Ordine {

    /**
     * Id dell'oggetto ordine, chiave primaria della tabella, proprieta' di autoincrement.
     */

    private int ID;      //Chiavie primaria, autoincrement

    /**
     * Data in cui e' stato effettuato l'ordine.
     */

    private LocalDate dataOrdine;     //

    /**
     * Costo totale dell'ordine effettuato.
     */

    private double costo;

    /**
     * Responsabile che ha effettuato l'ordine
     */
    private int responsabileID;

    /**
     * Lotto inserito nell'ordine
     */
    private int lottoID;

    /**
     * Priorita' dell'ordine
     */
    private int priorita;


    /**
     * Costruttore predefinito
     */
    public Ordine() {

    }

    /**
     * Costruttore parametrico per inizializzare i campi dell'entità.
     *
     * @param dataOrdine   data in cui è stato effettuato l'ordine.
     * @param responsabileID responsaile che ha effettuto l'ordine
     * @param lottoID        lotto ordinato
     */
    public Ordine(LocalDate dataOrdine,  int responsabileID, int lottoID , int priorita , double costo) {
        this.dataOrdine = dataOrdine;
        this.responsabileID = responsabileID;
        this.lottoID = lottoID;
        this.priorita = priorita;
        this.costo = costo;
    }

    //--Getters and Setters--

    /**
     * Ritorna l'id dell'ordine
     *
     * @return id dell'ordine
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Ritorna la data dell'ordine effettuato.
     *
     * @return Data dell'ordine, formato LocalDate.
     */
    public LocalDate getDataOrdine() {
        return this.dataOrdine;
    }

    /**
     * Setta la data in cui e' stato effettuato l'ordine.
     *
     * @param dataOrdine data in cui e' stato effettuato l'ordine.
     */
    public void setDataOrdine(LocalDate dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    /**
     * Ritorna il costo dell'ordine.
     *
     * @return costo dell'ordine, double.
     */
    public double getCosto() {
        return this.costo;
    }

    /**
     * Setta il costo dell'ordine effettuato.
     *
     * @param costo costo dell'ordine effettuato.
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    /**
     * Setta id dell'ordine
     * @param ID id ordine
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Setta la priorita' dell'ordine
     * @param priorita priorita' ordine
     */
    public void setPriorita(int priorita) {
        if (priorita < 0 || priorita > 3 ) {
            throw new IllegalArgumentException();
        }else {
            this.priorita = priorita;
        }
    }

    /**
     * Ritorna la priorita' dell'ordine
     * @return priorita ordine
     */
    public int getPriorita() {
        return this.priorita;
    }

    /**
     * Setta id del lotto associato all'ordine
     * @param lottoID id lotto
     */
    public void setLottoID(int lottoID) {
        this.lottoID = lottoID;
    }

    /**
     * Setta l'id del responsabile associato all'ordine
     * @param responsabileID
     */
    public void setResponsabileID(int responsabileID) {
        this.responsabileID = responsabileID;
    }

    /**
     * Ritorna l'id del lotto associato all'ordine
     * @return id lotto
     */
    public int getLottoID() {
        return lottoID;
    }

    /**
     * Ritorna l'id del responsabile associato all'ordine
     * @return id responsabile
     */
    public int getResponsabileID() {
        return responsabileID;
    }
}