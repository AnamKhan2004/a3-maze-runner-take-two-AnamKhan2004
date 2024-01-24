package ca.mcmaster.se2aa4.mazerunner;

public class Path {

    public String generatedPath;
    public boolean checkedPath;

    public Path(int[][] mazeArr) {
        this.generatedPath = generatePath(mazeArr);
        this.checkedPath = checkPath(mazeArr);
    }

    private static String generatePath(int[][] mazeArray){
        return "FFLLRR";
    }

    private static boolean checkPath(int[][] mazeArray){
        return true;
    }
}
