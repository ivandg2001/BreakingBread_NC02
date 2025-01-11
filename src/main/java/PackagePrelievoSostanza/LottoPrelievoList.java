package PackagePrelievoSostanza;

import PackageUtils.AppFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Oggetto boundary che si occupa della stampa della lista dei lotti prelevabili.
 */
public class LottoPrelievoList {
    /**
     * Frame principale dell'applicazione.
     */
    private AppFrame frame;
    /**
     * Oggetto control che utilizza questo boundary.
     */
    private PrelievoSostanzaControl control;

    /**
     * Costruttore parametrico.
     *
     * @param frame Frame principale dell'applicazione.
     * @param control Oggetto control che utilizza questo boundary.
     */
    public LottoPrelievoList(AppFrame frame, PrelievoSostanzaControl control) {
        this.frame = frame;
        this.control = control;
    }

    /**
     * Avvia la procedura di stampa a schermo.
     *
     * @param listaLottiFormattati Un arraylist di array di stringhe contenenti informazioni riguardanti i lotti prelevabili.
     */
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
