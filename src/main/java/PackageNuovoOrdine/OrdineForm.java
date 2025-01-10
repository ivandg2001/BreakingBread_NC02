package PackageNuovoOrdine;

import PackageUtils.AppFrame;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe che implementa il form per inserire le informazioni di un nuovo ordine
 */
public class OrdineForm {

    /**
     * Oggetto AppFrame che contien la GUI
     */
    private AppFrame frame;

    /**
     * Istanza dell'oggetto control che ha chiamato la procedura.
     */
    private NuovoOrdineControl control;


    /**
     * Costruttore parametrico che inizializza gli attributi
     * @param frame oggetto AppFrame
     * @param control oggetto NuovoOrdineControl
     */
    public OrdineForm (AppFrame frame, NuovoOrdineControl control) {
        this.frame = frame;
        this.control = control;
    }

    /**
     * Metodo che permette al form di essere visualizzato, crea la finestra form vera e propria.
     * @param sostanze lista dei nomi delle sostanze presenti nel database da poter essere selezionate
     */
    public void display(String[] sostanze) {

        // Imposta intestazione della pagina
        JLabel titoloPagina = new JLabel("Inserisci informazioni ordine");

        // Imposta pannello principale
        JPanel pannelloPrincipale = new JPanel();
        pannelloPrincipale.setLayout(new GridLayout(5, 2));

        // Selezione nome sostanza
        JLabel nomeSostanzaLabel = new JLabel("Nome sostanza: ");
        JComboBox<String> nomeSostanzaComboBox = new JComboBox<>(sostanze);
        pannelloPrincipale.add(nomeSostanzaLabel);
        pannelloPrincipale.add(nomeSostanzaComboBox);

        // Purezza
        JLabel purezzaLabel = new JLabel("Purezza (Tra 1 e 100):");
        JTextField purezzaField = new JTextField();
        setNumericInput(purezzaField); // Valida input numerico
        pannelloPrincipale.add(purezzaLabel);
        pannelloPrincipale.add(purezzaField);

        // Quantità
        JLabel quantitaLabel = new JLabel("Quantità (tra 1 e 100000):");
        JTextField quantitaField = new JTextField();
        setNumericInput(quantitaField); // Valida input numerico
        pannelloPrincipale.add(quantitaLabel);
        pannelloPrincipale.add(quantitaField);

        // Priorità ordine
        JLabel prioritaLabel = new JLabel("Priorità ordine:");
        JPanel prioritaPanel = new JPanel();
        JRadioButton altaPrioritaRadioButton = new JRadioButton("Alta");
        JRadioButton mediaPrioritaRadioButton = new JRadioButton("Media");
        JRadioButton bassaPrioritaRadioButton = new JRadioButton("Bassa");
        ButtonGroup prioritaGroup = new ButtonGroup();
        prioritaGroup.add(altaPrioritaRadioButton);
        prioritaGroup.add(mediaPrioritaRadioButton);
        prioritaGroup.add(bassaPrioritaRadioButton);
        prioritaPanel.add(altaPrioritaRadioButton);
        prioritaPanel.add(mediaPrioritaRadioButton);
        prioritaPanel.add(bassaPrioritaRadioButton);
        pannelloPrincipale.add(prioritaLabel);
        pannelloPrincipale.add(prioritaPanel);

        // Pulsanti
        JButton confermaButton = new JButton("Conferma");
        JButton annullaButton = new JButton("Annulla");
        JPanel pannelloPulsanti = new JPanel();
        pannelloPulsanti.add(confermaButton);
        pannelloPulsanti.add(annullaButton);

        // Gestione eventi
        confermaButton.addActionListener(new ActionListenerNuovoOrdine(this.control, nomeSostanzaComboBox, purezzaField, quantitaField, altaPrioritaRadioButton, mediaPrioritaRadioButton, bassaPrioritaRadioButton));

        annullaButton.addActionListener(new ActionListenerAnnulla(this.control));

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

    /**
     * Action listener che gestisce il pulsante per la conferma del form.
     */
    private class ActionListenerNuovoOrdine implements ActionListener {

        /**
         * Control che ha chiamato la procedura.
         */
        private NuovoOrdineControl control;
        /**
         * Nome della sostanza.
         */
        private JComboBox<String> nomeSostanzaComboBox;
        /**
         * Field per la purezza.
         */
        private JTextField purezzaField;
        /**
         * Field per la quantita.
         */
        private JTextField quantitaField;
        /**
         * Radio button priorita alta
         */
        private JRadioButton altaPrioritaRadioButton;
        /**
         * Radio button priorita media
         */
        private JRadioButton mediaPrioritaRadioButton;
        /**
         * Radio button priorita bassa
         */
        private JRadioButton bassaPrioritaRadioButton;

        /**
         * Costruttore parametrico che inizializza gli attributi
         * @param control oggetto NuovoOrdineControl
         * @param nomeSostanzaComboBox combobox coni nomi delle sostanze
         * @param purezzaField textfield per la purezza
         * @param quantitaField textfield per la quantita
         * @param altaPrioritaRadioButton radiobutton priorita alta
         * @param mediaPrioritaRadioButton radiobutton priorita alta
         * @param bassaPrioritaRadioButton radiobutton priorita alta
         */
        public ActionListenerNuovoOrdine(NuovoOrdineControl control, JComboBox<String> nomeSostanzaComboBox, JTextField purezzaField, JTextField quantitaField,
                                         JRadioButton altaPrioritaRadioButton, JRadioButton mediaPrioritaRadioButton, JRadioButton bassaPrioritaRadioButton) {
            this.control = control;
            this.nomeSostanzaComboBox = nomeSostanzaComboBox;
            this.purezzaField = purezzaField;
            this.quantitaField = quantitaField;
            this.altaPrioritaRadioButton = altaPrioritaRadioButton;
            this.mediaPrioritaRadioButton = mediaPrioritaRadioButton;
            this.bassaPrioritaRadioButton = bassaPrioritaRadioButton;
        }

        /**
         * Metodo action performed che gestisce il click sul pulsante di conferma, inizia la procedura di verifica dell'input
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            // Prendi i valori al momento di confermare
            String nomeSostanza = (String) nomeSostanzaComboBox.getSelectedItem();
            String purezzaText = purezzaField.getText();
            String quantitaText = quantitaField.getText();

            // Verifica se i campi sono vuoti o non validi
            if (purezzaText.isEmpty() || quantitaText.isEmpty()) {
                this.control.creaPopup("I campi 'Purezza' e 'Quantità' non possono essere vuoti.");
                return; // Non proseguire se i campi sono vuoti
            } else if (!altaPrioritaRadioButton.isSelected() && !mediaPrioritaRadioButton.isSelected() && !bassaPrioritaRadioButton.isSelected()) {
                this.control.creaPopup("Devi selezionare almeno una priorità");
                return;
            }


            try {
                double purezza = Double.parseDouble(purezzaText);
                double quantita = Double.parseDouble(quantitaText);
                Integer priorita = null;

                if (altaPrioritaRadioButton.isSelected()) priorita = 3;
                else if (mediaPrioritaRadioButton.isSelected()) priorita = 2;
                else if (bassaPrioritaRadioButton.isSelected()) priorita = 1;

                // Passa i dati al controller
                this.control.setInfoNuovoOrdine(nomeSostanza, purezza, quantita, priorita);
            } catch (NumberFormatException ex) {
                this.control.creaPopup("Inserisci valori numerici validi per Purezza e Quantità.");
            }
        }
    }


    /**
     * Action listener per il pulsante di annullamento
     */
    private class ActionListenerAnnulla implements ActionListener {
        /**
         * Oggetto NuovoOrdineControl
         */
        private NuovoOrdineControl control;

        /**
         * Metodo parametrico che inizializza gli attributi
         * @param control oggetto NuovoOrdineControl
         */
        public ActionListenerAnnulla(NuovoOrdineControl control ){
            this.control = control;
        }

        /**
         * Metodo che gestisce l'evento click sul pulsante di annullamento, riporta alla home
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            this.control.annullaOrdine();
        }
    }
}
