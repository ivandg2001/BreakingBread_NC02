import PackageArmadietto.Sostanza;
import PackageArmadietto.SostanzaDAO;

import java.sql.SQLException;

public class Main {

    private static AppFrame frame;

    public static void main(String[] args) {

        frame = new AppFrame();
        frame.display();

        Homepage homepage = new Homepage(frame);
        homepage.display();


    }
}