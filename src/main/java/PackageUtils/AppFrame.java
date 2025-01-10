package PackageUtils;

import javax.swing.*;
import java.awt.*;

/**
 * Classe che funge da Frame per la GUI
 */
public class AppFrame {

    /**
     * Frame effettivo
     */
    private final JFrame frame;
    /**
     * Attuale pannello alto
     */
    private JComponent northComponent;
    /**
     * Attuale pannello basso
     */
    private JComponent southComponent;
    /**
     * Attuale pannello centrale
     */
    private JComponent centerComponent;

    /**
     * Costruttore predefinito
     */
    public AppFrame () {
        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setSize(700, 500);
        this.frame.setTitle("Breaking Bread");
    }

    /**
     * Rende visibile il frame
     */
    public void display() {
        this.frame.setVisible(true);
    }

    /**
     * Aggiorna i contenuti della parte alta del frame
     *
     * @param component il pannello che verrà posizionato nella parte alta del frame
     */
    public void updateNorth(JComponent component) {
        if (this.northComponent != null)
            this.frame.remove(this.northComponent);
        this.northComponent = component;
        this.frame.add(this.northComponent, BorderLayout.NORTH);
    }

    /**
     * Aggiorna i contenuti della parte bassa del frame
     *
     * @param component il pannello che verrà posizionato nella parte bassa del frame
     */
    public void updateSouth(JComponent component) {
        if (this.southComponent != null)
            this.frame.remove(this.southComponent);
        this.southComponent = component;
        this.frame.add(this.southComponent, BorderLayout.SOUTH);
    }

    /**
     * Aggiorna i contenuti della parte centrale del frame
     *
     * @param component il pannello che verrà posizionato al centro del frame
     */
    public void updateCenter(JComponent component) {
        if (this.centerComponent != null)
            this.frame.remove(this.centerComponent);
        this.centerComponent = component;
        this.frame.add(this.centerComponent, BorderLayout.CENTER);
    }

    /**
     * Metodo che cancella tutti gli elementi dall'AppFrame, rende la GUi pulita serve in caso di update
     */
    public void resetAppFrame(){
        if (this.centerComponent != null)
            this.frame.remove(this.centerComponent);
        if (this.southComponent != null)
            this.frame.remove(this.southComponent);
        if (this.northComponent != null)
            this.frame.remove(this.northComponent);

    }

    /**
     * Visualizza le modifiche apportate nel frame
     */
    public void loadUpdates() {
        this.frame.revalidate();
        this.frame.repaint();
    }

    /**
     * Metodo che permette di visualizzare un popup di errore
     * @param message messagio da far visualizzare al popup
     */
    public void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(frame, message, "Errore", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Metodo che permette di visualizzare un popup di conferma
     * @param message messagio da far visualizzare al popup
     */
    public void showConfirmDialog(String message){
        JOptionPane.showMessageDialog(frame , message);
    }
}
