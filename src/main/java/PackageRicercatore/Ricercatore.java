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
    private int teamID;

    /**
     * Costruttore predefinito
     */
    public Ricercatore(){}

    /***
     * Costruttore parametrico che inizializza i campi
     * @param nome nome del ricercatore
     * @param username username del ricercatore
     * @param password password del ricercatore
     * @param teamID id del team a cui appartiene il ricercatore
     */
    public Ricercatore(String nome , String username , String password , int teamID){
        this.nome = nome;
        this.password = password;
        this.username = username;
        this.teamID = teamID;

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
     * Setta ID del team a cui e' associato il responsabile
     * @param teamID id del team
     */
    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    /**
     * Ritorna l'ID del team a cui e' associato il responsabile
     * @return id del team
     */
    public int getTeamID() {
        return teamID;
    }
}
