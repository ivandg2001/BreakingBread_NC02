package PackageUtils;

import PackageResponsabile.Responsabile;
import PackageResponsabile.ResponsabileDAO;
import PackageRicercatore.Ricercatore;
import PackageRicercatore.RicercatoreDAO;

import javax.swing.*;

/**
 * Classe per che gestisce la GUI homepage
 */
public class Homepage {

    /**
     * oggetto AppFrame che rappresenta il frame per laGUI
     */
    private AppFrame frame;

    /**
     * Costruttore parametrico che inizializza gli attributi
     * @param frame oggetto AppFrame
     */
    public Homepage(AppFrame frame) {
        this.frame = frame;
    }

    /**
     * Metodo che permette di visualizza la homepage nell'AppFrame
     */
    public void display() {
        JPanel panel = new JPanel();
        panel.add(getResponsabileButton());
        panel.add(getRicercatoreButton());

        this.frame.updateCenter(panel);
        this.frame.loadUpdates();
    }

    /**
     * Metodo che crea e restituisce il bottone per il responsabile
     * @return oggetto JButton
     */
    private JButton getResponsabileButton() {
        JButton button = new JButton("Responsabile");

        button.addActionListener(e -> {
            //simula login
            ResponsabileDAO responsabileDAO = new ResponsabileDAO();
            Responsabile responsabile = responsabileDAO.getResponsabileById(1);

            ResponsabileHomepage responsabileHomepage = new ResponsabileHomepage(frame, responsabile);
            responsabileHomepage.display();
        });

        return button;
    }

    /**
     * Metodo che crea e restituisce il bottone per il ricercatore
     * @return oggetto JButton
     */
    private JButton getRicercatoreButton() {
        JButton button = new JButton("Ricercatore");

        button.addActionListener(e -> {
            //simula login
            RicercatoreDAO ricercatoreDAO = new RicercatoreDAO();
            Ricercatore ricercatore = ricercatoreDAO.getRicercatore(1);

            RicercatoreHomepage ricercatoreHomepage = new RicercatoreHomepage(frame, ricercatore);
            ricercatoreHomepage.display();
        });

        return button;
    }
}