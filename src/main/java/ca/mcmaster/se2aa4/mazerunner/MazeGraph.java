package ca.mcmaster.se2aa4.mazerunner;

import java.util.*;

public class MazeGraph {

    private LinkedList<Integer>[] adj; // Adjacency list

    private int rows;
    private int cols;
    private int entry;
    private int exit;

    MazeGraph(Maze maze, List<List<Integer>> mazeArr) {
        this.rows = maze.getSizeY();
        this.cols = maze.getSizeX();
        this.entry = maze.getEntry().getY() * cols + maze.getEntry().getX();
        this.exit = maze.getExit().getY() * cols + maze.getExit().getX();
        this.adj = createAdjList(mazeArr);
    }

    // creating an adjacency list representation of the maze as a graph
    private LinkedList<Integer>[] createAdjList(List<List<Integer>> mazeArr) {
        int v = rows * cols;
        LinkedList<Integer>[] adjList = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adjList[i] = new LinkedList();
        }
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (mazeArr.get(i).get(j) == 0) {
                    int currentNode = i * cols + j;
                    if (isValidVertex(i + 1, j, mazeArr)) {
                        int neighborNode = (i + 1) * cols + j;
                        adjList[currentNode].add(neighborNode);
                    }
                    if (isValidVertex(i - 1, j, mazeArr)) {
                        int neighborNode = (i - 1) * cols + j;
                        adjList[currentNode].add(neighborNode);
                    }
                    if (isValidVertex(i, j + 1, mazeArr)) {
                        int neighborNode = i * cols + (j + 1);
                        adjList[currentNode].add(neighborNode);
                    }
                    if (isValidVertex(i, j - 1, mazeArr)) {
                        int neighborNode = i * cols + (j - 1);
                        adjList[currentNode].add(neighborNode);
                    }
                }
            }
        }
        return adjList;
    }

    // checking if vertexes are valid by ensuring they are ' ' and are within the maze
    private boolean isValidVertex(int x, int y, List<List<Integer>> mazeArr) {
        return (isValid(x, y) && mazeArr.get(x).get(y) == 0);
    }

    private boolean isValid(int row, int col) {
        return (row >= 0) && (row < rows) && (col >= 0) && (col < cols);
    }

    // getters
    public int getEntry() {
        return entry;
    }

    public int getExit() {
        return exit;
    }

    public int getLength() {
        return adj.length;
    }

    public LinkedList<Integer> get(int index) {
        return adj[index];
    }

    public int getCols() {
        return cols;
    }
}

