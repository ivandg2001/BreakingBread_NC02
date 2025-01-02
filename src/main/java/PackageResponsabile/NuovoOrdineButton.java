package PackageResponsabile;

import javax.swing.*;

public class NuovoOrdineButton extends JButton {

    public NuovoOrdineButton() {
        super("Nuovo Ordine");
        this.addActionListener(e -> {
            NuovoOrdineControl nuovoOrdineControl = new NuovoOrdineControl();
            nuovoOrdineControl.creaNuovoOrdine();
        });
    }
}
