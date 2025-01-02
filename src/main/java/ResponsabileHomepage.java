<<<<<<< HEAD
import PackageResponsabile.NuovoOrdineButton;

import javax.swing.*;

public class ResponsabileHomepage {

    private AppFrame frame;

    public ResponsabileHomepage(AppFrame frame) {this.frame = frame;}

    public void display() {
        JPanel panel = new JPanel();
        NuovoOrdineButton nuovoOrdineButton = new NuovoOrdineButton();
        panel.add(nuovoOrdineButton);

        this.frame.updateCenter(panel);
        this.frame.loadUpdates();
    }
=======
public class ResponsabileHomepage {
>>>>>>> 86def912c28d8cb152c5fc3a85a393b04035a073
}
