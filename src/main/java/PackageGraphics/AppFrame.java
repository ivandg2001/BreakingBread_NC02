package PackageGraphics;

import javax.swing.*;
import java.awt.*;

public class AppFrame {

    /**
     * Frame effettivo
     */
    private final JFrame frame;
    /**
     * Attuale pannello alto
     */
    private JPanel northPanel;
    /**
     * Attuale pannello basso
     */
    private JPanel southPanel;
    /**
     * Attuale pannello centrale
     */
    private JPanel centerPanel;

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
     * @param panel il pannello che verrà posizionato nella parte alta del frame
     */
    public void updateNorth(JPanel panel) {
        this.frame.remove(this.northPanel);
        this.northPanel = panel;
        this.frame.add(this.northPanel, BorderLayout.NORTH);
    }

    /**
     * Aggiorna i contenuti della parte bassa del frame
     *
     * @param panel il pannello che verrà posizionato nella parte bassa del frame
     */
    public void updateSouth(JPanel panel) {
        this.frame.remove(this.southPanel);
        this.southPanel = panel;
        this.frame.add(this.southPanel, BorderLayout.SOUTH);
    }

    /**
     * Aggiorna i contenuti della parte centrale del frame
     *
     * @param panel il pannello che verrà posizionato al centro del frame
     */
    public void updateCenter(JPanel panel) {
        this.frame.remove(this.centerPanel);
        this.centerPanel = panel;
        this.frame.add(this.centerPanel, BorderLayout.CENTER);
    }

    /**
     * Visualizza le modifiche apportate nel frame
     */
    public void loadUpdates() {
        this.frame.revalidate();
        this.frame.repaint();
    }
}
