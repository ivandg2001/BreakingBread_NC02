package PackageResponsabile;

import javax.swing.*;
import PackageGraphics.AppFrame;

public class NuovoOrdineButton extends JButton {

    public NuovoOrdineButton(AppFrame frame, Responsabile responsabile) {
        super("Nuovo Ordine");
        this.addActionListener(e -> {
            ResponsabileControl nuovoOrdineControl = new ResponsabileControl(frame, responsabile);
            nuovoOrdineControl.creaNuovoOrdine();
        });
    }
}
