package PackagePrelievoSostanza;

import PackageUtils.AppFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class TeamProjectForm {

    /**
     * Oggetto AppFrame che contien la GUI
     */
    private AppFrame frame;

    /**
     * Istanza dell'oggetto control che ha chiamato la procedura.
     */
    private PrelievoSostanzaControl control;

    public TeamProjectForm(AppFrame frame, PrelievoSostanzaControl control) {
        this.frame = frame;
        this.control = control;
    }

    public void display(ArrayList<Team> teams) {
        // Imposta intestazione della pagina
        JLabel titoloPagina = new JLabel("Inserisci Team e Progetto");

        // Imposta pannello principale
        JPanel pannelloPrincipale = new JPanel();
        pannelloPrincipale.setLayout(new GridLayout(5, 2));

        // Selezione Team
        JLabel selezioneTeam = new JLabel("Categoria:");
        String[] nomiTeams = new String[teams.size()];
        for (int i = 0; i < teams.size(); i++) {
            nomiTeams[i] = teams.get(i).getNomeTeam();
        }
        JComboBox<String> comboTeams = new JComboBox<>(nomiTeams);

        // Selezione Progetto
        JLabel selezioneProgetto = new JLabel("Elemento:");
        JComboBox<String> comboProgetto = new JComboBox<>();
        comboProgetto.setEnabled(true);//oppure setEditable?

        // Mappa per aggiornare dinamicamente i progetti presenti nella selezione
        HashMap<String, String[]> opzioni = new HashMap<>();
        for (Team team : teams) {
            ArrayList<Progetto> progetti = team.getProgetti();
            String[] nomiProgetti = new String[progetti.size()];
            for (int i = 0; i < progetti.size(); i++) {
                nomiProgetti[i] = progetti.get(i).getNomeProgetto();
            }

            for (Progetto progetto : team.getProgetti()) {

            }
        }


    }

    // Primo JComboBox (categoria)


    // Secondo JComboBox (elementi)
    JLabel selezioneProgetto = new JLabel("Elemento:");
    JComboBox<String> comboElemento = new JComboBox<>();
    comboElemento.setBounds(120, 60, 150, 25);
    comboElemento.setEnabled(false);  // Disabilitato all'inizio

    // Mappa per aggiornare dinamicamente i dati
    Map<String, String[]> opzioni = new HashMap<>();
        opzioni.put("Frutta", new String[]{"Mela", "Banana", "Arancia"});
        opzioni.put("Verdura", new String[]{"Carota", "Zucchina", "Lattuga"});

    // Listener per il primo JComboBox
        comboCategoria.addActionListener(e -> {
        String selezione = (String) comboCategoria.getSelectedItem();

        if (selezione != null && !selezione.equals("Seleziona")) {
            // Abilita il secondo JComboBox
            comboElemento.setEnabled(true);

            // Aggiorna il contenuto del secondo JComboBox
            comboElemento.removeAllItems();
            for (String item : opzioni.get(selezione)) {
                comboElemento.addItem(item);
            }
        } else {
            // Se non è selezionato nulla, disabilita e svuota
            comboElemento.setEnabled(false);
            comboElemento.removeAllItems();
        }
    });
}
