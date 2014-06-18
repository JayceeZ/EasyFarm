package model.piece;

/**
 * @author Jean-Christophe Isoard
 */
public enum Scale {
    REALSIZE(1), BIGZOOM(4), NORMALZOOM(16), TINYZOOM(32);

    private int multiplicator;

    private Scale(int multiplicator) {
        this.multiplicator = multiplicator;
    }
}
