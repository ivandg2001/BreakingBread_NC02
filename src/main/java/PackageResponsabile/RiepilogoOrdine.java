package PackageResponsabile;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import PackageArmadietto.ArmadiettoFacade;
import PackageArmadietto.ArmadiettoGetDataInterface;
import PackageGraphics.AppFrame;

import javax.swing.*;

/**
 * Classe che gestisce la GUI per il riepilogo dell'ordine
 */
public class RiepilogoOrdine {

    /**
     * Oggetto AppFrame che contien la GUI
     */
    private AppFrame frame;
    /**
     * Istanza dell'oggetto control che ha chiamato la procedura.
     */
    private NuovoOrdineControl cotrol;

    /**
     * Oggetto ordine di cui sono state inserite le informazioni nel form
     */
    private Ordine ordine;
    /**
     * Sostanza selezionata
     */
    private String sostanza;
    /**
     * Purezza indicata
     */
    private double purezza;
    /**
     * Quantita indicata
     */
    private double quantita;
    /**
     * Priorita' indicata
     */
    private Integer priorita;

    /**
     * Costruttore parametrico che inizializza gli attributi
     * @param frame oggetto AppFrama
     * @param control oggetto NuovoOrdineControl
     * @param nuovoOrdine oggetto Ordine
     * @param sostanza nome sostanza
     * @param purezza valore purezza
     * @param quantita valore quantita
     * @param priorita valore priorita
     */
    public RiepilogoOrdine(AppFrame frame , NuovoOrdineControl control , Ordine nuovoOrdine , String sostanza , double purezza , double quantita , Integer priorita){
        this.cotrol = control;
        this.frame = frame;
        this.ordine = nuovoOrdine;
        this.sostanza = sostanza;
        this.purezza = purezza;
        this.quantita = quantita;
        this.priorita = priorita;
    }

    /**
     * Metodo che permette di visualizza a schermo il riepilogo
     */
    public void display() {

        ArmadiettoGetDataInterface i = new ArmadiettoFacade();
        String formulaChimica = i.getFormulaBySostanza(sostanza); // Assumendo che Ordine abbia un metodo getFormulaChimica()
        String dataOrdine = ordine.getDataOrdine().toString(); // Assumendo che Ordine abbia un metodo getDataOrdine()
        double costo = ordine.getCosto(); // Assumendo che Ordine abbia un metodo getCosto()


        JPanel panel = new JPanel(new BorderLayout());


        JLabel titleLabel = new JLabel("Riepilogo ordine", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        panel.add(titleLabel, BorderLayout.NORTH);


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


        JPanel costPanel = new JPanel(new BorderLayout());
        JLabel costLabel = new JLabel("Costo: " + String.format("%.2f €", costo), SwingConstants.CENTER);
        costLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        costPanel.add(costLabel, BorderLayout.CENTER);

        infoPanel.add(costPanel);
        panel.add(infoPanel, BorderLayout.CENTER);


        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton confirmButton = new JButton("Conferma");
        JButton cancelButton = new JButton("Annulla");
        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);


        frame.resetAppFrame();
        frame.updateCenter(panel);
        frame.loadUpdates();


        confirmButton.addActionListener(new ConfermaActionListener(this.cotrol , this.ordine , this.sostanza , this.purezza , this.quantita , this.priorita));
        cancelButton.addActionListener(new AnnullaActionListener(this.cotrol));
    }

    /**
     * Metodo privato che gestisce la creazione di label all'interno del riepilogo, serve a far visualizzare le informazioni
     * @param label label da inserire
     * @param value valore inserito
     * @return oggetto Jpanel
     */
    private JPanel createInfoRow(String label, String value) {
        JPanel row = new JPanel(new BorderLayout());
        JLabel keyLabel = new JLabel(label);
        JLabel valueLabel = new JLabel(value);
        row.add(keyLabel, BorderLayout.WEST);
        row.add(valueLabel, BorderLayout.CENTER);
        return row;
    }

    /**
     * Action listenr che gestisce la conferma dell'ordine
     */
    private static class ConfermaActionListener implements ActionListener{

        /**
         * Controller che ha chiamato la procedura
         */
        private NuovoOrdineControl control;

        /**
         * Ordine da confermare
         */
        private Ordine ordine;
        /**
         * nome sostanza
         */
        private String sostanza;
        /**
         * valore purezza
         */
        private double purezza;
        /**
         * Valore quantita
         */
        private double quantita;
        /**
         * valore priorita
         */
        private Integer priorita;

        /**
         * Costruttore parametrico che inizializza gli attributi
         * @param control oggetto NuovoOrdineControl
         * @param ordine oggetto Oridne
         * @param sostanza nome sostanza
         * @param purezza valore purezza
         * @param quantita valore quantita
         * @param priorita valore priorita
         */
        public ConfermaActionListener(NuovoOrdineControl control , Ordine ordine , String sostanza , double purezza , double quantita , Integer priorita){
            this.control = control;
            this.ordine = ordine;
            this.sostanza = sostanza;
            this.purezza = purezza;
            this.priorita = priorita;
            this.quantita = quantita;
        }

        /**
         * Metodo action performed che gestisce il click sulla conferma, crea il popup di conferma e finalizza l'ordine tramite il control.
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            control.confermaPopup("L'ordine verrà inserito nel database e finalizzato!");
            control.finalizzaOrdine(ordine , sostanza , purezza , quantita , priorita);
        }
    }

    /**
     * Actionlistener per l'annullamneto dell'ordine
     */
    private static class AnnullaActionListener implements ActionListener{

        /**
         * Controller che ha chiamato la procedura
         */
        private NuovoOrdineControl control;

        /**
         * Costruttore parametrico che inizializza gli attributi
         * @param control oggetto NuovoOrdineControl
         */
        public AnnullaActionListener(NuovoOrdineControl control){
            this.control = control;
        }

        /**
         * Metodo action performed che al click richiama il metodo per annullare l'ordine tramite il control
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            control.annullaOrdine();
        }
    }
}
