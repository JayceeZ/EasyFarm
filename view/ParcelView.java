package view;

import control.MapControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Jean-Christophe Isoard
 */
public class ParcelView extends JPanel {
    private int parcelId;
    private MapControl mapControl;

    public ParcelView(int parcelId, MapControl mapControl) {
        this.parcelId = parcelId;
        this.mapControl = mapControl;

        this.addMouseListener(new ClickOnParcel());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Polygon parcelGeometry = mapControl.getGeometry(parcelId);
        g.drawPolygon(parcelGeometry);
    }

    private class ClickOnParcel extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            mapControl.mouseClic();
        }
    }
}
