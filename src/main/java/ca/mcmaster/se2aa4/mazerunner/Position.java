package ca.mcmaster.se2aa4.mazerunner;

public class Position {
    private final int x;
    private final int y;

    Position(Integer xCor, Integer yCor){
        this.x = xCor;
        this.y = yCor;
    }

    // returns x coordinate
    public int getX() {
        return x;
    }

    // returns y coordinate
    public int getY() {
        return y;
    }

    // returns the coordinates as a string
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public boolean equals(Position pos) {
        return (getX() == pos.getX()) && (getY() == pos.getY());
    }

    // checking what the new position would be after moving or turning then moving. Based on current position, current direction, and direction of turn
    public Position moveFwd(Direction direction){
        int nextPos0 = x;
        int nextPos1 = y;
        if (direction == Direction.EAST) {
            nextPos0 = getX() + 1;
        }else if (direction == Direction.NORTH) {
            nextPos1 = getY() - 1;
        }else if (direction == Direction.SOUTH) {
            nextPos1 = getY() + 1;
        }else {
            nextPos0 = getX() - 1;
        }
        return new Position(nextPos0, nextPos1);
    }

    public Position turnR(Direction direction){
        int nextPos0 = x;
        int nextPos1 = y;
        if (direction == Direction.EAST) {
            nextPos1 = getY() + 1;
        }else if (direction == Direction.NORTH) {
            nextPos0 = getX() + 1;
        }else if (direction == Direction.SOUTH) {
            nextPos0 = getX() - 1;
        }else {
            nextPos1 = getY() - 1;
        }
        return new Position(nextPos0, nextPos1);
    }

    public Position turnL(Direction direction){
        int nextPos0 = x;
        int nextPos1 = y;
        if (direction == Direction.EAST) {
            nextPos1 = getY() - 1;
        }else if (direction == Direction.NORTH) {
            nextPos0 = getX() - 1;
        }else if (direction == Direction.SOUTH) {
            nextPos0 = getX() + 1;
        }else {
            nextPos1 = getY() + 1;
        }
        return new Position(nextPos0, nextPos1);
    }
}
