package PackagePrelievoSostanza;

import PackageArmadietto.ArmadiettoFacade;
import PackageArmadietto.ArmadiettoGetDataInterface;
import PackageArmadietto.Lotto;
import PackageUtils.AppFrame;
import PackageUtils.Homepage;
import PackageUtils.RicercatoreHomepage;

import java.util.ArrayList;
import java.util.HashMap;

public class PrelievoSostanzaControl implements PrelievoSostanzaInterface {

    private AppFrame frame;
    private Ricercatore ricercatore;

    private Team teamSelezionato;
    private Progetto progettoSelezionato;

    public PrelievoSostanzaControl(AppFrame frame, Ricercatore ricercatore) {
        this.frame = frame;
        this.ricercatore = ricercatore;
        this.teamSelezionato = new Team();
        this.progettoSelezionato = new Progetto();

        // Inizializza l'oggetto ricercatore con le informazioni contenute nel database
        this.ricercatore.load();
        ArrayList<Team> teams = this.ricercatore.getTeams();
        for (Team team : teams) {
            team.load();
            for (Progetto progetto : team.getProgetti()) {
                progetto.load();
            }
        }
    }

    /**
     * Implementazione della funzionalità di prelievo di una sostanza
     */
    @Override
    public void prelevaSostanza() {

        /*
        Passi compiuti da questa attività

        1. Inserimento di Team e Progetto -- DONE
        2. Scelta del lotto -- TODO
        3. Piccolo riepilogo + inserimento quantità da prelevare -- TODO
        4. Riepilogo finale -- TODO
        5. Stampa del popup -- TODO

         */

        stampaFormTeamEProgetto();
    }

    /**
     * Avvia la stampa del form per la selezione del Team e del Progetto scelti.
     */
    public void stampaFormTeamEProgetto () {
        TeamProjectForm teamProjectForm = new TeamProjectForm(frame, this);
        teamProjectForm.display(ricercatore.getTeams());
    }

    public void setSceltaTeamProgetto (String nomeTeamSelezionato, String nomeProgettoSelezionato) {

        if (TeamProgettoIsValid(nomeTeamSelezionato, nomeProgettoSelezionato)) {
            for (Team team : ricercatore.getTeams()) {
                if (team.getNomeTeam().equals(nomeTeamSelezionato)) {
                    for (Progetto progetto : team.getProgetti()) {
                        if (progetto.getNomeProgetto().equals(nomeProgettoSelezionato)) {
                            teamSelezionato = team;
                            progettoSelezionato = progetto;
                            break;
                        }
                    }
                    break;
                }
            }
            stampaListaLotti();
        } else {
            frame.showErrorDialog("Il team o il progetto selezionato non è valido!");
            stampaFormTeamEProgetto();
        }
    }

    /**
     * Verifica che il team e il progetto selezionati dall'utente siano validi, e quindi presenti nel database.
     *
     * @param nomeTeamSelezionato nome del team selezionato dall'utente.
     * @param nomeProgettoSelezionato nome del progetto selezionato dall'utente.
     * @return false se l'input dell'utente è valido, false altrimenti.
     */
    public boolean TeamProgettoIsValid (String nomeTeamSelezionato, String nomeProgettoSelezionato) {
        if (nomeTeamSelezionato == null || nomeProgettoSelezionato == null) {
            return false;
        }
        for (Team team : ricercatore.getTeams()) {
            for (Progetto progetto : team.getProgetti()) {
                if (nomeTeamSelezionato.equals(team.getNomeTeam()) && nomeProgettoSelezionato.equals(progetto.getNomeProgetto())) {
                    return true;
                }
            }
        }
        return false;
    }

    private void stampaListaLotti() {
        ArmadiettoGetDataInterface armadiettoGDI = new ArmadiettoFacade();
        ArrayList<HashMap<String, Object>> listaLottiFormattati = armadiettoGDI.getListaLottiFormattati();


    }



    public void sceltaLottoDaPrelevare (Team team, Progetto progetto) {

    }

    public void sceltaQuantitaDaPrelevare () {

    }

    public void mostraRiepilogoOrdine () {

    }




    /**
     * Annulla funzionalità di prelievo sostanza, e ritorna alla Homepage del Ricercatore
     */
    public void abortActivity() {
        RicercatoreHomepage ricercatoreHomepage = new RicercatoreHomepage(this.frame, this.ricercatore);
        ricercatoreHomepage.display();
    }
}
