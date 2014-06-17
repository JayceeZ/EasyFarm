package model.location;

/**
 * This class is about manipulating Earth coordinates
 * @author Jean-Christophe Isoard
 */
public class Location {
    private int latitude;
    private int longitude;

    public Location(int latitude, int longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "["+latitude+","+longitude+"]";
    }
}
