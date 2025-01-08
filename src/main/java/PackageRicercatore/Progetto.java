package PackageRicercatore;


import java.util.ArrayList;

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
    private ArrayList<Team> team;

    /**
     * Costruttore predefinito.
     */
    public Progetto(){}

    /**
     * Costruttore parametrico che inizializza i campi.
     * @param nomeProgetto nome del progetto
     * @param teamID team a cui è assegnato il progetto
     */
    public Progetto(String nomeProgetto){
        this.nomeProgetto = nomeProgetto;
    }

    /**
     * Ritorna l'ID del progetto
     * @return id progetto
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Ritorna il nome del progetto
     * @return nome progetto
     */
    public String getNomeProgetto() {
        return this.nomeProgetto;
    }


    /**
     * Setta il nome del progetto
     * @param nomeProgetto nome progetto
     */
    public void setNomeProgetto(String nomeProgetto) {
        this.nomeProgetto = nomeProgetto;
    }

    /**
     * Setta l'id del progetto
     * @param ID id progetto
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Setta il team associato al progetto
     * @param team team progetto
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     * Ritorna il Team associato al progetto
     * @return team progetto
     */
    public Team getTeam() {
        return team;
    }
}