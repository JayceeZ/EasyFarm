package model.piece;

import model.location.Location;

import java.awt.*;

/**
 * @author Jean-Christophe Isoard
 */
public class Parcel {
    private int id;
    private Harvest harvest;
    private Location location;
    private Polygon geometry;

    /**
     * Generate a new parcel without any parameters (non displayed parcel)
     * Note that using this builder is not recommended
     */
    public Parcel() {
        this(0, Harvest.UNKNOWN, new Location(0, 0), null);
    }

    /**
     * Generate a parcel with required parameters to be usable
     *
     * @param id       Identifier of the parcel as stored in the bdd
     * @param harvest  The harvest registered for this parcel
     * @param location The upper-left position of the corner of the most little square that can contain the parcel
     * @param geometry The polygon designating the parcel (the points that define the parcel)
     */
    public Parcel(int id, Harvest harvest, Location location, Polygon geometry) {
        this.id = id;
        this.harvest = harvest;
        this.location = location;
        this.geometry = geometry;
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
    @Override
    public String toString() {
        return id+" "+location+" "+harvest;
    }
}
