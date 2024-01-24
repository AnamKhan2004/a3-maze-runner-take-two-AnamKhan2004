package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Maze {
    private static final Logger logger = LogManager.getLogger();

    public String generatedPath;
    public boolean checkedPath;

    public Maze(String inputFile) throws IOException {
        int[][] mazeArr = readMaze(inputFile);
        Path path = new Path(mazeArr);
        this.generatedPath = path.generatedPath;
        this.checkedPath = path.checkedPath;
    }

    private static int[][] readMaze(String inputFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String line;
        while ((line = reader.readLine()) != null) {
            for (int idx = 0; idx < line.length(); idx++) {
                if (line.charAt(idx) == '#') {
                    System.out.println("WALL ");
                } else if (line.charAt(idx) == ' ') {
                    System.out.println("PASS ");
                }
            }
            logger.info(System.lineSeparator());
        }

        return new int[][]{{1,0},{1,0}};
    }
}
