package PackageArmadietto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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

    /**
     * Questo metodo restituisce una lista, i cui elementi sono delle HashMap.
     * Ciascun elemento di questo array rappresenta un lotto presente nell'armadietto.
     * Ogni hashmap contiene due elementi: Id del lotto, alcune informazioni del lotto, formattate appositamente per esser stampate a schermo.
     *
     * @return Una ArrayList di HashMap.
     */
    public ArrayList<HashMap<String, Object>> getListaLottiFormattati() {

        LottoDataInterface lottoDI = new LottoDAO();
        ArrayList<Lotto> lotti = lottoDI.getListaLotti();

        ArrayList<HashMap<String, Object>> listaLottiFormattati = new ArrayList<>();

        for (Lotto lotto : lotti) {
            if (lotto.isExpired())
                continue;

            String[] lottoFormattato = new String[4];

            lottoFormattato[0] = Integer.toString(lotto.getID());
            lottoFormattato[1] = lotto.getSostanza().getNome();
            lottoFormattato[2] = lotto.getSostanza().getFormula();
            lottoFormattato[3] = Double.toString(lotto.getPurezza());

            HashMap<String, Object> lottoHashMap = new HashMap<>();
            lottoHashMap.put("lottoID", lotto.getID());
            lottoHashMap.put("lottoInfo", lottoFormattato);

            listaLottiFormattati.add(lottoHashMap);
        }

        return listaLottiFormattati;
    }
}
