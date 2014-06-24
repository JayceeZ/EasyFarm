package control;

import model.location.Cardinal;
import model.location.Coordinate;
import model.location.Location;
import model.piece.Harvest;
import model.piece.Parcel;
import model.piece.Shape;
import org.postgresql.geometric.PGpolygon;

import java.util.List;
import java.util.Map;

/**
 * @author Jean-Christophe Isoard
 */
public class LoadMap {
    /**
     * Load the parcels in the model Map restricted to the area given with the two location given in parameters
     *
     * @param map        the map which we want to add the parcels
     * @param upperLeft  the upper-left corner of the map displayed
     * @param lowerRight the lower-right corner of the map displayed
     */
    public static void loadPieceOfMap(model.Map map, Location upperLeft, Location lowerRight) {
        //TODO EAS-4 load from database using the 2 parameters
        //TODO Load the location correctly
        List<Map<String, Object>> result = BDDConnect.getResult("SELECT * FROM parcels");

        for (Map<String, Object> item : result) {
            int id = (int) item.get("id");
            Harvest harvest = Harvest.valueOf((String) item.get("harvest"));
            Coordinate latitude = new Coordinate((int) item.get("latitudeInt"), (int) item.get("latitudeDec"), Cardinal.NORTH);
            Coordinate longitude = new Coordinate((int) item.get("longitudeInt"), (int) item.get("longitudeDec"), Cardinal.EAST);
            Location location = new Location(latitude, longitude);
            Shape geometry = Shape.pgConstruct((PGpolygon) item.get("geometryInt"), (PGpolygon) item.get("geometryDec"));
            Parcel parcel = new Parcel(id, harvest, location, geometry);
            map.addParcel(parcel);
        }

    }
}
