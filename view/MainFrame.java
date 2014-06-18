package view;

import control.MapControl;

import javax.swing.*;
import java.awt.*;

/**
 * This is the main window, it should only contains view using controlers
 * <br /> If not, please be careful excluding them within the method getContainedView()
 * @author Jean-Christophe Isoard
 */
public class MainFrame extends JFrame {
    public MainFrame(MapControl mapControl) {
        this.setTitle("Main Frame");

        this.setLayout(new BorderLayout());
        this.add(new MapView(mapControl));

        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Must return all the views, should be used to assign them their respective controllers
     * @return An array of components (please verify the instance before cast)
     */
    public Component[] getContainedViews() {
        return this.getComponents();
    }
}
