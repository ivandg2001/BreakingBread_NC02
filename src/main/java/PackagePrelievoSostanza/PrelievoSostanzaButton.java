package PackagePrelievoSostanza;

import PackageUtils.AppFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Oggetto boundary per l'avvio della funzionalità di prelievo sostanze dall'armadietto.
 */
public class PrelievoSostanzaButton extends JButton {

    /**
     * Costruttore parametrico
     *
     * @param frame Un riferimento al frame principale dell'applicazione.
     * @param ricercatore Il ricercatore che avvia la funzionalità di prelievo.
     */
    public PrelievoSostanzaButton(AppFrame frame, Ricercatore ricercatore) {
        super("Prelievo Sostanza");
        this.addActionListener(new PrelievoSostanzaButton.ActionListenerButton(frame, ricercatore));
    }

    /**
     * Definizione dell'action listener del bottone.
     */
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
