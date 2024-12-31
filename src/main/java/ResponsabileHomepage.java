import javax.swing.*;

public class ResponsabileHomepage {

    private AppFrame frame;

    public ResponsabileHomepage(AppFrame frame) {this.frame = frame;}

    public void display() {
        JPanel panel = new JPanel();
        panel.add(getNuovoOrdineButton());

        this.frame.updateCenter(panel);
        this.frame.loadUpdates();
    }
}
