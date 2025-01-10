package PackageRicercatore;

import PackageUtils.AppFrame;

import java.util.ArrayList;

public class PrelievoSostanzaControl implements RicercatoreInterface {

    private AppFrame frame;
    private Ricercatore ricercatore;

    public PrelievoSostanzaControl(AppFrame frame, Ricercatore ricercatore) {
        this.frame = frame;
        this.ricercatore = ricercatore;
    }

    /**
     * Implementazione della funzionalità di prelievo di una sostanza
     */
    @Override
    public void prelevaSostanza() {

        // acquisire lista di team e porgetti
        // ArrayList<Team> teams = Team.getTeams();
        // ArrayList<Progetto> progetti = Progetto.getProgetti();

        // creazione dell'interfaccia grafica dell'utente

        /*

        1. Inserimento di Team e Progetto
        2. Scelta del lotto
        3. Piccolo riepilogo + inserimento quantità da prelevare
        4. Riepilogo finale
        5. Stampa del popup

         */
        stampaFormTeamEProgetto();


    }

    /**
     * Avvia la stampa del form per la selezione del Team e del Progetto scelti.
     */
    public void stampaFormTeamEProgetto () {
        ArrayList<Team> teams = ricercatore.getTeams();
        //ArrayList<Progetto> progetti = ricercatore.getProgetti();


    }

    public void sceltaLottoDaPrelevare (Team team, Progetto progetto) {

    }

    public void sceltaQuantitaDaPrelevare () {

    }

    public void mostraRiepilogoOrdine () {

    }
}
