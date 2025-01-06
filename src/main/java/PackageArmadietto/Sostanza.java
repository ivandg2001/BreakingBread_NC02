package PackageArmadietto;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe POJO che rappresenta una sostanza nel sistema, mappato da un adapter JPA.
 */
public class Sostanza {

    /**
     * Variabile statica che mantiene a livello di classe un interfaccia al DAO della sostanza
     */
    public static final SostanzaDataInterface sostanzaDataInterface = new SostanzaDAO();
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
     * Lista dei lotti che contengono la sostanza
     */
    private ArrayList<Lotto> lotti;

    /**
     * Costruttore vuoto
     */
    public Sostanza() {}

    /**
     * Costruttore parametrico che inizializza i campi
     * @param nome nome sostanza
     * @param formula formula della sostanza
     * @param costoUnitario costo unitario della sostanza
     */
    public Sostanza(String nome, String formula, double costoUnitario) {
        this.nome = nome;
        this.formula = formula;
        this.costoUnitario = costoUnitario;
    }

    /**
     * Setta la lista dei lotti che contengono la sostanza
     * @param lotti lista lotti
     */
    public void setLotti(ArrayList<Lotto> lotti) {
        this.lotti = lotti;
    }

    /**
     * Ritorna la lista dei lotti che contengono la sostanza
     * @return lista lotti
     */
    public ArrayList<Lotto> getLotti() {
        return this.lotti;
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
    public int getID() {
        return ID;
    }

    /**
     * Metodo che gestisce la persistenza per l'oggetto Sostanza, inserisce la sostanza nel database
     */
    public void storeSostanza(){
        if(!sostanzaDataInterface.addSostanza(this)){
            throw new IllegalArgumentException("Sostanza gia' presente");
        }

    }

    /**
     * Metodo che gestisce la persistenza per l'oggetto Sostanza, carica un oggetto sostanza dal database
     * @param id id della sostanza
     * @return Sostanza
     */
    public static Sostanza loadSostanzaByID(int id){
        return sostanzaDataInterface.getSostanzaByID(id);
    }

    public static Sostanza loadSostanzaByNome(String nome){
        return sostanzaDataInterface.getSostanzaByNome(nome);
    }
    /**
     * Metodo che gestisce la persistenza per l'oggetto Sostanza, aggiorna un oggetto sostanza nel database
     */
    public void updateSostanza(){

        if(!sostanzaDataInterface.updateSostanza(this)){
            throw new IllegalArgumentException("Update della sostanza fallito");
        }

    }

    public double getCosto(double quantita , double purezza){
        double proporzione = purezza / 100;
        double costo = this.costoUnitario * quantita;
        return proporzione * costo;
    }
}
