import PackageGraphics.AppFrame;
import PackageGraphics.Homepage;

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

        Homepage homepage = new Homepage(frame);
        homepage.display();

    }
}