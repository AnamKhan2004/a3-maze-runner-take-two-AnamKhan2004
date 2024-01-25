package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Maze {
    private static final Logger logger = LogManager.getLogger();

    public String generatedPath;
    public boolean checkedPath;

    public Maze(String inputFile) throws IOException {
        ArrayList<ArrayList<Integer>> mazeArr = readMaze(inputFile);
        Path path = new Path(mazeArr);
        this.generatedPath = path.generatedPath;
        this.checkedPath = path.checkedPath;
    }

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
}
