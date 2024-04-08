package ca.mcmaster.se2aa4.mazerunner;

public class RightHandSolver implements MazeSolver {

    // generates path by identifying entry and exit, turning right wherever possible, if not, going straight, otherwise going left. Whenever it finds a dead end, it turns left until it turns around. Thus following the right hand rule
    // at every turn and move, it updates position, direction, and appends the string builder 'path'
    @Override
    public Path solve(Maze maze) {
        Position entry = maze.getEntry();
        Position exit = maze.getExit();

        Path path = new Path();

        Position pos = entry;
        Direction direction = Direction.EAST;

        while (!pos.equals(exit)) {
            if (maze.isValidMove(pos, pos.turnR(direction))) {
                direction = direction.lookRight();
                path.add("R");
                pos = pos.moveFwd(direction);
                path.add("F");
            } else if (maze.isValidMove(pos, pos.moveFwd(direction))) {
                pos = pos.moveFwd(direction);
                path.add("F");
            } else if (maze.isValidMove(pos, pos.turnL(direction))) {
                direction = direction.lookLeft();
                path.add("L");
                pos = pos.moveFwd(direction);
                path.add("F");
            } else {
                direction = direction.lookLeft();
                path.add("L");
            }
        }
        return path;
    }
}
