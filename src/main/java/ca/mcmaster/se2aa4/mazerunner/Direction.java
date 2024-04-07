package ca.mcmaster.se2aa4.mazerunner;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    // checking what the next direction would be after turning
    public Direction lookRight() {
        return switch (this) {
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
            default -> throw new IllegalStateException("Unexpected value: " + this);
        };
    }

    public Direction lookLeft() {
        return switch (this) {
            case NORTH -> WEST;
            case WEST -> SOUTH;
            case SOUTH -> EAST;
            case EAST -> NORTH;
            default -> throw new IllegalStateException("Unexpected value: " + this);
        };
    }

}
