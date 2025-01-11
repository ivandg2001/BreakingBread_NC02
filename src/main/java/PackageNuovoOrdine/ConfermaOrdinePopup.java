package PackageNuovoOrdine;

import PackageUtils.AppFrame;
import PackageUtils.ResponsabileHomepage;
import PackageUtils.RicercatoreHomepage;

/**
 * Classe che implementa il boundary per la conferma del riepilogo
 */
public class ConfermaOrdinePopup {

    /**
     * Frame dell'applicazione
     */
    private AppFrame frame;
    /**
     * Responsabile che utilizza l'applicazione
     */
    private Responsabile responsabile;

    /**
     * Costruttore parametrico
     * @param frame oggetto AppFrame
     * @param responsabile oggetto Responsabile
     */
    public ConfermaOrdinePopup(AppFrame frame, Responsabile responsabile) {
        this.frame = frame;
        this.responsabile = responsabile;
    }

    /**
     * Metodo che permette di visualizzare a video il popup
     */
    public void display() {
        frame.showConfirmDialog("L'ordine verra' finalizzato!");
        ResponsabileHomepage responsabileHomepage = new ResponsabileHomepage(frame, responsabile);
        responsabileHomepage.display();
    }
}
