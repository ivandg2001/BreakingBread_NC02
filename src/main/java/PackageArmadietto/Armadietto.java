package PackageArmadietto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Entity che rappresenta l'armadietto.
 */
public class Armadietto {

    /**
     * Lista dei lotti presenti nell'armadietto
     */
    private ArrayList<Lotto> lotti;


    /**
     * Variabile statica per l'interfaccia al DAO Lotto
     */
    public static final LottoDataInterface lottoDataInterface = new LottoDAO();


    /**
     * Costruttore predefinito
     */
    public Armadietto(){
        this.lotti = lottoDataInterface.getListaLotti();
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
    public ArrayList<Lotto> getLotti() {
        return this.lotti;
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
     * @param lotto oggetto lotto
     */
    public void addLotto(Lotto lotto){
        this.lotti.add(lotto);
    }



}
