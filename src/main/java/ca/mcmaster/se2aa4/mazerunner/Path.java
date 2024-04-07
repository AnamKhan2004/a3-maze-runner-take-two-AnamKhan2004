package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Path {

    private String canonicalPath;
    private String factorizedPath;

    public Path(String path) {
        this.canonicalPath = path;
        this.factorizedPath = convertToFactorized(path);
    }

    // checks path by checking if each move is valid and checking if the final position is equal to the exit
    public boolean checkPath(Maze maze){
        if (canonicalPath.equals("empty")){
            return false;
        }
        Position entry = maze.getEntry();
        Position exit = maze.getExit();
        Position pos = entry;
        char givenChar;
        Direction direction = Direction.EAST;

        for (int i=0; i<canonicalPath.length(); i++){
            givenChar = canonicalPath.charAt(i);
            if (String.valueOf(givenChar).equals("F")){
                if (maze.isValidMove(pos, pos.nextPos(direction, String.valueOf(givenChar)))){
                    pos = pos.nextPos(direction, "F");
                }
            }else if (String.valueOf(givenChar).equals("R")){
                direction = direction.lookRight();
            }else if (String.valueOf(givenChar).equals("L")){
                direction = direction.lookLeft();
            }
        }
        return (pos.equals(exit));
    }

    // converts the canonical form of the path to factorized form
    private String convertToFactorized(String canonical){
        StringBuilder factorized = new StringBuilder();

        char currentChar = canonical.charAt(0);
        int count = 1;

        for (int i = 1; i < canonical.length(); i++) {
            char nextChar = canonical.charAt(i);

            if (nextChar == currentChar) {
                count++;
            } else {
                factorized.append(count).append(currentChar);
                currentChar = nextChar;
                count = 1;
            }
        }
        factorized.append(count).append(currentChar);
        return factorized.toString();
    }

    public String getCanonicalPath() {
        return canonicalPath;
    }

    public String getFactorizedPath() {
        return factorizedPath;
    }
}
