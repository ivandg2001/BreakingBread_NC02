package PackageResponsabile;

import javax.swing.*;
import PackageGraphics.AppFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NuovoOrdineButton extends JButton {

    public NuovoOrdineButton(AppFrame frame, Responsabile responsabile) {
        super("Nuovo Ordine");
        this.addActionListener(new ActionListenerbutton(responsabile , frame));
    }

    private static class ActionListenerbutton implements ActionListener {

        private Responsabile responsabile;
        private AppFrame frame;

        public ActionListenerbutton(Responsabile responsabile, AppFrame frame) {
            this.responsabile = responsabile;
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            ResponsabileControl nuovoOrdineControl = new ResponsabileControl(frame, responsabile);
            nuovoOrdineControl.creaNuovoOrdine();
        }
    }
}
