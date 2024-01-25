package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.Arrays;

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

        return "FFLLRR";
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
        System.out.println(Arrays.toString(entry));
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
        System.out.println(Arrays.toString(exit));
        return exit;
    }

    private static boolean checkPath(ArrayList<ArrayList<Integer>> mazeArray){
        return true;
    }
}
