package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Maze {

    private Position entry;
    private Position exit;
    private List<List<Integer>> mazeArr;

    public Maze(String inputFile) throws IOException {
        this.mazeArr = readMaze(inputFile);
        this.entry = findEntry();
        this.exit = findExit();
    }

    // reading maze from file and saving it into an array, 0 meaning white space, 1 meaning wall
    private static List<List<Integer>> readMaze(String inputFile) throws IOException {
        List<List<Integer>> mazeList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String line;
        while ((line = reader.readLine()) != null) {
            List<Integer> row = new ArrayList<>();
            for (int idx = 0; idx < line.length(); idx++) {
                if (line.charAt(idx) == '#') {
                    row.add(1);
                } else if (line.charAt(idx) == ' ') {
                    row.add(0);
                }
            }
            if (!mazeList.isEmpty()){
                while (row.size() < mazeList.get(0).size()){
                    row.add(0);
                }
            }
            mazeList.add(row);
        }
        return mazeList;
    }

    private Position findEntry() {
        int numRows = mazeArr.size();

        int entryX = 0;
        int entryY = 0;
        for (int i = 0; i < numRows; i++) {
            if (mazeArr.get(i).get(0) == 0) {
                entryY = i;
                break;
            }
        }
        return new Position(entryX, entryY);
    }

    private Position findExit() {
        int numRows = mazeArr.size();
        int numCols = mazeArr.get(0).size();

        int exitX = numCols - 1;
        int exitY = 0;
        for (int i = 0; i < numRows; i++) {
            if ((mazeArr.get(i).get(numCols - 1)) == 0) {
                exitY = i;
                break;
            }
        }
        return new Position(exitX, exitY);
    }

    // checking if the move is valid by checking if it is within the maze, adjacent to the current position, and not a wall
    public boolean isValidMove(Position pos, Position nextPos){
        if (inMaze(nextPos)){
            if (!isWall(nextPos)){
                    return true;
            }
        }
        return false;
    }

    public boolean isWall (Position pos) {
        if (mazeArr.get(pos.getY()).get(pos.getX()) == 0) {
            return false;
        }
        return true;
    }

    public boolean inMaze(Position pos) {
        return 0 <= pos.getX() && pos.getX() < getSizeX() && 0 <= pos.getY() && pos.getY() < getSizeY();
    }

    private int getSizeX () {
        return mazeArr.getFirst().size();
    }

    private int getSizeY () {
        return mazeArr.size();
    }

    public Position getEntry() {
        return entry;
    }

    public Position getExit(){
        return exit;
    }
}
