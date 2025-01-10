package PackagePrelievoSostanza;

import PackageUtils.AppFrame;
import PackageUtils.Homepage;
import PackageUtils.RicercatoreHomepage;

import java.util.ArrayList;

public class PrelievoSostanzaControl implements PrelievoSostanzaInterface {

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

        /*

        1. Inserimento di Team e Progetto --
        2. Scelta del lotto
        3. Piccolo riepilogo + inserimento quantità da prelevare
        4. Riepilogo finale
        5. Stampa del popup

         */
        ricercatore.load();
        ArrayList<Team> teams = ricercatore.getTeams();
        for (Team team : teams) {
            team.load();
            for (Progetto progetto : team.getProgetti()) {
                progetto.load();
            }
        }

        stampaFormTeamEProgetto();
    }

    /**
     * Avvia la stampa del form per la selezione del Team e del Progetto scelti.
     */
    private void stampaFormTeamEProgetto () {
        TeamProjectForm teamProjectForm = new TeamProjectForm(frame, this);
        teamProjectForm.display(ricercatore.getTeams());
    }

    public void setSceltaTeamProgetto (String nomeTeamSelezionato, String nomeProgettoSelezionato) {
        Team teamSelezionato = new Team();
        Progetto progettoSelezionato = new Progetto();

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
            stampaListaLotti(teamSelezionato, progettoSelezionato);
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
    private boolean TeamProgettoIsValid (String nomeTeamSelezionato, String nomeProgettoSelezionato) {
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

    private stampaListaLotti() {

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
