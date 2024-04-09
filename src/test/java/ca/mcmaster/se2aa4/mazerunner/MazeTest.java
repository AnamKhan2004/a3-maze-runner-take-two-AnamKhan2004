package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MazeTest {

    private Maze maze;

    @BeforeEach
    public void setUp() throws IOException {
        this.maze = new Maze("examples/straight.maz.txt");
    }

    @Test
    public void testCheckPath() throws IOException {
        assertTrue(maze.checkPath(new Path("FFFF")));

        Maze directMaze = new Maze("examples/direct.maz.txt");
        assertTrue(directMaze.checkPath(new Path("FRFFLFFFRFLFRFLFF")));

        Maze largeMaze = new Maze("examples/large.maz.txt");
        assertTrue(largeMaze.checkPath(new Path("FFFFFFFFFFFFFFFRFFLFFFFFFFFRFFLFFFFRFFLFFFFRFFFFLFFFFFFRFFLFFRFFLFFRFFLFFRFFLFFRFFLFFRFFFFFFLFFLFFRF")));

        Maze mediumMaze = new Maze("examples/medium.maz.txt");
        assertTrue(mediumMaze.checkPath(new Path("FLFFRFFLFFFFFFFFFFFFFFFFFFLFFRFFRFFFFFFFFRFFLFFFFFFRFFFFFFFFFFLFFFFRFFFFFFFFFFLFFFFFFFFFFRFFFFLF")));

        Maze rectangleMaze = new Maze("examples/rectangle.maz.txt");
        assertTrue(rectangleMaze.checkPath(new Path("FLFFFFFFFFFFFRFFRFFFFLFFFFFFFFLFFRFFFFLFFRFFFFFFFFFFRFFFFLFFFFFFRFFLFFFFRFFFFLFFFFFFFFFFLFFRFFFFRFLF")));

        Maze smallMaze = new Maze("examples/small.maz.txt");
        assertTrue(smallMaze.checkPath(new Path("FLFRFFLFFFFFFRFFFFRFFLFFRFFLF")));

        Maze tinyMaze = new Maze("examples/tiny.maz.txt");
        assertTrue(tinyMaze.checkPath(new Path("FFFLFFFFRFFF")));
    }

    @Test
    public void testIsValidMove() {
        assertTrue(maze.isValidMove(new Position(1, 2)));
        assertFalse(maze.isValidMove(new Position(0, 1)));
        assertFalse(maze.isValidMove(new Position(5, 2)));
    }

    @Test
    public void testGetSizeX () {
        assertEquals(5, maze.getSizeX());
    }

    @Test
    public void testGetSizeY () {
        assertEquals(5, maze.getSizeY());
    }

    @Test
    public void testGetEntry() {
        assertEquals(new Position(0, 2).toString(), maze.getEntry().toString());
    }

    @Test
    public void testGetExit() {
        assertEquals(new Position(4, 2).toString(), maze.getExit().toString());
    }
}
