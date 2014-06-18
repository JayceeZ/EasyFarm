package view;

import control.MapControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Jean-Christophe Isoard
 */
public class MapView extends JPanel {
    private MapControl mapControl;

    public MapView(MapControl mapControl) {
        this.mapControl = mapControl;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        paintMap(g);
    }

    /**
     * Paint the map with all the elements
     */
    private void paintMap(Graphics g) {
        for(Polygon geometry:mapControl.getAllGeometries()) {
            if(geometry != null) {
                g.drawPolygon(geometry);
            }
        }
    }

    private class MouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            mapControl.mouseClic(e.getPoint());
        }
    }
}
