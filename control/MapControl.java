package control;

import model.Map;
import model.piece.Parcel;
import view.ParcelView;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Jean-Christophe Isoard
 */
public class MapControl {
    private Map map;

    public MapControl() {
        this.map = new Map();
        LoadMap.loadPieceOfMap(map, 0, 100);
    }

    public static void mouseClic() {
        //TODO what to do onclick on a parcel

    }

    /**
     * Return the geometry of the parcel associated to the id
     * <br />Need the parcel to be loaded from database
     * @see LoadMap
     * @param parcelId The id of the parcel we want
     */
    public Polygon getGeometry(int parcelId) {
        Parcel parcel = map.getParcel(parcelId);
        if(parcel == null) {
            return null;
        }
        return parcel.getGeometry();
    }

    /**
     * Return the collection of all geometry of all the parcels loaded for the map
     * @return All the geometries of parcels in a collection
     */
    public Collection<Polygon> getAllGeometry() {
        Collection<Polygon> geometries = new ArrayList<>();
        for(Parcel parcel:map.getParcelList()) {
            geometries.add(parcel.getGeometry());
        }
        return geometries;
    }
}
