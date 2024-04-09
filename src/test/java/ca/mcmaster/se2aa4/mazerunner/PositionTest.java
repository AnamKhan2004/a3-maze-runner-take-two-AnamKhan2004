package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    private Position pos;

    @BeforeEach
    public void setUp() {
        this.pos = new Position(15, 15);
    }

    @Test
    public void testGetX() {
        assertEquals(15, pos.getX());
    }

    @Test
    public void testGetY() {
        assertEquals(15, pos.getY());
    }

    @Test
    public void testToString() {
        assertEquals("(15, 15)", pos.toString());
    }

    @Test
    public void testEquals() {
        Position equalPos = new Position(15, 15);
        assertTrue(pos.equals(equalPos));
        Position notEqualPos = new Position(13, 15);
        assertFalse(pos.equals(notEqualPos));
    }

    @Test
    public void testMoveFwd() {
        Position newPosN = pos.moveFwd(Direction.NORTH);
        assertEquals(15, newPosN.getX());
        assertEquals(14, newPosN.getY());

        Position newPosS = pos.moveFwd(Direction.SOUTH);
        assertEquals(15, newPosS.getX());
        assertEquals(16, newPosS.getY());

        Position newPosE = pos.moveFwd(Direction.EAST);
        assertEquals(16, newPosE.getX());
        assertEquals(15, newPosE.getY());

        Position newPosW = pos.moveFwd(Direction.WEST);
        assertEquals(14, newPosW.getX());
        assertEquals(15, newPosW.getY());
    }

    @Test
    public void testTurnL() {
        Position newPosN = pos.turnL(Direction.NORTH);
        assertEquals(14, newPosN.getX());
        assertEquals(15, newPosN.getY());

        Position newPosS = pos.turnL(Direction.SOUTH);
        assertEquals(16, newPosS.getX());
        assertEquals(15, newPosS.getY());

        Position newPosE = pos.turnL(Direction.EAST);
        assertEquals(15, newPosE.getX());
        assertEquals(14, newPosE.getY());

        Position newPosW = pos.turnL(Direction.WEST);
        assertEquals(15, newPosW.getX());
        assertEquals(16, newPosW.getY());
    }

    @Test
    public void testTurnR() {
        Position newPosN = pos.turnR(Direction.NORTH);
        assertEquals(16, newPosN.getX());
        assertEquals(15, newPosN.getY());

        Position newPosS = pos.turnR(Direction.SOUTH);
        assertEquals(14, newPosS.getX());
        assertEquals(15, newPosS.getY());

        Position newPosE = pos.turnR(Direction.EAST);
        assertEquals(15, newPosE.getX());
        assertEquals(16, newPosE.getY());

        Position newPosW = pos.turnR(Direction.WEST);
        assertEquals(15, newPosW.getX());
        assertEquals(14, newPosW.getY());
    }
}
