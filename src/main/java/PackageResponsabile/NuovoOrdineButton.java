package PackageResponsabile;

import javax.swing.*;
import PackageGraphics.AppFrame;

public class NuovoOrdineButton extends JButton {

    public NuovoOrdineButton(AppFrame frame) {
        super("Nuovo Ordine");
        this.addActionListener(e -> {
            NuovoOrdineControl nuovoOrdineControl = new NuovoOrdineControl(frame);
            nuovoOrdineControl.creaNuovoOrdine();
        });
    }
}
