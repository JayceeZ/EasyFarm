package model.piece;

import model.location.Coordinate;
import model.location.Location;
import view.Scale;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Allow representing the shape of the parcels
 * @author Jean-Christophe Isoard
 */
public class Shape {
    private List<Location> locations;

    /**
     * Construct an empty shape
     */
    public Shape() {
        locations = new LinkedList<>();
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    /**
     * Generate the polygon geometry using the scale given as parameter
     * @return The polygon generated for painting on a panel
     */
    public Polygon getGeometry(Scale scale) {
        //TODO calculate the polygon points using the relative position of the map with is origin location
        return null;
    }

    /**
     * Create a Shape object using the list of coordinates contained in a string
     * @param locations the string defining the shape
     * @return the object shape reconstructed from the string
     */
    public static Shape construct(String locations) {
        if(locations == null)
            return null;
        for(String part:locations.split(",")) {
            Location location = new Location();
            System.out.println(part);
            //location.setLatitude(new Coordinate());
        }
        return new Shape();
    }

    @Override
    public String toString() {
        return locations.toString();
    }
}
