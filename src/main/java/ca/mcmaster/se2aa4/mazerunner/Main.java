package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

import java.util.Objects;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        String inputFile;
        String givenPath;

        boolean checkPath = false;

        try {
            Options options = new Options();
            options.addOption("i", true, "input file");
            options.addOption("p", true, "given path");
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);
            inputFile = cmd.getOptionValue("i",null);
            givenPath = cmd.getOptionValue("p","empty");

            if(!Objects.equals(givenPath, "empty")){
                checkPath = true;
            }

            logger.info("**** Reading the maze from file " + inputFile);
            Maze maze = new Maze(inputFile);

            if (checkPath){
                Path path = new Path(givenPath);
                logger.info("**** Checking canonical path from East to West");
                logger.info("Given Path: " + givenPath);
                logger.info("PATH CHECKED");
                if (path.checkPath(maze)){
                    System.out.println("Path is valid");
                }else{
                    System.out.println("Path is invalid");
                }
                logger.info("** End of MazeRunner");
            }
            else {
                MazeSolver mazeSolver = new RightHandSolver();
                Path generatedPath = mazeSolver.solve(maze);
                logger.info("**** Computing path from East to West");
                logger.info("PATH COMPUTED");
                System.out.println("Canonical Path = " + generatedPath.getCanonicalPath());
                System.out.println("Factorized Path = " + generatedPath.getFactorizedPath());
                logger.info("** End of MazeRunner");
            }
        } catch (Exception e) {
            logger.error("An error has occurred");
            System.exit(1);
        }
    }
}
