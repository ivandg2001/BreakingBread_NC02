package PackagePrelievoSostanza;

import PackageUtils.AppFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class TeamProjectForm {

    /**
     * Oggetto AppFrame che contiene la GUI
     */
    private AppFrame frame;

    /**
     * Istanza dell'oggetto control che ha chiamato la procedura.
     */
    private PrelievoSostanzaControl control;

    private JComboBox<String> comboTeam;
    private JComboBox<String> comboProgetto;

    public TeamProjectForm(AppFrame frame, PrelievoSostanzaControl control) {
        this.frame = frame;
        this.control = control;
    }

    public void display(ArrayList<Team> teams) {
        // Imposta intestazione della pagina
        JLabel titoloPagina = new JLabel("Inserisci Team e Progetto");

        // Imposta pannello principale
        JPanel pannelloPrincipale = new JPanel();
        pannelloPrincipale.setLayout(new GridLayout(2, 2));

        // Selezione Team
        JLabel selezioneTeam = new JLabel("Categoria:");
        String[] nomiTeams = new String[teams.size()];
        for (int i = 0; i < teams.size(); i++) {
            nomiTeams[i] = teams.get(i).getNomeTeam();
        }
        comboTeam = new JComboBox<>(nomiTeams);
        pannelloPrincipale.add(selezioneTeam);
        pannelloPrincipale.add(comboTeam);

        // Selezione Progetto
        JLabel selezioneProgetto = new JLabel("Elemento:");
        comboProgetto = new JComboBox<>();
        comboProgetto.setEnabled(true);//oppure setEditable?
        pannelloPrincipale.add(selezioneProgetto);
        pannelloPrincipale.add(comboProgetto);

        // Mappa per aggiornare dinamicamente i progetti presenti nella selezione
        HashMap<String, String[]> opzioni = new HashMap<>();
        for (Team team : teams) {
            ArrayList<Progetto> progetti = team.getProgetti();
            String[] nomiProgetti = new String[progetti.size()];
            for (int i = 0; i < progetti.size(); i++) {
                nomiProgetti[i] = progetti.get(i).getNomeProgetto();
            }
            opzioni.put(team.getNomeTeam(), nomiProgetti);
        }

        // Listener per il primo JComboBox
        comboTeam.addActionListener(e -> {
            String selezione = (String) comboTeam.getSelectedItem();

            if (selezione != null) {
                // Abilita il secondo JComboBox
                comboProgetto.setEnabled(true);

                // Aggiorna il contenuto del secondo JComboBox
                comboProgetto.removeAllItems();
                for (String item : opzioni.get(selezione)) {
                    comboProgetto.addItem(item);
                }
            } else {
                // Se non è selezionato nulla, disabilita e svuota
                comboProgetto.setEnabled(false);
                comboProgetto.removeAllItems();
            }
        });

        // Imposta pannello basso
        JPanel pannelloPulsanti = new JPanel();
        pannelloPulsanti.setLayout(new GridLayout(1, 2));

        // Pulsanti
        JButton annullaButton = new JButton("Annulla");
        JButton confermaButton = new JButton("Conferma");
        pannelloPulsanti.add(annullaButton);
        pannelloPulsanti.add(confermaButton);

        // Listener per il pulsante annulla
        annullaButton.addActionListener(e -> {
           control.abortActivity();
        });

        // Listener per il pulsante conferma
        confermaButton.addActionListener(e -> {
            String teamSelezionato = (String) comboTeam.getSelectedItem();
            String progettoSelezionato = (String) comboProgetto.getSelectedItem();
            control.setSceltaTeamProgetto(teamSelezionato, progettoSelezionato);
        });

        // Aggiunta componenti alla finestra
        frame.resetAppFrame();
        frame.updateNorth(titoloPagina);
        frame.updateCenter(pannelloPrincipale);
        frame.updateSouth(pannelloPulsanti);
        frame.loadUpdates();
    }
}
