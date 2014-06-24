package control;

import model.Map;
import model.location.Location;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoadMapTest {
    private Map testMap;
    private Location zero;

    @Before
    public void setUp() {
        testMap = new Map();
        zero = new Location();
    }

    @Test
    public void testLoadPieceOfMap() {
        //TODO EAS-4
        LoadMap.loadPieceOfMap(testMap, zero, zero);
        assertEquals(2,testMap.getParcelList().size());
        System.out.println(testMap);
    }
}