package ca.mcmaster.se2aa4.mazerunner;

public class Path {

    private String canonicalPath;

    public Path(String path) {
        this.canonicalPath = path;
    }

    public Path() {
        this.canonicalPath = "";
    }

    // converts the canonical form of the path to factorized form
    private String convertToFactorized(){
        if (canonicalPath.isEmpty()) {
            return "";
        }

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
