package model.piece;

import model.location.Location;

/**
 * @author Jean-Christophe Isoard
 */
public class Parcel {
    private Harvest harvest;
    private Location location;

    public Parcel(Harvest harvest) {
        this.harvest = harvest;
    }
}
