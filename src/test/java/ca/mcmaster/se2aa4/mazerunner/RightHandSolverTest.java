package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class RightHandSolverTest {

    private MazeSolver rightHandSolver;

    @BeforeEach
    public void setUp() {
        this.rightHandSolver = new RightHandSolver();
    }

    @Test
    public void testSolve() throws IOException {
        Maze directMaze = new Maze("examples/direct.maz.txt");
        assertEquals("FRFFLFFFRFLFRFLFF", rightHandSolver.solve(directMaze).getCanonicalPath());

        Maze smallMaze = new Maze("examples/small.maz.txt");
        assertEquals("FRFLLFFRFFRFFLLFFFFRFFRFFFFLLFFRFFFFRFFRFFLLFFLFFLFFFFRFFRFFLLFFFFRFFRFFLLFFRFFRFFFFRFFLFFRFFLF", rightHandSolver.solve(smallMaze).getCanonicalPath());

        Maze straightMaze = new Maze("examples/straight.maz.txt");
        assertEquals("FFFF", rightHandSolver.solve(straightMaze).getCanonicalPath());

        Maze tinyMaze = new Maze("examples/tiny.maz.txt");
        assertEquals("FFFFFLLFFRFFRFFLLFFRFFRFFF", rightHandSolver.solve(tinyMaze).getCanonicalPath());
    }
}
