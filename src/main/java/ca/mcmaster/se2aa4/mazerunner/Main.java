package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        CommandLineParser parser = new DefaultParser();

        CommandLine cmd = null;
        try {
            cmd = parser.parse(getParserOptions(), args);
            String filePath = cmd.getOptionValue('i');

            if (cmd.getOptionValue("baseline") != null) {
                double startTimeLoadMaze = System.currentTimeMillis();
                Maze maze = new Maze(filePath);
                double endTimeLoadMaze = System.currentTimeMillis();
                double elapsedTimeLoadMaze = endTimeLoadMaze - startTimeLoadMaze;

                System.out.printf("Time spent loading maze from file (in ms): %.2f\n", elapsedTimeLoadMaze);

                String method = cmd.getOptionValue("method", "bfs");
                double startTimeExploreMazeMethod = System.currentTimeMillis();
                Path pathMethod = solveMaze(method, maze);
                double endTimeExploreMazeMethod = System.currentTimeMillis();
                double elapsedTimeExploreMazeMethod = endTimeExploreMazeMethod - startTimeExploreMazeMethod;

                System.out.printf("Time spent exploring the maze using the provided -method (in ms): %.2f\n", elapsedTimeExploreMazeMethod);

                String baseline = cmd.getOptionValue("baseline", "bfs");
                double startTimeExploreMazeBaseline = System.currentTimeMillis();
                Path pathBaseline = solveMaze(baseline, maze);
                double endTimeExploreMazeBaseline = System.currentTimeMillis();
                double elapsedTimeExploreMazeBaseline = endTimeExploreMazeBaseline - startTimeExploreMazeBaseline;

                System.out.printf("Time spent exploring the maze using the provided -baseline (in ms): %.2f\n", elapsedTimeExploreMazeBaseline);

                double speedUp = (double) pathBaseline.getCanonicalPath().length() / pathMethod.getCanonicalPath().length();

                System.out.printf("Improvement on the path as a speedup: %.1f\n", speedUp);
            }
            else {
                Maze maze = new Maze(filePath);
                if (cmd.getOptionValue("p") != null) {
                    logger.info("Validating path");
                    Path path = new Path(cmd.getOptionValue("p"));
                    if (maze.checkPath(path)) {
                        System.out.println("correct path");
                    } else {
                        System.out.println("incorrect path");
                    }
                } else {
                    String method = cmd.getOptionValue("method", "righthand");
                    Path path = solveMaze(method, maze);
                    System.out.println(path.getCanonicalPath());
                }
            }
        } catch (Exception e) {
            System.err.println("MazeSolver failed.  Reason: " + e.getMessage());
            logger.error("MazeSolver failed.  Reason: " + e.getMessage());
            logger.error("PATH NOT COMPUTED");
        }

        logger.info("End of MazeRunner");
    }

    /**
     * Solve provided maze with specified method.
     *
     * @param method Method to solve maze with
     * @param maze Maze to solve
     * @return Maze solution path
     * @throws Exception If provided method does not exist
     */
    private static Path solveMaze(String method, Maze maze) throws Exception {
        MazeSolver solver = null;
        switch (method) {
            case "righthand" -> {
                logger.debug("RightHand algorithm chosen.");
                solver = new RightHandSolver();
            }
            case "bfs" -> {
                logger.debug("Breadth First Search algorithm chosen.");
                solver = new BFSSolver();
            }
            default -> {
                throw new Exception("Maze solving method '" + method + "' not supported.");
            }
        }

        logger.info("Computing path");
        return solver.solve(maze);
    }

    /**
     * Get options for CLI parser.
     *
     * @return CLI parser options
     */
    private static Options getParserOptions() {
        Options options = new Options();

        Option fileOption = new Option("i", true, "File that contains maze");
        fileOption.setRequired(true);
        options.addOption(fileOption);

        options.addOption(new Option("p", true, "Path to be verified in maze"));
        options.addOption(new Option("method", true, "Specify which path computation algorithm will be used"));
        options.addOption(new Option("baseline", true, "Comparison baseline"));

        return options;
    }
}
