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

    private static JButton getResponsabileButton() {
        JButton button = new JButton("Responsabile");

        button.addActionListener(e -> {
            ResponsabileHomepage responsabileHomepage = new ResponsabileHomepage();
            responsabileHomepage.display();
        });

        return button;
    }

    private static JButton getRicercatoreButton() {
        JButton button = new JButton("Ricercatore");

        button.addActionListener(e -> {
            RicercatoreHomepage ricercatoreHomepage = new RicercatoreHomepage();
            ricercatoreHomepage.display();
        });

        return button;
    }
}