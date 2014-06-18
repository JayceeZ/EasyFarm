package model.location;

/**
 * @author Jean-Christophe Isoard
 */
public class Coordinate {
    private int degreesIntegerPart;
    private int degreesDecimalPart;
    private Cardinal cardinal;

    /**
     * Create a coordinate using degrees definition
     *
     * @param degreesIntegerPart The integer part of the value
     * @param degreesDecimalPart The decimal part of the value
     */
    public Coordinate(int degreesIntegerPart, int degreesDecimalPart, Cardinal cardinal) {
        this.degreesIntegerPart = degreesIntegerPart;
        this.degreesDecimalPart = degreesDecimalPart;
        this.cardinal = cardinal;
    }

    /**
     * Used to get the integer part of the coordinate in degrees
     *
     * @return The value in degrees corresponding to the coordinate
     */
    public int getDegreesIntegerPart() {
        return degreesIntegerPart;
    }

    /**
     * Used to get the decimal part of the coordinate in degrees
     *
     * @return The value in degrees corresponding to the coordinate
     */
    public int getDegreesDecimalPart() {
        return degreesDecimalPart;
    }

    @Override
    public String toString() {
        return degreesIntegerPart + "." + degreesDecimalPart + "°" + cardinal.getShort();
    }
}
