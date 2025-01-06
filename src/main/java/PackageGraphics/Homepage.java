package PackageGraphics;

import PackageResponsabile.Responsabile;
import PackageResponsabile.ResponsabileDAO;

import javax.swing.*;

public class Homepage {

    private AppFrame frame;

    public Homepage(AppFrame frame) {
        this.frame = frame;
    }

    public void display() {
        JPanel panel = new JPanel();
        panel.add(getResponsabileButton());
        panel.add(getRicercatoreButton());

        this.frame.updateCenter(panel);
        this.frame.loadUpdates();
    }

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

    private JButton getRicercatoreButton() {
        JButton button = new JButton("Ricercatore");

        button.addActionListener(e -> {
            RicercatoreHomepage ricercatoreHomepage = new RicercatoreHomepage();
            //ricercatoreHomepage.display();
        });

        return button;
    }
}