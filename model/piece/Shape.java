package model.piece;

import model.location.Location;

import java.awt.*;
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
}
