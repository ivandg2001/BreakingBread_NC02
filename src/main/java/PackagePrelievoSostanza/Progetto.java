package PackagePrelievoSostanza;


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
    private ArrayList<Team> teams;

    /**
     * Costruttore predefinito.
     */
    public Progetto () {}

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
     * @param teams team progetto
     */
    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    /**
     * Ritorna il Team associato al progetto
     * @return team progetto
     */
    public ArrayList<Team> getTeams() {
        return teams;
    }

    /**
     * Aggiorna la corrente istanza di Progetto con le informazioni contenute nel database.
     */
    public void load () {
        ProgettoDataInterface progettoDI = new ProgettoDAO();
        Progetto progettoTemp = progettoDI.getProgetto(ID);
        this.setID(progettoTemp.getID());
        this.setNomeProgetto(progettoTemp.getNomeProgetto());

        TeamDataInterface teamDI = new TeamDAO();
        this.setTeams(teamDI.getAllTeamsByProgetto(this));
    }

    /**
     * Aggiorna il database con le attuali informazioni contenute nell'oggetto.
     */
    public void update () {
        //NON IMPLEMENTATO IN QUESTA VERSIONE DEL SISTEMA
    }
}