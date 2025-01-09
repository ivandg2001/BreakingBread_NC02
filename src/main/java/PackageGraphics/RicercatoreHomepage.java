package PackageGraphics;

import PackageRicercatore.PrelievoSostanzaButton;
import PackageRicercatore.Ricercatore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RicercatoreHomepage {

    private AppFrame frame;
    private Ricercatore ricercatore;

    public RicercatoreHomepage(AppFrame frame, Ricercatore ricercatore) {
        this.frame = frame;
        this.ricercatore = ricercatore;
    }

    public void display() {
        JPanel panel = new JPanel();
        PrelievoSostanzaButton prelievoSostanzaButton = new PrelievoSostanzaButton(frame, ricercatore);
        panel.add(prelievoSostanzaButton);

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
