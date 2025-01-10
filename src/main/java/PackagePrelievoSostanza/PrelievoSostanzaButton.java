package PackagePrelievoSostanza;

import PackageUtils.AppFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrelievoSostanzaButton extends JButton {

    public PrelievoSostanzaButton(AppFrame frame, Ricercatore ricercatore) {
        super("Prelievo Sostanza");
        this.addActionListener(new PrelievoSostanzaButton.ActionListenerButton(frame, ricercatore));
    }

    private static class ActionListenerButton implements ActionListener {

        private Ricercatore ricercatore;
        private AppFrame frame;

        public ActionListenerButton(AppFrame frame, Ricercatore ricercatore) {
            this.ricercatore = ricercatore;
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            PrelievoSostanzaInterface ricercatoreInterface = new PrelievoSostanzaControl(frame, ricercatore);
            ricercatoreInterface.prelevaSostanza();
        }
    }
}
