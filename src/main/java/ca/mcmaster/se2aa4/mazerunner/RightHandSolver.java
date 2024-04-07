package ca.mcmaster.se2aa4.mazerunner;

public class RightHandSolver implements MazeSolver {

    // generates path by identifying entry and exit, turning right wherever possible, if not, going straight, otherwise going left. Whenever it finds a dead end, it turns left until it turns around. Thus following the right hand rule
    // at every turn and move, it updates position, direction, and appends the string builder 'path'
    @Override
    public Path solve(Maze maze) {
        Position entry = maze.getEntry();
        Position exit = maze.getExit();

        StringBuilder path = new StringBuilder();

        Position pos = entry;
        Direction direction = Direction.EAST;

        while (!pos.equals(exit)) {
            if (maze.isValidMove(pos, pos.nextPos(direction, "R"))) {
                direction = direction.lookRight();
                path.append("R");
                pos = pos.nextPos(direction, "F");
                path.append("F");
            } else if (maze.isValidMove(pos, pos.nextPos(direction, "F"))) {
                pos = pos.nextPos(direction, "F");
                path.append("F");
            } else if (maze.isValidMove(pos, pos.nextPos(direction, "L"))) {
                direction = direction.lookLeft();
                path.append("L");
                pos = pos.nextPos(direction, "F");
                path.append("F");
            } else {
                direction = direction.lookLeft();
                path.append("L");
            }
        }
        System.out.println(exit);
        System.out.println(pos);
        return new Path(path.toString());
    }
}
