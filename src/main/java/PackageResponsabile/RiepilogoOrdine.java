package PackageResponsabile;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import PackageArmadietto.ArmadiettoFacade;
import PackageArmadietto.ArmadiettoGetDataInterface;
import PackageGraphics.AppFrame;

import javax.swing.*;

public class RiepilogoOrdine {

    private AppFrame frame;
    private ResponsabileControl cotrol;

    private Ordine ordine;
    private String sostanza;
    private double purezza;
    private double quantita;
    private Integer priorita;


    public RiepilogoOrdine(AppFrame frame , ResponsabileControl control , Ordine nuovoOrdine , String sostanza , double purezza , double quantita , Integer priorita){
        this.cotrol = control;
        this.frame = frame;
        this.ordine = nuovoOrdine;
        this.sostanza = sostanza;
        this.purezza = purezza;
        this.quantita = quantita;
        this.priorita = priorita;
    }

    public void display() {
        // Ottieni informazioni dall'ordine
        ArmadiettoGetDataInterface i = new ArmadiettoFacade();
        String formulaChimica = i.getFormulaBySostanza(sostanza); // Assumendo che Ordine abbia un metodo getFormulaChimica()
        String dataOrdine = ordine.getDataOrdine().toString(); // Assumendo che Ordine abbia un metodo getDataOrdine()
        double costo = ordine.getCosto(); // Assumendo che Ordine abbia un metodo getCosto()

        // Creazione del pannello principale
        JPanel panel = new JPanel(new BorderLayout());

        // Titolo in alto
        JLabel titleLabel = new JLabel("Riepilogo ordine", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        panel.add(titleLabel, BorderLayout.NORTH);

        // Pannello centrale per le informazioni
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        infoPanel.add(createInfoRow("Sostanza:", sostanza));
        infoPanel.add(createInfoRow("Formula chimica:", formulaChimica));
        infoPanel.add(createInfoRow("Purezza:", purezza + "%"));
        infoPanel.add(createInfoRow("Quantità:", quantita + " mg/ml"));

        String prioritaString;
        if (priorita == 3){
            prioritaString = "Alta";
        } else if (priorita == 2) {
            prioritaString = "Media";
        } else {
            prioritaString = "Bassa";
        }

        infoPanel.add(createInfoRow("Priorità ordine:", prioritaString));
        infoPanel.add(createInfoRow("Data ordine:", dataOrdine));

        // Pannello per il costo
        JPanel costPanel = new JPanel(new BorderLayout());
        JLabel costLabel = new JLabel("Costo: " + String.format("%.2f €", costo), SwingConstants.CENTER);
        costLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        costPanel.add(costLabel, BorderLayout.CENTER);

        infoPanel.add(costPanel);
        panel.add(infoPanel, BorderLayout.CENTER);

        // Pannello dei pulsanti
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton confirmButton = new JButton("Conferma");
        JButton cancelButton = new JButton("Annulla");
        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Aggiungi il pannello al frame
        frame.resetAppFrame();
        frame.updateCenter(panel);
        frame.loadUpdates();

        // Azioni per i pulsanti
        confirmButton.addActionListener(new ConfermaActionListener(this.cotrol , this.ordine , this.sostanza , this.purezza , this.quantita , this.priorita));
        cancelButton.addActionListener(new AnnullaActionListener(this.cotrol));
    }

    private JPanel createInfoRow(String label, String value) {
        JPanel row = new JPanel(new BorderLayout());
        JLabel keyLabel = new JLabel(label);
        JLabel valueLabel = new JLabel(value);
        row.add(keyLabel, BorderLayout.WEST);
        row.add(valueLabel, BorderLayout.CENTER);
        return row;
    }

    private static class ConfermaActionListener implements ActionListener{

        private ResponsabileControl control;

        private Ordine ordine;
        private String sostanza;
        private double purezza;
        private double quantita;
        private Integer priorita;

        public ConfermaActionListener(ResponsabileControl control , Ordine ordine , String sostanza , double purezza , double quantita , Integer priorita){
            this.control = control;
            this.ordine = ordine;
            this.sostanza = sostanza;
            this.purezza = purezza;
            this.priorita = priorita;
            this.quantita = quantita;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            control.confermaPopup("L'ordine verrà inserito nel database e finalizzato!");
            control.finalizzaOrdine(ordine , sostanza , purezza , quantita , priorita);
        }
    }

    private static class AnnullaActionListener implements ActionListener{

        private ResponsabileControl control;

        public AnnullaActionListener(ResponsabileControl control){
            this.control = control;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            control.annullaOrdine();
        }
    }
}
