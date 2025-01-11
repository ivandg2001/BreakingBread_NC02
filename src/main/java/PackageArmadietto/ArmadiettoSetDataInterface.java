package PackageArmadietto;

import java.time.LocalDate;

/**
 * Interfaccia che specifica l'accesso al facade per salvare i dati
 */
public interface ArmadiettoSetDataInterface {
    /**
     * Metodo che crea un nuovo oggetto lotto e lo salva nel database
     * @param dataScadenza data si scadenza
     * @param quantita quantita nel lotto
     * @param sostanzaNome sostanza nel lotto
     * @param purezza purezza sostanza
     */
    void saveLotto(LocalDate dataScadenza , double quantita , String sostanzaNome , double purezza);

    /**
     * Permette di salvare in database e far ritornare un oggetto riferimento del lotto appena creato
     * @param dataScadenza data scadenza del lotto
     * @param quantita quantita del lotto
     * @param sostanza sostanza nel lotto
     * @param purezza purezza della sostanza
     * @return Oggetto Lotto
     */
    Lotto saveAndRetrievelotto(LocalDate dataScadenza, double quantita, String sostanza , double purezza);

    /**
     * Metodo che crea un nuovo oggetto sostanza e lo salva nel database
     * @param nome nome della sostanza
     * @param formula formula chimica della sostanza
     * @param costoUnitario costo unitario della sostanza
     */
    void saveSostanza(String nome , String formula , double costoUnitario);

    /**
     * Esegue il prelievo di una sostanza dall'armadietto.
     *
     * @param idLotto Id del lotto da cui prelevare.
     * @param quantita Quantità della sostanza da prelevare dal lotto.
     */
    void eseguiPrelievo(int idLotto, double quantita);
}
