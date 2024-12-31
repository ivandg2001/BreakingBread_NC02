package PackageArmadietto;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Entity che rappresenta l'armadietto.
 */
public class Armadietto {

    /**
     * Lista dei lotti presenti nel laboratorio
     */
    private ArrayList<Lotto> lotti;

    /**
     * Costruttore predefinito
     */
    public Armadietto(){
        this.lotti = new ArrayList<Lotto>();
    }

    /**
     * Costruttore parametrico che inizializza il campo
     * @param lotti lotti del laboratorio
     */
    public Armadietto(ArrayList<Lotto> lotti){
        this.lotti = lotti;
    }

    /**
     * Ritorna la lista dei lotti
     * @return lista lotti
     */
    public List<Lotto> getLotti() {
        return lotti;
    }

    /**
     * Setta la lista dei lotti
     * @param lotti lista lotti
     */
    public void setLotti(ArrayList<Lotto> lotti) {
        this.lotti = lotti;
    }

    /**
     * Metodo che permette di aggiungere un lotto alla lista dei lotti
     * @param lotto
     */
    public void addLotto(Lotto lotto){
        this.lotti.add(lotto);
    }
}
