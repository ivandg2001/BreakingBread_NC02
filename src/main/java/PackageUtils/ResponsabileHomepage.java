package PackageUtils;

import PackageResponsabile.NuovoOrdineButton;
import PackageResponsabile.Responsabile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe che implementa la GUI per la homepage del responsabile
 */
public class ResponsabileHomepage {

    /**
     * Oggetto AppFrame
     */
    private AppFrame frame;
    /**
     * Oggetto per il responsabile loggato
     */
    private Responsabile responsabile;

    /**
     * Costruttore parametrico che inizializza gli attributi
     * @param frame oggetto AppFrame
     * @param responsabile oggetto Responsabile
     */
    public ResponsabileHomepage(AppFrame frame, Responsabile responsabile) {
        this.frame = frame;
        this.responsabile = responsabile;
    }

    /**
     * Metodo che permette di visualizzare la homepage responsabile
     */
    public void display() {
        JPanel panel = new JPanel();
        NuovoOrdineButton nuovoOrdineButton = new NuovoOrdineButton(frame, responsabile);
        panel.add(nuovoOrdineButton);

        JButton homeButton = new JButton("Homepage");
        panel.add(homeButton);

        homeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Homepage homepage = new Homepage(frame);
                homepage.display();
            }
        });
        this.frame.resetAppFrame();
        this.frame.updateCenter(panel);
        this.frame.loadUpdates();
    }
}
