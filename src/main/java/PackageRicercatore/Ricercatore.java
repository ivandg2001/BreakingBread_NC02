package PackageRicercatore;

import jakarta.persistence.*;

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
     * Lista dei prelievi effettuati dal ricercatore
     */
    private ArrayList<Prelievo> prelievi;

    /**
     * Team a cui appartiene il ricercatore
     */
    private Team team;

    /**
     * Costruttore predefinito
     */
    public Ricercatore(){}

    /***
     * Costruttore parametrico che inizializza i campi
     * @param nome nome del ricercatore
     * @param username username del ricercatore
     * @param password password del ricercatore
     * @param prelievi preliev effettuati dal ricercatore
     * @param team team a cui appartiene il ricercatore
     */
    public Ricercatore(String nome , String username , String password , ArrayList<Prelievo> prelievi , Team team){
        this.nome = nome;
        this.password = password;
        this.username = username;
        this.team = team;
        this.prelievi = prelievi;
    }

    /**
     * Ritorna l'ID del ricecatore
     * @return id ricercatore
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Ritorna la lista dei prelievi effettuati dal ricercatore
     * @return lista dei prelievi
     */
    public List<Prelievo> getPrelievi() {
        return this.prelievi;
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
     * Ritorna il team a cui appatiene il ricercatore
     * @return team ricercatore
     */
    public Team getTeam() {
        return this.team;
    }

    /**
     * Setta i prelievi effettuati dal ricecatore
     * @param prelievi relievi del ricercatore
     */
    public void setPrelievi(ArrayList<Prelievo> prelievi) {
        this.prelievi = prelievi;
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
     * Setta il team a cui fa parte il ricercatore
     * @param team Oggetto team
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     * Setta lo username del ricercatore
     * @param username username ricercatore
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
