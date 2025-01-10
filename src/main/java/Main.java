import PackageUtils.AppFrame;
import PackageUtils.DatabaseConnectionDAO;
import PackageUtils.DatabaseConnectionInterface;
import PackageUtils.Homepage;

import java.sql.SQLException;

/**
 * Classe Main da cui parte il programma
 */
public class Main {

    /**
     * Metodo main
     * @param args argomenti
     */
    public static void main(String[] args) {

        AppFrame frame = new AppFrame();
        frame.display();

        DatabaseConnectionInterface i = new DatabaseConnectionDAO();
        try{
            i.createConnection();
        } catch (SQLException e) {
            frame.showErrorDialog("Errore nella connessione al database, controllare il server e riaccedere al programma.");

            System.exit(1);
        }

        Homepage homepage = new Homepage(frame);
        homepage.display();

    }
}