package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Path {

    public String generatedPath;
    public boolean checkedPath;

    public Path(ArrayList<ArrayList<Integer>> mazeArr) {
        this.generatedPath = generatePath(mazeArr);
        this.checkedPath = checkPath(mazeArr);
    }

    private static String generatePath(ArrayList<ArrayList<Integer>> mazeArray){
        int[] entry = findEntry(mazeArray);
        int[] exit = findExit(mazeArray);

        StringBuilder path = new StringBuilder();

        int[] pos = entry;
        Direction direction = Direction.EAST;

        while (!Arrays.equals(pos, exit)) {
            if (isValidMove(mazeArray, pos, nextPos(pos, direction, "R"))){
                direction = nextDir(direction, "R");
                path.append("R");
                pos = nextPos(pos, direction, "F");
                path.append("F");
            } else if (isValidMove(mazeArray, pos, nextPos(pos, direction, "F"))){
                pos = nextPos(pos, direction, "F");
                path.append("F");
            } else if (isValidMove(mazeArray, pos, nextPos(pos, direction, "L"))){
                direction = nextDir(direction, "L");
                path.append("L");
                pos = nextPos(pos, direction, "F");
                path.append("F");
            }
        }
        return path.toString();
    }

    private static int[] findEntry(ArrayList<ArrayList<Integer>> mazeArray){
        int numRows = mazeArray.size();

        int[] entry = new int[2];
        entry[0] = 0;
        for (int i = 0; i < numRows; i++) {
            if (mazeArray.get(i).get(0) == 0) {
                entry[1] = i;
                break;
            }
        }
        return entry;
    }

    private static int[] findExit(ArrayList<ArrayList<Integer>> mazeArray){
        int numRows = mazeArray.size();
        int numCols = mazeArray.get(0).size();

        int[] exit = new int[2];
        exit[0] = numCols - 1;
        for (int i = 0; i < numRows; i++) {
            if ((mazeArray.get(i).get(numCols - 1)) == 0) {
                exit[1] = i;
                break;
            }
        }
        return exit;
    }

    private static boolean isValidMove(ArrayList<ArrayList<Integer>> mazeArray, int[] pos, int[] nextPos){
        if ((0 <= nextPos[0]) && (nextPos[0] < (mazeArray.get(0)).size()) && (0 <= nextPos[1]) && (nextPos[1] < mazeArray.size())){
            if (((nextPos[0] == pos[0]) && (nextPos[1] == pos[1]+1)) || ((nextPos[0] == pos[0]) && (nextPos[1] == pos[1]-1)) || ((nextPos[1] == pos[1]) && (nextPos[0] == pos[0]+1)) || ((nextPos[1] == pos[1]) && (nextPos[0] == pos[0]-1))){
                if (((mazeArray.get(nextPos[1])).get(nextPos[0])) == 0){
                    return true;
                }
            }
        }
        return false;
    }

    private enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }

    private static int[] nextPos(int[] pos, Direction direction, String turn){
        int[] nextPos = new int[2];
        if (Objects.equals(turn, "F")) {
            if (direction == Direction.EAST) {
                nextPos[0] = pos[0] + 1;
                nextPos[1] = pos[1];
            }else if (direction == Direction.NORTH) {
                nextPos[0] = pos[0];
                nextPos[1] = pos[1] - 1;
            }else if (direction == Direction.SOUTH) {
                nextPos[0] = pos[0];
                nextPos[1] = pos[1] + 1;
            }else {
                nextPos[0] = pos[0] - 1;
                nextPos[1] = pos[1];
            }
        }else if ((Objects.equals(turn, "R"))) {
            if (direction == Direction.EAST) {
                nextPos[0] = pos[0];
                nextPos[1] = pos[1] + 1;
            }else if (direction == Direction.NORTH) {
                nextPos[0] = pos[0] + 1;
                nextPos[1] = pos[1];
            }else if (direction == Direction.SOUTH) {
                nextPos[0] = pos[0] - 1;
                nextPos[1] = pos[1];
            }else {
                nextPos[0] = pos[0];
                nextPos[1] = pos[1] - 1;
            }
        }
        else if (Objects.equals(turn, "L")){
            if (direction == Direction.EAST) {
                nextPos[0] = pos[0];
                nextPos[1] = pos[1] - 1;
            }else if (direction == Direction.NORTH) {
                nextPos[0] = pos[0] - 1;
                nextPos[1] = pos[1];
            }else if (direction == Direction.SOUTH) {
                nextPos[0] = pos[0] + 1;
                nextPos[1] = pos[1];
            }else {
                nextPos[0] = pos[0];
                nextPos[1] = pos[1] + 1;
            }
        }
        return nextPos;
    }

    private static Direction nextDir(Direction direction, String turn){
        if (direction == Direction.EAST){
            if (turn.equals("R")){
                direction = Direction.SOUTH;
            } else if (turn.equals(("L"))){
                direction = Direction.NORTH;
            }
        }
        else if (direction == Direction.NORTH){
            if (turn.equals("R")){
                direction = Direction.EAST;
            } else if (turn.equals("L")){
                direction = Direction.WEST;
            }
        }
        else if (direction == Direction.SOUTH){
            if (turn.equals("R")){
                direction = Direction.WEST;
            } else if (turn.equals("L")) {
                direction = Direction.EAST;
            }
        }else {
            if (turn.equals( "R")){
                direction = Direction.NORTH;
            } else if (turn.equals("L")){
                direction = Direction.SOUTH;
            }
        }
        return direction;
    }

    private static boolean checkPath(ArrayList<ArrayList<Integer>> mazeArray){
        return true;
    }
}
