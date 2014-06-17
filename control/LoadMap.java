package control;

import model.location.Location;
import model.piece.Harvest;
import model.piece.Parcel;

import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * @author Jean-Christophe Isoard
 */
public class LoadMap {
    /**
     * Load some parcels in the model Map given in parameter
     *
     * @param map      the map which we want to add the parcels
     * @param parcelId the parcel id from where the map start loading
     * @param distance the distance of loading (kind of deep)
     */
    public static void loadPieceOfMap(model.Map map, int parcelId, int distance) {
        //TODO EAS-4 load from database using the 2 parameters
        List<Map<String, Object>> result = BDDConnect.getResult("SELECT * FROM parcels");

        for (Map<String, Object> item : result) {
            int id = (int) item.get("id");
            Harvest harvest = Harvest.valueOf((String) item.get("harvest"));
            Location location = new Location((int) item.get("latitude"), (int) item.get("longitude"));
            Polygon geometry = (Polygon) item.get("geometry");
            Parcel parcel = new Parcel(id, harvest, location, geometry);
            map.addParcel(parcel);
        }

    }
}
