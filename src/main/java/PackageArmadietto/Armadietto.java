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
     * Questo metodo restituisce una lista, i cui elementi sono degli Array di Stringhe.
     * Ciascun elemento di questo array rappresenta un lotto presente nell'armadietto.
     * Ogni array contiene i seguenti elementi:
     * 1. ID del lotto;
     * 2. Nome della sostanza contenuta nel lotto;
     * 3. Formula chimica della sostanza contenuta nel lotto;
     * 4. Purezza della sostanza contenuta nel lotto.
     *
     * @return Una ArrayList di Array dì stringhe.
     */
    public ArrayList<String[]> getListaLottiFormattati() {

        LottoDataInterface lottoDI = new LottoDAO();
        ArrayList<String[]> listaLottiFormattati = new ArrayList<>();
        ArrayList<Lotto> lotti = lottoDI.getListaLotti();


        for (Lotto lotto : lotti) {
            if (lotto.isExpired() || lotto.getQuantita() < 0.01) {
                continue;
            }

            String[] lottoFormattato = new String[4];

            lottoFormattato[0] = Integer.toString(lotto.getID());
            lottoFormattato[1] = lotto.getSostanza().getNome();
            lottoFormattato[2] = lotto.getSostanza().getFormula();
            lottoFormattato[3] = Double.toString(lotto.getPurezza());

            listaLottiFormattati.add(lottoFormattato);
        }

        return listaLottiFormattati;
    }

    /**
     * Esegue il prelievo di una sostanza dall'armadietto.
     *
     * @param idLotto Id del lotto da cui prelevare.
     * @param quantita Quantità della sostanza da prelevare dal lotto.
     */
    public void eseguiPrelievo(int idLotto, double quantita) {
        // Aggiornamento Lotto
        LottoDataInterface lottoDI = new LottoDAO();
        Lotto lotto = lottoDI.getLottoById(idLotto);

        double nuovaQuantita = lotto.getQuantita() - quantita;
        lotto.setQuantita(nuovaQuantita);
        lottoDI.updateLotto(lotto);
    }
}
