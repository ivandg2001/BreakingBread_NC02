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
     * @param sostanza sostanza nel lotto
     */
    public void saveLotto(LocalDate dataScadenza , double quantita , Sostanza sostanza );

    /**
     * Metodo che crea un nuovo oggetto sostanza e lo salva nel database
     * @param nome nome della sostanza
     * @param formula formula chimica della sostanza
     * @param costoUnitario costo unitario della sostanza
     */
    public void saveSostanza(String nome , String formula , double costoUnitario);

}
