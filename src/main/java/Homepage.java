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
            ResponsabileHomepage responsabileHomepage = new ResponsabileHomepage(frame);
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