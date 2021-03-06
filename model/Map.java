package model;

import model.piece.Parcel;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a map for the application use only
 * <br />The map contains all the parcels loaded for use
 * @author Jean-Christophe Isoard
 */
public class Map {
    private List<Parcel> parcelList;

    /**
     * Generate an empty map
     */
    public Map() {
        parcelList = new LinkedList<Parcel>();
    }

    public List<Parcel> getParcelList() {
        return parcelList;
    }
}
