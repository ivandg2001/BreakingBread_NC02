package PackageArmadietto;

import java.util.List;

/**
 * Classe POJO che rappresenta una sostanza nel sistema, mappato da un adapter JPA.
 */
public class Sostanza {

    /**
     * ID usato per identificare singolarmente le sostanze nel database
     */
    private int ID;
    /**
     * Data di scadenza del lotto
     */
    private String nome;
    /**
     * Quantità di sostanza attualmente presente nel lotto
     */
    private String formula;
    /**
     * Costo della sostanza per ogni unità della stessa
     */
    private double costoUnitario;


    /**
     * Costruttore vuoto
     */
    public Sostanza() {}

    /**
     * Costruttore parametrico che inizializza i campi
     * @param ID id sostanza
     * @param nome nome sostanza
     * @param formula formula della sostanza
     * @param costoUnitario costo unitario della sostanza
     */
    public Sostanza(int ID, String nome, String formula, double costoUnitario) {
        this.ID = ID;
        this.nome = nome;
        this.formula = formula;
        this.costoUnitario = costoUnitario;
    }
    /**
     * Restituisce il nome della sostanza
     *
     * @return nome della sostanza
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome della sostanza
     *
     * @param nome nome della sostanza
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce la formula della sostanza
     *
     * @return formula della sostanza
     */
    public String getFormula() {
        return formula;
    }

    /**
     * Imposta la formula della sostanza
     *
     * @param formula formula della sostanza
     */
    public void setFormula(String formula) {
        this.formula = formula;
    }

    /**
     * Restituisce il costo della sostanza per unità
     *
     * @return costo della sostanza per unità
     */
    public double getCostoUnitario() {
        return costoUnitario;
    }

    /**
     * Imposta il costo della sostanza per unitò
     *
     * @param costoUnitario costo della sostanza per unità
     */
    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    /**
     * Setta ID della sostanza
     * @param ID id sostanza
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Ritorna l'id della sostanza
     * @return id sostanza
     */
    public Integer getID() {
        return ID;
    }
}
