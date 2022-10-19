public class Exit {

    private String north;
    private String south;
    private String east;
    private String west;
    private String stairs;

    public Exit() {
    }

    public Exit(String north, String south, String east, String west, String stairs) {
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
        this.stairs = stairs;
    }

    public String getNorth() {
        return north;
    }

    public void setNorth(String north) {
        this.north = north;
    }

    public String getSouth() {
        return south;
    }

    public void setSouth(String south) {
        this.south = south;
    }

    public String getEast() {
        return east;
    }

    public void setEast(String east) {
        this.east = east;
    }

    public String getWest() {
        return west;
    }

    public void setWest(String west) {
        this.west = west;
    }

    public String getStairs() {
        return stairs;
    }

    public void setStairs(String stairs) {
        this.stairs = stairs;
    }

    @Override
    public String toString() {
        return "Exit{" +
                "north='" + north + '\'' +
                ", south='" + south + '\'' +
                ", east='" + east + '\'' +
                ", west='" + west + '\'' +
                ", stairs='" + stairs + '\'' +
                '}';
    }
}
