package model.location;

/**
 * This class is about manipulating Earth coordinates
 * @author Jean-Christophe Isoard
 */
public class Location {
    public static final Location zero = new Location();

    private Coordinate latitude;
    private Coordinate longitude;

    /**
     * Build a location with the initial coordinates both to zero equivalent
     */
    public Location() {
        this(new Coordinate(0,0,Cardinal.NORTH), new Coordinate(0,0,Cardinal.EAST));
    }

    public Location(Coordinate latitude, Coordinate longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Coordinate getLatitude() {
        return latitude;
    }

    public Coordinate getLongitude() {
        return longitude;
    }

    /**
     * Calculate the distance between two locations
     * @return The distance in kilometers between two points
     */
    public static int getDistance() {
        return 0;
    }

    @Override
    public String toString() {
        return "["+latitude+", "+longitude+"]";
    }
}
