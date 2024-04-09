package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class BFSSolverTest {

    private MazeSolver bfsSolver;

    @BeforeEach
    public void setUp() {
        this.bfsSolver = new BFSSolver();
    }

    @Test
    public void testSolve() throws IOException {
        Maze directMaze = new Maze("examples/direct.maz.txt");
        assertEquals("FRFFLFFFRFLFRFLFF", bfsSolver.solve(directMaze).getCanonicalPath());

        Maze giantMaze = new Maze("examples/giant.maz.txt");
        assertEquals("FLFFRFFLFFFFFFRFFLFFFFFFRFFRFFLFFRFFLFFRFFFFFFFFLFFFFRFFFFLFFFFFFRFFLFFFFRFFLFFRFFFFLFFFFRFFLFFFFFFFFFFFFFFFFFFRFFFFLFFFFRFFLFFRFFLFFFFRFFFFLFFRFFLFFLFFRFFFFLFFRFFFFLFFRFFFFFFFFFFLFFFFFFRFFLFFRFFFFFFLFFRFFRFFFFLFFRFFLFFFFFFFFFFFFFFRFFFFLFFFFRFFLFFRFFFFFFFFLFFFFFFFFFFRFFLFFFFRFFLFFFFFFRFFLFFFFRFFLFFFFFFLFFRFFLFFFFRFFFFF", bfsSolver.solve(giantMaze).getCanonicalPath());

        Maze hugeMaze = new Maze("examples/huge.maz.txt");
        assertEquals("FLFFFFFFFRFFLFFFFRFFFFLFFRFFFFFFRFFLFFFFFFRFFFFLFFRFFLFFFFFFFFFFLFFRFFRFFLFFFFRFFFFFFFFFFLFFRFFFFLFFFFFFRFFLFFRFFFFLFFRFFFFFFLFFRFFLFFRFFLFFRFFFFLFFFFRFFLFFFFRFFFFRFFLFFFFLFFFFRFFLFFFFFFRFFLFFRFFFFFFLFFFFRFFLFFFFRFFLFFRFFLFFRFFFFLFFFFFFRFFFFLFFFFRFFFFFFLFFFFRFLF", bfsSolver.solve(hugeMaze).getCanonicalPath());

        Maze largeMaze = new Maze("examples/large.maz.txt");
        assertEquals("FFFFFFFFFFFFFFFRFFLFFFFFFFFRFFLFFFFRFFLFFFFRFFFFLFFFFFFRFFLFFRFFLFFRFFLFFRFFLFFRFFLFFRFFFFFFLFFLFFRF", bfsSolver.solve(largeMaze).getCanonicalPath());

        Maze mediumMaze = new Maze("examples/medium.maz.txt");
        assertEquals("FLFFRFFLFFFFFFFFFFFFFFFFFFLFFRFFRFFFFFFFFRFFLFFFFFFRFFFFFFFFFFLFFFFRFFFFFFFFFFLFFFFFFFFFFRFFFFLF", bfsSolver.solve(mediumMaze).getCanonicalPath());

        Maze rectangleMaze = new Maze("examples/rectangle.maz.txt");
        assertEquals("FLFFFFFFFFFFFRFFRFFFFLFFFFFFFFLFFRFFFFLFFRFFFFFFFFFFRFFFFLFFFFFFRFFLFFFFRFFFFLFFFFFFFFFFLFFRFFFFRFLF", bfsSolver.solve(rectangleMaze).getCanonicalPath());

        Maze regularMaze = new Maze("examples/regular.maz.txt");
        assertEquals("FFFLFFLFFRFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFRFFFFFFFFFFFFFFFFRFFLFFFFRFFFFLFFRFFLFFRFFFFFFLFFRFFFFLFFRFFFFFFLFFFFRFFLFFRFFLFFFFLFFRF", bfsSolver.solve(regularMaze).getCanonicalPath());

        Maze smallMaze = new Maze("examples/small.maz.txt");
        assertEquals("FLFRFFLFFFFFFRFFFFRFFLFFRFFLF", bfsSolver.solve(smallMaze).getCanonicalPath());

        Maze straightMaze = new Maze("examples/straight.maz.txt");
        assertEquals("FFFF", bfsSolver.solve(straightMaze).getCanonicalPath());

        Maze tinyMaze = new Maze("examples/tiny.maz.txt");
        assertEquals("FFFLFFFFRFFF", bfsSolver.solve(tinyMaze).getCanonicalPath());
    }
}
