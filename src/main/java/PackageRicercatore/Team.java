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
     * Costruttore predefinito
     */
    public Team(){}

    /**
     * Costruttore parametrico che inizializza i campi
     * @param nomeTeam nome del team
     */
    public Team(String nomeTeam){
        this.nomeTeam = nomeTeam;
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
     * Setta il nome del Team
     * @param nomeTeam nome Team
     */
    public void setNomeTeam(String nomeTeam) {
        this.nomeTeam = nomeTeam;
    }

    /**
     * Setta l'id del Team
     * @param ID id Team
     */
    public void setID(int ID) {
        this.ID = ID;
    }
}
