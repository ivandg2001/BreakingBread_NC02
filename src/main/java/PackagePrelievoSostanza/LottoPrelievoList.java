package PackagePrelievoSostanza;

import PackageUtils.AppFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class LottoPrelievoList {
    /**
     * Oggetto AppFrame che contiene la GUI
     */
    private AppFrame frame;

    /**
     * Istanza dell'oggetto control che ha chiamato la procedura.
     */
    private PrelievoSostanzaControl control;

    private Double quantita;

    public LottoPrelievoList(AppFrame frame, PrelievoSostanzaControl control) {
        this.frame = frame;
        this.control = control;
    }

    public void display(ArrayList<String[]> listaLottiFormattati) {
        // Imposta intestazione della pagina
        JLabel titoloPagina = new JLabel("Lista Lotti Prelevabili");

        // Imposta pannello principale
        JPanel pannelloPrincipale = new JPanel();
        pannelloPrincipale.setLayout(new GridLayout(listaLottiFormattati.size(),  5));

        // Ciclo che crea iterativamente la lista dei lotti da stampare a schermo
        for (String[] lottoFormattato : listaLottiFormattati) {
            // Inserimento dei campi informativi
            JLabel lottoIdLabel = new JLabel("Id: " + lottoFormattato[0]);
            pannelloPrincipale.add(lottoIdLabel);
            JLabel sostanzaLabel = new JLabel("Sostanza: " + lottoFormattato[1]);
            pannelloPrincipale.add(sostanzaLabel);
            JLabel formulaLabel = new JLabel("Formula: " + lottoFormattato[2]);
            pannelloPrincipale.add(formulaLabel);
            JLabel purezzaLabel = new JLabel("Purezza: " + lottoFormattato[3]);
            pannelloPrincipale.add(purezzaLabel);

            // Inserimento del pulsante per il prelievo
            JButton prelevaButton = new JButton("Preleva");
            pannelloPrincipale.add(prelevaButton);

            // Listener per il pulsante preleva
            prelevaButton.addActionListener(e -> {
                control.setIdLottoSelezionato(Integer.parseInt(lottoFormattato[0]));
            });

            // Imposta
        }

        // Pulsante di annullamento
        JButton annullaButton = new JButton("Annulla");

        // Listener per il pulsante annulla
        annullaButton.addActionListener(e -> {
            control.stampaFormTeamEProgetto();
        });


        // Aggiunta componenti alla finestra
        frame.resetAppFrame();
        frame.updateNorth(titoloPagina);
        frame.updateCenter(pannelloPrincipale);
        frame.updateSouth(annullaButton);
        frame.loadUpdates();
    }
}
