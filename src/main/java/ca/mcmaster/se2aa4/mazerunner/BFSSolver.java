package ca.mcmaster.se2aa4.mazerunner;

import java.util.*;

public class BFSSolver implements MazeSolver{

    // solves maze using maze graph from maze and using bfs
    @Override
    public Path solve(Maze maze){
        MazeGraph mazeGraph = maze.getMazeGraph();
        List<Integer> pathNodes = breadthFirstSearch(mazeGraph);
        return constructPath(pathNodes, mazeGraph);
    }

    // breadth first search that gives list of nodes as path
    private List<Integer> breadthFirstSearch(MazeGraph mazeGraph) {
        int entry = mazeGraph.getEntry();
        int exit = mazeGraph.getExit();

        boolean[] visited = new boolean[mazeGraph.getLength()];
        Arrays.fill(visited, false);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(entry);
        visited[entry] = true;

        int[] parent = new int[mazeGraph.getLength()];
        Arrays.fill(parent, -1);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == exit) {
                return constructPathNodes(parent, exit);
            }

            for (int neighbor : mazeGraph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    parent[neighbor] = current;
                }
            }
        }
        return null;
    }

    // constructs path for bfs
    private List<Integer> constructPathNodes(int[] parent, int exit) {
        List<Integer> path = new ArrayList<>();
        for (int at = exit; at != -1; at = parent[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    // constructs path from bfs using list of nodes
    private Path constructPath(List<Integer> pathNodes, MazeGraph mazeGraph) {
        Direction direction = Direction.EAST;
        Path path = new Path();
        int cols = mazeGraph.getCols();
        Integer prevNode = pathNodes.get(0);

        for (Integer node: pathNodes){
            if (nodeF(prevNode, node, direction, cols)) {
                path.add("F");
            }
            else if (nodeR(prevNode, node, direction, cols)) {
                direction = direction.lookRight();
                path.add("RF");
            }
            else if (nodeL(prevNode, node, direction, cols)) {
                direction = direction.lookLeft();
                path.add("LF");
            }
            prevNode = node;
        }
        return path;
    }

    // these methods check if a node is forward, to the left, or to the right of the current node
    private boolean nodeF(Integer prevNode, Integer node, Direction direction, int cols) {
        switch (direction){
            case EAST -> {
                return (node == prevNode + 1);
            }
            case WEST -> {
                return (node == prevNode - 1);
            }
            case SOUTH -> {
                return (node == prevNode + cols);
            }
            case NORTH -> {
                return (node == prevNode - cols);
            }
        }
        return false;
    }

    private boolean nodeR(Integer prevNode, Integer node, Direction direction, int cols) {
        switch (direction){
            case EAST -> {
                return (node == prevNode + cols);
            }
            case WEST -> {
                return (node == prevNode - cols);
            }
            case SOUTH -> {
                return (node == prevNode - 1);
            }
            case NORTH -> {
                return (node == prevNode + 1);
            }
        }
        return false;
    }

    private boolean nodeL(Integer prevNode, Integer node, Direction direction, int cols) {
        switch (direction){
            case EAST -> {
                return (node == prevNode - cols);
            }
            case WEST -> {
                return (node == prevNode + cols);
            }
            case SOUTH -> {
                return (node == prevNode + 1);
            }
            case NORTH -> {
                return (node == prevNode - 1);
            }
        }
        return false;
    }
}
