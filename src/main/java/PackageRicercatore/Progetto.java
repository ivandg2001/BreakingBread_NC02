package PackageRicercatore;


/**
 * Classe POJO che rappresenta un progetto nel sistema, mappato da un adapter JPA.
 */
public class Progetto {


    /**
     * Id del progetto
     */

    private int ID;

    /**
     * Nome del progetto
     */
    private String nomeProgetto;

    /**
     * Team a cui è stato assegnato il progetto.
     */
    private Team team;

    /**
     * Costruttore predefinito.
     */
    public Progetto(){}

    /**
     * Costruttore parametrico che inizializza i campi.
     * @param nomeProgetto nome del progetto
     * @param team team a cui è assegnato il progetto
     */
    public Progetto(String nomeProgetto , Team team){
        this.nomeProgetto = nomeProgetto;
        this.team = team;
    }

    /**
     * Ritorna l'ID del progetto
     * @return id progetto
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Ritorna il team a cui è assegnato il progetto
     * @return team progetto
     */
    public Team getTeam() {
        return this.team;
    }

    /**
     * Ritorna il nome del progetto
     * @return nome progetto
     */
    public String getNomeProgetto() {
        return this.nomeProgetto;
    }

    /**
     * Setta il team a cui è assegnato il progetto
     * @param team team progetto
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     * Setta il nome del progetto
     * @param nomeProgetto nome progetto
     */
    public void setNomeProgetto(String nomeProgetto) {
        this.nomeProgetto = nomeProgetto;
    }
}