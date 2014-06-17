package view;

import control.ParcelControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Jean-Christophe Isoard
 */
public class ParcelView extends JPanel {
    private int parcelId;
    private ParcelControl parcelControl;

    public ParcelView(int parcelId, ParcelControl parcelControl, Dimension dimensionOnLoad) {
        this.parcelId = parcelId;
        this.parcelControl = parcelControl;

        this.setPreferredSize(dimensionOnLoad);
        this.addMouseListener(new ClickOnParcel());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Polygon parcelGeometry = parcelControl.getGeometry(parcelId);
        g.drawPolygon(parcelGeometry);
    }

    private class ClickOnParcel extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            parcelControl.mouseClic();
        }
    }
}
