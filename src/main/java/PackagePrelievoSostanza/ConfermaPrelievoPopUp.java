package PackagePrelievoSostanza;

import PackageUtils.AppFrame;
import PackageUtils.RicercatoreHomepage;

/**
 * Oggetto boundary che si occupa della stampa di un pop-up per la conferma del Prelievo.
 */
public class ConfermaPrelievoPopUp {
    /**
     * Un riferimento al frame principale dell'applicazione.
     */
    private AppFrame frame;
    /**
     * Il ricercatore che sta eseguendo l'attività di prelievo
     */
    private Ricercatore ricercatore;
/**
 * Costruttore parametrico.
 *
 * @param frame Un riferimento al frame principale dell'applicazione.
 * @param control Un riferimento all'oggetto control che utilizza questo boundary.
 */
    /**
     * Costruttore parametrico.
     *
     * @param frame Un riferimento al frame principale dell'applicazione.
     * @param ricercatore Il ricercatore che sta eseguendo l'attività di prelievo
     */
    public ConfermaPrelievoPopUp(AppFrame frame, Ricercatore ricercatore) {
        this.frame = frame;
        this.ricercatore = ricercatore;
    }

    /**
     * Avvia la procedura di stampa a schermo.
     */
    public void display() {
        frame.showConfirmDialog("Sostanza prelevata con successo!");
        RicercatoreHomepage ricercatoreHomepage = new RicercatoreHomepage(frame, ricercatore);
        ricercatoreHomepage.display();
    }
}
