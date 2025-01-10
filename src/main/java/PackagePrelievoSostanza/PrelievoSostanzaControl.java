package PackagePrelievoSostanza;

import PackageArmadietto.ArmadiettoFacade;
import PackageArmadietto.ArmadiettoGetDataInterface;
import PackageArmadietto.ArmadiettoSetDataInterface;
import PackageUtils.AppFrame;
import PackageUtils.RicercatoreHomepage;

import java.time.LocalDate;
import java.util.ArrayList;

public class PrelievoSostanzaControl implements PrelievoSostanzaInterface {

    private AppFrame frame;
    private Ricercatore ricercatore;

    private Team teamSelezionato;
    private Progetto progettoSelezionato;
    private int idLottoSelezionato;
    private double quantitaSelezionata;

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
        2. Scelta del lotto -- DONE
        3. Piccolo riepilogo + inserimento quantità da prelevare -- DONE
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
        // Validazione
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

        if (nomeTeamSelezionato.isEmpty() || nomeProgettoSelezionato.isEmpty()) {
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

    public void stampaListaLotti() {
        ArmadiettoGetDataInterface armadiettoGDI = new ArmadiettoFacade();
        ArrayList<String[]> listaLottiFormattati = armadiettoGDI.getListaLottiFormattati();

        LottoPrelievoList lottoPrelievoList = new LottoPrelievoList(frame, this);
        lottoPrelievoList.display(listaLottiFormattati);
    }

    public void setIdLottoSelezionato(int idLottoSelezionato) {
        this.idLottoSelezionato = idLottoSelezionato;
        stampaSceltaQuantita();
    }

    public void stampaSceltaQuantita() {
        ArmadiettoGetDataInterface armadiettoGDI = new ArmadiettoFacade();
        String[] infoLottoFormattate = armadiettoGDI.getInfoLottoFormattate(idLottoSelezionato);

        QuantityForm quantityForm = new QuantityForm(frame, this);
        quantityForm.display(infoLottoFormattate);
    }

    public void setSceltaQuantita(String quantitaSelezionata) {
        // validazione
        if (quantitaIsValid(quantitaSelezionata)) {
            this.quantitaSelezionata = Double.parseDouble(quantitaSelezionata);
            stampaRiepilogoPrelievo();
        } else {
            frame.showErrorDialog("Quantità selezionata non valida!");
            stampaSceltaQuantita();
        }
    }

    public boolean quantitaIsValid(String quantitaSelezionata) {
        if (quantitaSelezionata == null || quantitaSelezionata.isEmpty()) {
            return false;
        }

        double quantita;
        try {
            quantita = Double.parseDouble(quantitaSelezionata);
        } catch (NumberFormatException e) {
            return false;
        }

        ArmadiettoGetDataInterface armadiettoGDI = new ArmadiettoFacade();
        if (quantita <= 0 || quantita > armadiettoGDI.getQuantitaLotto(idLottoSelezionato)) {
            return false;
        }

        return true;
    }

    private void stampaRiepilogoPrelievo() {
        // Preparazione delle informazioni di riepilogo del Prelievo
        ArmadiettoGetDataInterface armadiettoGDI = new ArmadiettoFacade();
        String[] infoLottoFormattate = armadiettoGDI.getInfoLottoFormattate(idLottoSelezionato);
        String[] infoPrelievoFormattate = new String[6];

        infoPrelievoFormattate[0] = infoLottoFormattate[0];
        infoPrelievoFormattate[1] = infoLottoFormattate[2];
        infoPrelievoFormattate[2] = infoLottoFormattate[3];
        infoPrelievoFormattate[3] = infoLottoFormattate[5];
        infoPrelievoFormattate[4] = String.valueOf(quantitaSelezionata);
        infoPrelievoFormattate[5] = String.valueOf(Double.parseDouble(infoLottoFormattate[5]) - quantitaSelezionata);

        // Stampa della finestra di riepilogo
        RiepilogoPrelievoFinestra riepilogoPrelievoFinestra = new RiepilogoPrelievoFinestra(frame, this);
        riepilogoPrelievoFinestra.display(infoPrelievoFormattate);
    }

    public void finalizzaPrelievo() {
        // Aggiornamento del contenuto dell'armadietto
        ArmadiettoSetDataInterface armadiettoSDI = new ArmadiettoFacade();
        armadiettoSDI.eseguiPrelievo(idLottoSelezionato, quantitaSelezionata);

        // Inserimento del prelievo nel sistema
        ArmadiettoGetDataInterface armadiettoGDI = new ArmadiettoFacade();
        Prelievo prelievo = new Prelievo(LocalDate.now(), quantitaSelezionata, armadiettoGDI.getLottoByID(idLottoSelezionato), ricercatore);
        prelievo.store();

        // Stampa pop-up di conferma prelievo
        ConfermaPrelievoPopUp confermaPrelievoPopUp = new ConfermaPrelievoPopUp(frame, ricercatore);
        confermaPrelievoPopUp.display();

        // Ritorno a Homepage Ricercatore
        endActivity();
    }

    /**
     * Annulla funzionalità di prelievo sostanza e ritorna alla Homepage del Ricercatore
     */
    public void endActivity() {
        RicercatoreHomepage ricercatoreHomepage = new RicercatoreHomepage(this.frame, this.ricercatore);
        ricercatoreHomepage.display();
    }
}
