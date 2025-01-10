package PackageUtils;

import PackagePrelievoSostanza.PrelievoSostanzaButton;
import PackagePrelievoSostanza.Ricercatore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe che implementa la GUI per la homepage del ricercatore
 */
public class RicercatoreHomepage {

    /**
     * Oggetto AppFrame
     */
    private AppFrame frame;
    /**
     * Oggetto per il responsabile loggato
     */
    private Ricercatore ricercatore;

    /**
     * Costruttore parametrico che inizializza gli attributi
     * @param frame oggetto AppFrame
     * @param ricercatore oggetto Ricercatore
     */
    public RicercatoreHomepage(AppFrame frame, Ricercatore ricercatore) {
        this.frame = frame;
        this.ricercatore = ricercatore;
    }

    /**
     * Metodo che permette di visualizzare la homepage ricercatore
     */
    public void display() {
        JPanel panel = new JPanel();
        PrelievoSostanzaButton prelievoSostanzaButton = new PrelievoSostanzaButton(frame, ricercatore);
        panel.add(prelievoSostanzaButton);

        JButton homeButton = new JButton("Homepage");
        panel.add(homeButton);

        homeButton.addActionListener(e ->  {
            Homepage homepage = new Homepage(frame);
            homepage.display();
        });

        this.frame.resetAppFrame();
        this.frame.updateCenter(panel);
        this.frame.loadUpdates();
    }
}
