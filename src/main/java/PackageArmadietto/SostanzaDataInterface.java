package PackageArmadietto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SostanzaDataInterface {

    // Aggiunge una nuova sostanza al database
    void addSostanza(Sostanza sostanza) throws SQLException;

    // Recupera una sostanza per nome
    Sostanza getSostanzaByNome(String nome) throws SQLException;

    // Recupera una sostanza per ID
    Sostanza getSostanzaByID(int id) throws SQLException;

    // Aggiorna una sostanza esistente nel database
    void updateSostanza(Sostanza sostanza) throws SQLException;

    // Elimina una sostanza dal database
    void deleteSostanza(int id) throws SQLException;

    ArrayList<Sostanza> getListaSostanze() throws SQLException;
}
