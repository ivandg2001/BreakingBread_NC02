package PackageNuovoOrdine;

import PackageUtils.AppFrame;
import PackageUtils.ResponsabileHomepage;
import PackageUtils.RicercatoreHomepage;

public class ConfermaOrdinePopup {

    private AppFrame frame;
    private Responsabile responsabile;

    public ConfermaOrdinePopup(AppFrame frame, Responsabile ricercatore) {
        this.frame = frame;
        this.responsabile = ricercatore;
    }

    public void display() {
        frame.showConfirmDialog("L'ordine verra' finalizzato!");
        ResponsabileHomepage responsabileHomepage = new ResponsabileHomepage(frame, responsabile);
        responsabileHomepage.display();
    }
}
