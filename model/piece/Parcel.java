package model.piece;

import model.location.Location;
import view.Scale;

import java.awt.*;

/**
 * @author Jean-Christophe Isoard
 */
public class Parcel {
    private int id;
    private Harvest harvest;
    private Location location;
    private Shape shape;

    /**
     * Generate a new parcel without any parameters (non displayed parcel)
     * Note that using this builder is not recommended
     */
    public Parcel() {
        this(0, Harvest.UNKNOWN, new Location(), new Shape());
    }

    /**
     * Generate a parcel with required parameters to be usable
     *
     * @param id       Identifier of the parcel as stored in the bdd
     * @param harvest  The harvest registered for this parcel
     * @param location The upper-left position of the corner of the most little square that can contain the parcel
     * @param shape    The shape of the parcel (the points that define the parcel)
     */
    public Parcel(int id, Harvest harvest, Location location, Shape shape) {
        this.id = id;
        this.harvest = harvest;
        this.location = location;
        this.shape = shape;
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

    public Polygon getGeometry(Scale scale) {
        return shape.getGeometry(scale);
    }

    @Override
    public String toString() {
        return "Parcel: " + id + " " + location + " " + shape + " " + harvest;
    }
}
