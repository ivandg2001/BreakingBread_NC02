package PackageGraphics;

import PackageResponsabile.NuovoOrdineButton;

import javax.swing.*;

public class ResponsabileHomepage {

    private AppFrame frame;

    public ResponsabileHomepage(AppFrame frame) {this.frame = frame;}

    public void display() {
        JPanel panel = new JPanel();
        NuovoOrdineButton nuovoOrdineButton = new NuovoOrdineButton(frame);
        panel.add(nuovoOrdineButton);

        // Prendere responsabile da database
        //Responsabile responsabile = new Responsabile();

        this.frame.updateCenter(panel);
        this.frame.loadUpdates();
    }
}
