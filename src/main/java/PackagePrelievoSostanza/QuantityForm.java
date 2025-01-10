package PackagePrelievoSostanza;

import PackageUtils.AppFrame;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;

public class QuantityForm {
    /**
     * Oggetto AppFrame che contiene la GUI
     */
    private AppFrame frame;
    /**
     * Istanza dell'oggetto control che ha chiamato la procedura.
     */
    private PrelievoSostanzaControl control;

    private JTextField fieldQuantita;

    public QuantityForm(AppFrame frame, PrelievoSostanzaControl control) {
        this.frame = frame;
        this.control = control;
    }

    public void display(String[] infoLottoFormattate) {
        // Imposta intestazione della pagina
        JLabel titoloPagina = new JLabel("Scegli quantità da prelevare");

        // Imposta pannello principale
        JPanel pannelloPrincipale = new JPanel();
        pannelloPrincipale.setLayout(new GridLayout(2,  1));

        // Imposta pannello informazioni lotto
        JPanel pannelloInfoLotto = new JPanel();
        pannelloInfoLotto.setLayout(new GridLayout(6,  1)); // numero di riche da cambiare?

        JLabel labelNomeSostanza = new JLabel("Sostanza: " + infoLottoFormattate[0]);
        JLabel labelFormulaSostanza = new JLabel("Formula: " + infoLottoFormattate[1]);
        JLabel labelIDLotto = new JLabel("ID Lotto: " + infoLottoFormattate[2]);
        JLabel labelPurezza = new JLabel("Purezza lotto: " + infoLottoFormattate[3] + " %");
        JLabel labelDataScadenza = new JLabel("Data scadenza: " + infoLottoFormattate[4]);
        JLabel labelQuantitaAttuale = new JLabel("Quantità attuale: " + infoLottoFormattate[5] + " mg/ml");

        pannelloInfoLotto.add(labelNomeSostanza);
        pannelloInfoLotto.add(labelFormulaSostanza);
        pannelloInfoLotto.add(labelIDLotto);;
        pannelloInfoLotto.add(labelPurezza);
        pannelloInfoLotto.add(labelQuantitaAttuale);
        pannelloInfoLotto.add(labelDataScadenza);

        // Imposta pannello di scelta quantità
        JPanel pannelloSceltaQuantita = new JPanel();
        pannelloSceltaQuantita.setLayout(new GridLayout(1,  2)); // numero di riche da cambiare?
        JLabel labelQuantita = new JLabel("Quantita: ");
        fieldQuantita = new JTextField();
        setNumericInput(fieldQuantita); // validazione input numerico
        pannelloSceltaQuantita.add(labelQuantita);
        pannelloSceltaQuantita.add(fieldQuantita);

        pannelloPrincipale.add(pannelloInfoLotto);
        pannelloPrincipale.add(pannelloSceltaQuantita);

        // Pannello pulsanti
        JPanel pannelloPulsanti = new JPanel();
        JButton annullaButton = new JButton("Annulla");
        JButton confermaButton = new JButton("Conferma");
        pannelloPulsanti.add(annullaButton);
        pannelloPulsanti.add(confermaButton);

        // Listener per il pulsante annulla
        annullaButton.addActionListener(e -> {
            control.stampaListaLotti();
        });

        // Listener per il pulsante conferma
        confermaButton.addActionListener(e -> {
            String quantitaSelezionata = fieldQuantita.getText();
            control.setSceltaQuantita(quantitaSelezionata);
        });

        // Aggiunta componenti alla finestra
        frame.resetAppFrame();
        frame.updateNorth(titoloPagina);
        frame.updateCenter(pannelloPrincipale);
        frame.updateSouth(pannelloPulsanti);
        frame.loadUpdates();
    }

    /**
     * Imposta un filtro per accettare solo input numerici (inclusi i decimali).
     */
    private void setNumericInput(JTextField textField) {
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("[0-9]*\\.?[0-9]*")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("[0-9]*\\.?[0-9]*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }
}
