package control;

import model.Map;
import model.location.Location;
import model.piece.Parcel;

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
        LoadMap.loadPieceOfMap(map, Location.zero, Location.zero);
    }

    /**
     * This method load the missing parcels in the map when using the top-left corner point given
     * @param point The top-left corner point to use (origin of the map)
     */
    public void update(Location point) {
        //TODO EAS-4 update should ask for a predetermined bunch of parcels, depends on the loadPieceOfMap method
        map.setOrigine(point);
        LoadMap.loadPieceOfMap(map, Location.zero, Location.zero);
    }

    public static void mouseClic(Point mouseLocation) {
        //TODO what to do onclick on the map

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
    public Collection<Polygon> getAllGeometries() {
        Collection<Polygon> geometries = new ArrayList<>();
        for(Parcel parcel:map.getParcelList()) {
            geometries.add(parcel.getGeometry());
        }
        return geometries;
    }
}
