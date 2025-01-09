import PackageGraphics.AppFrame;
import PackageGraphics.Homepage;

public class Main {

    public static void main(String[] args) {

        AppFrame frame = new AppFrame();
        frame.display();

        Homepage homepage = new Homepage(frame);
        homepage.display();

    }
}