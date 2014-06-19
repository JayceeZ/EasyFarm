package model;

import model.location.Location;
import model.piece.Parcel;
import view.Scale;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a map for the application use only
 * <br />The map contains all the parcels loaded for use
 *
 * @author Jean-Christophe Isoard
 */
public class Map {
    private List<Parcel> parcelList;
    private Location origin;

    /**
     * Generate an empty map
     */
    public Map() {
        parcelList = new LinkedList<>();
        origin = new Location();
    }

    public List<Parcel> getParcelList() {
        return parcelList;
    }

    public void addParcel(Parcel parcel) {
        if (!parcelList.contains(parcel)) {
            parcelList.add(parcel);
        }
    }

    public boolean removeParcel(Parcel parcel) {
        if (!parcelList.contains(parcel)) {
            return false;
        }
        parcelList.remove(parcel);
        return true;
    }

    @Override
    public String toString() {
        return "Map content: " + parcelList.toString();
    }

    /**
     * Return the parcel with the given id (if it exists) or return null
     *
     * @param parcelId The id of the parcel we asked for
     * @return the asked parcel object, or null if not found
     */
    public Parcel getParcel(int parcelId) {
        for (Parcel parcel : parcelList) {
            if (Integer.compare(parcel.getId(), parcelId) == 0) {
                return parcel;
            }
        }
        return null;
    }

    /**
     * Move the origin of the map using the (dx, dy) point given
     * <br />Sign depends on cartesian move
     *
     * @param dx The number of pixels the x-axis as changed
     * @param dy The number of pixels the y-axis as changed
     */
    public void moveOrigin(int dx, int dy) {
        //TODO move the origin using the value of (dx, dy)

    }
}
