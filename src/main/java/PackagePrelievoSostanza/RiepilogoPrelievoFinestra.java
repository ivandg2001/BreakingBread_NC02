package PackagePrelievoSostanza;

import PackageUtils.AppFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Oggetto boundary che si occupa della stampa del riepilogo del prelievo.
 */
public class RiepilogoPrelievoFinestra {
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
    public RiepilogoPrelievoFinestra(AppFrame frame, PrelievoSostanzaControl control) {
        this.frame = frame;
        this.control = control;
    }

    /**
     * Avvia la procedura di stampa a schermo.
     *
     * @param infoPrelievoFormattate Array di stringhe contenenti informazioni riguardanti il prelievo che si intende fare.
     */
    public void display(String[] infoPrelievoFormattate) {

        // Imposta intestazione della pagina
        JLabel titoloPagina = new JLabel("Riepilogo Prelievo");

        // Imposta pannello principale
        JPanel pannelloPrincipale = new JPanel();
        pannelloPrincipale.setLayout(new GridLayout(6,  1));

        JLabel labelNomeSostanza = new JLabel("Sostanza: " + infoPrelievoFormattate[0]);
        JLabel labelIDLotto = new JLabel("ID Lotto: " + infoPrelievoFormattate[1]);
        JLabel labelPurezza = new JLabel("Purezza: " + infoPrelievoFormattate[2] + "%");
        JLabel labelQuantitaAttuale = new JLabel("Quantità attuale: " + infoPrelievoFormattate[3] + " mg/ml");
        JLabel labelQuantitaDaPrelevare = new JLabel("Quantità da prelevare: " + infoPrelievoFormattate[4] + " mg/ml");
        JLabel labelQuantitaRimanente = new JLabel("Quantità rimanente: " + infoPrelievoFormattate[5] + " mg/ml");

        pannelloPrincipale.add(titoloPagina);
        pannelloPrincipale.add(labelNomeSostanza);
        pannelloPrincipale.add(labelIDLotto);
        pannelloPrincipale.add(labelPurezza);
        pannelloPrincipale.add(labelQuantitaAttuale);
        pannelloPrincipale.add(labelQuantitaDaPrelevare);
        pannelloPrincipale.add(labelQuantitaRimanente);

        // Pannello pulsanti
        JPanel pannelloPulsanti = new JPanel();
        JButton annullaButton = new JButton("Annulla");
        JButton confermaButton = new JButton("Conferma Prelievo");
        pannelloPulsanti.add(annullaButton);
        pannelloPulsanti.add(confermaButton);

        // Listener per il pulsante annulla
        annullaButton.addActionListener(e -> {
            control.stampaSceltaQuantita();
        });

        // Listener per il pulsante conferma
        confermaButton.addActionListener(e -> {
            control.finalizzaPrelievo();
        });

        // Aggiunta componenti alla finestra
        frame.resetAppFrame();
        frame.updateNorth(titoloPagina);
        frame.updateCenter(pannelloPrincipale);
        frame.updateSouth(pannelloPulsanti);
        frame.loadUpdates();
    }
}
