package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Maze {

    private Position entry;
    private Position exit;
    private ArrayList<ArrayList<Integer>> mazeArr;

    public Maze(String inputFile) throws IOException {
        this.mazeArr = readMaze(inputFile);
        this.entry = findEntry();
        this.exit = findExit();
    }

    // reading maze from file and saving it into an array, 0 meaning white space, 1 meaning wall
    private static ArrayList<ArrayList<Integer>> readMaze(String inputFile) throws IOException {
        ArrayList<ArrayList<Integer>> mazeList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String line;
        while ((line = reader.readLine()) != null) {
            ArrayList<Integer> row = new ArrayList<>();
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

    public Position getEntry() {
        return entry;
    }

    public Position getExit(){
        return exit;
    }

    // checking if the move is valid by checking if it is within the maze, adjacent to the current position, and not a wall
    public boolean isValidMove(Position pos, Position nextPos){
        if ((0 <= nextPos.getX()) && (nextPos.getX() < (mazeArr.get(0)).size()) && (0 <= nextPos.getY()) && (nextPos.getY() < mazeArr.size())){
            if (((nextPos.getX() == pos.getX()) && (nextPos.getY() == pos.getY()+1)) || ((nextPos.getX() == pos.getX()) && (nextPos.getY() == pos.getY()-1)) || ((nextPos.getY() == pos.getY()) && (nextPos.getX() == pos.getX()+1)) || ((nextPos.getY() == pos.getY()) && (nextPos.getX() == pos.getX()-1))){
                if (((mazeArr.get(nextPos.getY())).get(nextPos.getX())) == 0){
                    return true;
                }
            }
        }
        return false;
    }
}
