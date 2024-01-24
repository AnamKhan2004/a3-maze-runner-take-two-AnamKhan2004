package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.module.Configuration;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        String inputFile = null;
        String givenPath = null;

        boolean checkPath = false;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-i")) {
                if (i + 1 < args.length) {
                    inputFile = args[i + 1];
                }
            } else if (args[i].equals("-p")) {
                checkPath = true;
                if (i + 1 < args.length) {
                    givenPath = args[i + 1];
                }
            }
        }

        Maze maze = null;
        try {
            logger.info("**** Reading the maze from file " + inputFile);
            maze = new Maze(inputFile);

            if (checkPath){
                logger.info("**** Checking path");
                logger.info("Given Path: " + givenPath);
                logger.info("PATH CHECKED");
                logger.info("Path is valid = " + maze.checkedPath);
                logger.info("** End of MazeRunner");
            }
            else {
                logger.info("**** Computing path");
                logger.info("PATH COMPUTED");
                logger.info("Path = " + maze.generatedPath);
                logger.info("** End of MazeRunner");
            }
        } catch (Exception e) {
            logger.error("/!\\ An error has occured /!\\");
            System.exit(1);
        }
    }
}
