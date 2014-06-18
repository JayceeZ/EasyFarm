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

    public void addParcel(Parcel parcel) {
        if(!parcelList.contains(parcel)) {
            parcelList.add(parcel);
        }
    }

    public boolean removeParcel(Parcel parcel) {
        if(!parcelList.contains(parcel)) {
            return false;
        }
        parcelList.remove(parcel);
        return true;
    }

    @Override
    public String toString() {
        return "Map content: "+parcelList.toString();
    }

    /**
     * Return the parcel with the given id (if it exists) or return null
     * @param parcelId The id of the parcel we asked for
     * @return the asked parcel object, or null if not found
     */
    public Parcel getParcel(int parcelId) {
        for(Parcel parcel:parcelList) {
            if(Integer.compare(parcel.getId(), parcelId) == 0) {
                return parcel;
            }
        }
        return null;
    }
}
