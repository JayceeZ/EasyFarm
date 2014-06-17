package model.piece;

import model.location.Location;

import java.awt.*;

/**
 * @author Jean-Christophe Isoard
 */
public class Parcel {
    public static Parcel incomplete = new Parcel();

    private int id;
    private Harvest harvest;
    private Location location;
    private Polygon geometry;

    /**
     * Generate a new parcel without any parameters (non displayed parcel)
     */
    public Parcel() {
        this.harvest = Harvest.UNKNOWN;
        this.location = new Location(0, 0);
        this.geometry = null;
    }

    public int getId() {
        return id;
    }

    public Harvest getHarvest() {
        return harvest;
    }

    public Location getLocation() {
        return location;
    }

    public Polygon getGeometry() {
        return geometry;
    }

    public boolean isIncomplete() {
        return this.equals(incomplete);
    }
}
