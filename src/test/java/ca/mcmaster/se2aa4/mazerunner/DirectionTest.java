package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DirectionTest {
    @Test
    public void testLookRight() {
        assertEquals(Direction.EAST, Direction.NORTH.lookRight());
        assertEquals(Direction.SOUTH, Direction.EAST.lookRight());
        assertEquals(Direction.WEST, Direction.SOUTH.lookRight());
        assertEquals(Direction.NORTH, Direction.WEST.lookRight());
    }

    @Test
    public void testLookLeft() {
        assertEquals(Direction.WEST, Direction.NORTH.lookLeft());
        assertEquals(Direction.SOUTH, Direction.WEST.lookLeft());
        assertEquals(Direction.EAST, Direction.SOUTH.lookLeft());
        assertEquals(Direction.NORTH, Direction.EAST.lookLeft());
    }
}
