package PackageRicercatore;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe POJO che rappresenta un Team nel sistema, mappato da un adapter JPA.
 */
public class Team {

    /**
     * ID del Team
     */
    private int ID;

    /**
     * Nome del Team
     */
    private String nomeTeam;

    /**
     * Lista dei ricercatori che fanno parte di questo team
     */
    private ArrayList<Ricercatore> ricercatori;

    /**
     * Lista dei progetti assegnati a questo team
     */
    private ArrayList<Progetto> progetti;

    /**
     * Costruttore predefinito
     */
    public Team(){}

    /**
     * Costruttore parametrico che inizializza i campi
     * @param nomeTeam nome del team
     * @param ricercatori lista di oggetti ricercatore
     * @param progetti lista di oggetti progetto
     */
    public Team(String nomeTeam , ArrayList<Ricercatore> ricercatori , ArrayList<Progetto> progetti){
        this.nomeTeam = nomeTeam;
        this.progetti = progetti;
        this.ricercatori = ricercatori;
    }

    /**
     * Ritorna l'id del team
     * @return id Team
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Ritorna il nome del Team
     * @return nome Team
     */
    public String getNomeTeam() {
        return this.nomeTeam;
    }

    /**
     * Ritorna la lista dei progetti assegnati al Team
     * @return lista progetti
     */
    public List<Progetto> getProgetti() {
        return this.progetti;
    }

    /**
     * Ritorna la lista dei ricercatori che appartengono al Team
     * @return lista ricercatori
     */
    public List<Ricercatore> getRicercatori() {
        return this.ricercatori;
    }

    /**
     * Setta il nome del Team
     * @param nomeTeam nome Team
     */
    public void setNomeTeam(String nomeTeam) {
        this.nomeTeam = nomeTeam;
    }

    /**
     * Setta la lista dei progetti ssegnati al Team
     * @param progetti lista progetti
     */
    public void setProgetti(ArrayList<Progetto> progetti) {
        this.progetti = progetti;
    }

    /**
     * Setta la lista dei ricercatori che appartengono al Team
     * @param ricercatori lista ricercatori
     */
    public void setRicercatori(ArrayList<Ricercatore> ricercatori) {
        this.ricercatori = ricercatori;
    }
}
