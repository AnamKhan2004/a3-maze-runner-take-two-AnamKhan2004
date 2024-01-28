package ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;

public interface GeneratePath {
    String generatedCanonicalPath();
    String generatedFactorizedPath();
    boolean checkedPath();
    String generatePath(ArrayList<ArrayList<Integer>> mazeArray);
    boolean checkPath(ArrayList<ArrayList<Integer>> mazeArray, String givenPath);
    String convertToFactorized(String generatedPath);
}
