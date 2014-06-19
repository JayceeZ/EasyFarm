package view;

/**
 * @author Jean-Christophe Isoard
 */
public enum Scale {
    REALSIZE(1), BIGZOOM(14), NORMALZOOM(10), TINYZOOM(6);

    private int reduce;

    private Scale(int reduce) {
        this.reduce = reduce;
    }

    public int getReduce() {
        return reduce;
    }
}
