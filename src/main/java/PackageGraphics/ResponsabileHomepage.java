package PackageGraphics;

import PackageResponsabile.NuovoOrdineButton;
import PackageResponsabile.Responsabile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResponsabileHomepage {

    private AppFrame frame;
    private Responsabile responsabile;

    public ResponsabileHomepage(AppFrame frame, Responsabile responsabile) {
        this.frame = frame;
        this.responsabile = responsabile;
    }

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
