package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MazeGraphTest {

    private MazeGraph mazeGraph;

    @BeforeEach
    public void setUp() throws IOException {
        List<List<Integer>> mazeArr = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1)), new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1)), new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0)), new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1)), new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1))));
        this.mazeGraph = new MazeGraph(new Maze("examples/straight.maz.txt"), mazeArr);
    }

    @Test
    public void testGetEntry() {
        assertEquals(10, mazeGraph.getEntry());
    }

    @Test
    public void testGetExit() {
        assertEquals(14, mazeGraph.getExit());
    }

    @Test
    public void testGetLength() {
        assertEquals(25, mazeGraph.getLength());
    }

    @Test
    public void testGet() {
        assertEquals("[11]", mazeGraph.get(10).toString());
    }

    @Test
    public void testGetCols() {
        assertEquals(5, mazeGraph.getCols());
    }


}
