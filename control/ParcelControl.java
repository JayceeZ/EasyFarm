package control;

import view.ParcelView;

import java.awt.*;

/**
 * @author Jean-Christophe Isoard
 */
public class ParcelControl {
    private ParcelView parcelView;

    public ParcelControl(ParcelView parcelView) {
        this.parcelView = parcelView;
    }

    public void mouseClic() {
        //TODO what to do onclick on a parcel

    }

    /**
     * Return the geometry of the parcel associated to the id
     * <br />Need the parcel to be loaded from database
     * @see LoadMap
     * @param parcelId The id of the parcel we want
     */
    public Polygon getGeometry(int parcelId) {
        return null;
    }
}
