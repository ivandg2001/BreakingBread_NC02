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
    private Responsabile responsabile;

    /**
     * Lotto inserito nell'ordine
     */
    private Lotto lotto;

    /**
     * Priorita' dell'ordine
     */
    private int priorita;


    /**
     * Costruttore predefinito, serve a JPA.
     */
    public Ordine() {

    }

    /**
     * Costruttore parametrico per inizializzare i campi dell'entità.
     *
     * @param dataOrdine   data in cui è stato effettuato l'ordine.
     * @param responsabile responsaile che ha effettuto l'ordine
     * @param lotto        lotto ordinato
     */
    public Ordine(LocalDate dataOrdine,  Responsabile responsabile, Lotto lotto) {
        this.dataOrdine = dataOrdine;
        this.costo = lotto.getSostanza().getCostoUnitario() * lotto.getQuantita();
        this.responsabile = responsabile;
        this.lotto = lotto;
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
     * Setta il responsabile associato a questo ordine.
     *
     * @param responsabile responsabile associato a questo ordine.
     */
    public void setResponsabile(Responsabile responsabile) {
        this.responsabile = responsabile;
    }

    /**
     * Ritorna il responsabile che ha effettuato questo ordine
     *
     * @return Reponsabile dell'ordine
     */
    public Responsabile getResponsabile() {
        return this.responsabile;
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
     * Ritorna il lotto dell'ordine
     * @return lotto ordine
     */
    public Lotto getLotto() {
        return this.lotto;
    }
}