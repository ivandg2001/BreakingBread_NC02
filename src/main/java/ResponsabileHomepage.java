import PackageResponsabile.NuovoOrdineButton;
import PackageResponsabile.Responsabile;

import javax.swing.*;

public class ResponsabileHomepage {

    private AppFrame frame;

    public ResponsabileHomepage(AppFrame frame) {this.frame = frame;}

    public void display() {
        JPanel panel = new JPanel();
        NuovoOrdineButton nuovoOrdineButton = new NuovoOrdineButton();
        panel.add(nuovoOrdineButton);

        // Prendere responsabile da database
        //Responsabile responsabile = new Responsabile();

        this.frame.updateCenter(panel);
        this.frame.loadUpdates();
    }
}
