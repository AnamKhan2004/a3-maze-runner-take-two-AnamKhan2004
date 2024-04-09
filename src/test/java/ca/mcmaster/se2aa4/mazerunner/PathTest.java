package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PathTest {

    private Path path;

    @BeforeEach
    public void setUp() {
        this.path = new Path("FRFFLFFFRFLFRFLFF");
    }

    @Test
    public void testGetCanonicalPath() {
        assertEquals("FRFFLFFFRFLFRFLFF", path.getCanonicalPath());
    }

    @Test
    public void testGetFactorizedPath() {
        assertEquals("1F1R2F1L3F1R1F1L1F1R1F1L2F", path.getFactorizedPath());
    }

    @Test
    public void testAdd() {
        path.add("F");
        assertEquals("FRFFLFFFRFLFRFLFFF", path.getCanonicalPath());
    }
}
