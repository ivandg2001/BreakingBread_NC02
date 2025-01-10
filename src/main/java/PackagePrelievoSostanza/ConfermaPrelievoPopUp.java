package PackagePrelievoSostanza;

import PackageUtils.AppFrame;
import PackageUtils.RicercatoreHomepage;

public class ConfermaPrelievoPopUp {

    private AppFrame frame;
    private Ricercatore ricercatore;

    public ConfermaPrelievoPopUp(AppFrame frame, Ricercatore ricercatore) {
        this.frame = frame;
        this.ricercatore = ricercatore;
    }

    public void display() {
        frame.showConfirmDialog("Sostanza prelevata con successo!");
        RicercatoreHomepage ricercatoreHomepage = new RicercatoreHomepage(frame, ricercatore);
        ricercatoreHomepage.display();
    }
}
