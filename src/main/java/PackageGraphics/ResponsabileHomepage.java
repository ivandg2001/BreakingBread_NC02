package PackageGraphics;

import PackageResponsabile.NuovoOrdineButton;
import PackageResponsabile.Responsabile;

import javax.swing.*;

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

        this.frame.updateCenter(panel);
        this.frame.loadUpdates();
    }
}
