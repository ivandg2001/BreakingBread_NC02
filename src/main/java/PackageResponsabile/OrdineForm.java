package PackageResponsabile;

import PackageGraphics.AppFrame;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrdineForm {

    private AppFrame frame;

    private Ordine ordine;


    public OrdineForm (AppFrame frame) {
        this.frame = frame;
    }

    public Ordine getOrdine(String[] sostanze) {

        //Imposta intestazione della pagina
        JLabel titoloPagina = new JLabel("Inserisci informazioni ordine");

        //Imposta pannello principale
        JPanel pannelloPrincipale = new JPanel();
        pannelloPrincipale.setLayout(new GridLayout(5, 2));

        // Selezione nome sostanza
        JLabel nomeSostanzaLabel = new JLabel("Nome sostanza: ");
        JComboBox<String> nomeSostanzaComboBox = new JComboBox<>(sostanze);
        pannelloPrincipale.add(nomeSostanzaLabel);
        pannelloPrincipale.add(nomeSostanzaComboBox);

        // Purezza
        JLabel purezzaLabel = new JLabel("Purezza:");
        JTextField purezzaField = new JTextField();
        setNumericInput(purezzaField); // Valida input numerico
        pannelloPrincipale.add(purezzaLabel);
        pannelloPrincipale.add(purezzaField);
        
        // Quantità
        JLabel quantitaLabel = new JLabel("Quantità:");
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
        confermaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Recupera i valori dal form
                    String nomeSostanza = (String) nomeSostanzaComboBox.getSelectedItem();
                    double purezza = Double.parseDouble(purezzaField.getText());
                    double quantita = Double.parseDouble(quantitaField.getText());
                    String priorita = null;

                    if (altaPrioritaRadioButton.isSelected()) priorita = "Alta";
                    else if (mediaPrioritaRadioButton.isSelected()) priorita = "Media";
                    else if (bassaPrioritaRadioButton.isSelected()) priorita = "Bassa";

                    // Mostra valori di esempio
                    System.out.println("Nome Sostanza: " + nomeSostanza);
                    System.out.println("Purezza: " + purezza);
                    System.out.println("Quantità: " + quantita);
                    System.out.println("Priorità: " + priorita);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Inserire valori numerici validi per purezza e quantità!", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Operazione annullata!");
                dispose(); // Chiude la finestra
            }
        });

        return new Ordine();

        // Aggiunta componenti alla finestra
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

    private class ActionListenerNuovoOrdine implements ActionListener {

    }
}
