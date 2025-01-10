package PackageResponsabile;

import javax.swing.*;
import PackageUtils.AppFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe che specifica il pulsante per avviare la procedura del nuovo ordine.
 */
public class NuovoOrdineButton extends JButton {

    /**
     * Costruttore parametrico che inizializza gli attributi.
     * @param frame il frame a cui e' legato tale pulsante.
     * @param responsabile il responsabile che ha avviato laprocedura.
     */
    public NuovoOrdineButton(AppFrame frame, Responsabile responsabile) {
        super("Nuovo Ordine");
        this.addActionListener(new ActionListenerbutton(responsabile , frame));
    }

    /**
     * Classe privata action listener per modificare il comportamento del pulsante al click.
     */
    private static class ActionListenerbutton implements ActionListener {

        /**
         * Oggetto responsabile, responsabile che ha cliccato il pulsante.
         */
        private Responsabile responsabile;
        /**
         * Oggetto AppFrame, il frame a cui e' legato tale pulsante.
         */
        private AppFrame frame;

        /**
         * Costruttore parametrico che inizializza gli attributi.
         * @param responsabile oggetto Responsabile
         * @param frame oggetto AppFrame
         */
        public ActionListenerbutton(Responsabile responsabile, AppFrame frame) {
            this.responsabile = responsabile;
            this.frame = frame;
        }

        /**
         * Action performed, al click parte il controller che gestisce gli eventi per l'inserimento del nuovo ordine.
         * @param e evento da processare
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            ResponsabileInterface i = new NuovoOrdineControl(frame, responsabile);
            i.creaNuovoOrdine();
        }
    }
}
