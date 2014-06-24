package model.location;

/**
 * @author Jean-Christophe Isoard
 */
public enum Cardinal {
    NORTH, EAST, SOUTH, WEST;

    /**
     * Return the first letter of the cardinal
     *
     * @return The first letter of the cardinal
     */
    public char getShort() {
        return this.name().charAt(0);
    }
}
