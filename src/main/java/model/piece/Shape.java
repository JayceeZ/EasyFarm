package model.piece;

import model.location.Cardinal;
import model.location.Coordinate;
import model.location.Location;
import org.postgresql.geometric.PGpoint;
import org.postgresql.geometric.PGpolygon;
import view.Scale;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Allow representing the shape of the parcels
 *
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

    /**
     * Create a Shape object using the list of coordinates contained in a string
     *
     * @param locationsInt the polygon containing the integer values of the locations defining the shape
     * @param locationsDec the polygon containing the decimal values of the locations defining the shape
     * @return the object shape reconstructed from the parameters
     */
    public static Shape pgConstruct(PGpolygon locationsInt, PGpolygon locationsDec) {
        if (locationsInt == null || locationsDec == null) {
            return null;
        }
        PGpoint[] pointsInt = locationsInt.points;
        PGpoint[] pointsDec = locationsDec.points;
        if (pointsInt.length != pointsDec.length) {
            return null;
        }
        Shape shape = new Shape();
        for (int n = 0; n < pointsInt.length; n++) {
            Coordinate latitude = new Coordinate((int) pointsInt[n].x, (int) pointsDec[n].x, Cardinal.NORTH);
            Coordinate longitude = new Coordinate((int) pointsInt[n].y, (int) pointsDec[n].y, Cardinal.EAST);
            Location location = new Location(latitude, longitude);
            shape.addLocation(location);
        }
        return shape;
    }

    public static Location convertPointToLocation(Location origin, Point mouseLocation, Scale scale) {
        //TODO EAS-13: calculate the location: converting the display mouse location to the world map location
        throw new UnsupportedOperationException("See EAS-13 for details");
        //return new Location();
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    /**
     * Calculate the polygon display geometry using the scale and the map origin location given as parameter
     *
     * @param mapOrigin The location currently on top-left corner of the display
     * @param scale     The scale currently used for the map display
     * @return The polygon generated for painting on a panel
     */
    public Polygon calculateGeometry(Location mapOrigin, Scale scale) {
        Polygon polygon = new Polygon();
        for (Location location : locations) {
            Point point = convertLocationToPoint(mapOrigin, location, scale);
            polygon.addPoint((int) point.getX(), (int) point.getX());
        }
        return polygon;
    }

    private Point convertLocationToPoint(Location origin, Location location, Scale scale) {
        //TODO EAS-13: calculate the point using the relative position of the map with her origin location and the scale of display
        Coordinate locationLatitude = location.getLatitude();
        Coordinate locationLongitude = location.getLongitude();
        Coordinate originLatitude = origin.getLatitude();
        Coordinate originLongitude = origin.getLongitude();

        double lon = Double.parseDouble(locationLongitude.getDegreesIntegerPart() + "." + locationLongitude.getDegreesDecimalPart());
        double lat = Double.parseDouble(locationLatitude.getDegreesIntegerPart() + "." + locationLatitude.getDegreesDecimalPart());

        //double lonRad = Math.toRadians(lon);
        double latRad = Math.toRadians(lat);
        double n = Math.pow(2.0, scale.getReduce());

        double tileX = ((lon + 180) / 360) * n;
        double tileY = (1 - (Math.log(Math.tan(latRad) + 1.0 / Math.cos(latRad)) / Math.PI)) * n / 2.0;

        return new Point((int) tileX, (int) tileY);
    }

    @Override
    public String toString() {
        return locations.toString();
    }
}