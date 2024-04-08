package ca.mcmaster.se2aa4.mazerunner;

public class Path {

    private String canonicalPath;

    public Path(String path) {
        this.canonicalPath = path;
    }

    public Path() {
        this.canonicalPath = "";
    }

    // checks path by checking if each move is valid and checking if the final position is equal to the exit
    public boolean checkPath(Maze maze){
        if (canonicalPath.equals("empty")){
            return false;
        }
        Position entry = maze.getEntry();
        Position exit = maze.getExit();
        Position pos = entry;
        char givenChar;
        Direction direction = Direction.EAST;

        for (int i=0; i<canonicalPath.length(); i++){
            givenChar = canonicalPath.charAt(i);
            if (String.valueOf(givenChar).equals("F")){
                if (maze.isValidMove(pos, pos.moveFwd(direction))){
                    pos = pos.moveFwd(direction);
                }
            }else if (String.valueOf(givenChar).equals("R")){
                direction = direction.lookRight();
            }else if (String.valueOf(givenChar).equals("L")){
                direction = direction.lookLeft();
            }
        }
        return (pos.equals(exit));
    }

    // converts the canonical form of the path to factorized form
    private String convertToFactorized(){
        StringBuilder factorized = new StringBuilder();

        char currentChar = canonicalPath.charAt(0);
        int count = 1;

        for (int i = 1; i < canonicalPath.length(); i++) {
            char nextChar = canonicalPath.charAt(i);

            if (nextChar == currentChar) {
                count++;
            } else {
                factorized.append(count).append(currentChar);
                currentChar = nextChar;
                count = 1;
            }
        }
        factorized.append(count).append(currentChar);
        return factorized.toString();
    }

    public String getCanonicalPath() {
        return canonicalPath;
    }

    public String getFactorizedPath() {
        return convertToFactorized();
    }

    public void add(String s) {
        canonicalPath = canonicalPath + s;
    }
}
