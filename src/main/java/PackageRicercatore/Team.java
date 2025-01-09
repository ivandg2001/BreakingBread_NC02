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
     * Lista dei ricercatori associati al Team
     */
    private ArrayList<Ricercatore> ricercatori;

    /**
     * Lista dei progetti associati al team
     */
    private ArrayList<Progetto> progetti;

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

    /**
     * Setta i progetti associati al Team
     * @param progetti lista progetti
     */
    public void setProgetti(ArrayList<Progetto> progetti) {
        this.progetti = progetti;
    }

    /**
     * Ritorna la lista dei progetti associati al Team
     * @return lista progetti
     */
    public ArrayList<Progetto> getProgetti() {
        return this.progetti;
    }

    /**
     * Setta la lista dei ricercatori associati al Team
     * @param ricercatori lista ricercatori
     */
    public void setRicercatori(ArrayList<Ricercatore> ricercatori) {
        this.ricercatori = ricercatori;
    }

    /**
     * Ritorna la lista dei ricercatori associati al Team
     * @return lista ricercatori
     */
    public ArrayList<Ricercatore> getRicercatori() {
        return this.ricercatori;
    }

    /**
     * Ritorna la lista di team associati al ricercatore.
     * @return teams del ricercatore.
     */
    public ArrayList<Team> getTeams() {
        return this.teams;
    }

    /**
     * Restituisce un oggetto Team totalmente inizializzato con le informazioni contenute nel database.
     *
     */
    public void load () {
        RicercatoreDataInterface ricercatoreDI = new RicercatoreDAO();
        Ricercatore ricercatore = ricercatoreDI.getRicercatore(ID);

        TeamDataInterface teamDI = new TeamDAO();
        ricercatore.setTeams(teamDI.getAllTeamsByRicercatore(ricercatore));

        PrelievoDataInterface prelievoDI = new PrelievoDAO();
        ricercatore.setPrelievi(prelievoDI.getAllPrelieviByRicercatore(ricercatore));

        return ricercatore;
    }

    public void update () {
        //TODO
    }
}
