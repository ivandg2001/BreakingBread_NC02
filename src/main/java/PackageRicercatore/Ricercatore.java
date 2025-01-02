package PackageRicercatore;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe POJO che rappresenta un ricercatore nel sistema, mappato da un adapter JPA.
 */
public class Ricercatore {

    /**
     * ID del ricercatore
     */
    private int ID;

    /**
     * Nome del ricecatore
     */
    private String nome;
    /**
     * Username del ricercatore
     */
    private String username;
    /**
     * Password del ricercatore
     */
    private String password;

    /**
     * Team a cui appartiene il ricercatore
     */
    private Team team;

    /**
     * Lista dei rpelievi effettuati dal ricercatore
     */
    private ArrayList<Prelievo> prelievi;

    /**
     * Costruttore predefinito
     */
    public Ricercatore(){
        this.prelievi = new ArrayList<>();
    }

    /***
     * Costruttore parametrico che inizializza i campi
     * @param nome nome del ricercatore
     * @param username username del ricercatore
     * @param password password del ricercatore
     */
    public Ricercatore(String nome , String username , String password){
        this.nome = nome;
        this.password = password;
        this.username = username;

    }

    /**
     * Ritorna l'ID del ricecatore
     * @return id ricercatore
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Ritorna il nome del ricercatore
     * @return nome ricercatore
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Ritorna la password del ricercatore
     * @return passwod ricercatore
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Ritorna lo username del ricercatore
     * @return username ricercatore
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Setta il nome del ricercatore
     * @param nome nome ricercatore
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Setta la password del ricercatore
     * @param password password ricercatore
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Setta lo username del ricercatore
     * @param username username ricercatore
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * setta ID del ricercatore
     * @param ID id del ricercatore
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Setta la lista dei prelievi effettuati dal ricercatore
     * @param prelievi lista prelievi
     */
    public void setPrelievi(ArrayList<Prelievo> prelievi) {
        this.prelievi = prelievi;
    }

    /**
     * Ritorna la lista dei prelievi effettuati dal ricercatore
     * @return lista preleivi
     */
    public ArrayList<Prelievo> getPrelievi() {
        return this.prelievi;
    }

    /**
     * Setta il team associato al ricercatore
     * @param team team ricercatore
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     * Ritorna il team associato al ricercatore
     * @return team ricercatore
     */
    public Team getTeam() {
        return this.team;
    }
}
