import control.MapControl;
import view.MainFrame;

/**
 * @author Jean-Christophe Isoard
 */
public class Main {

    public static void main(String[] args) {
        //TODO EAS-7 first execution to elaborate
        MapControl mapControl = new MapControl();
        new MainFrame(mapControl);
    }
}
