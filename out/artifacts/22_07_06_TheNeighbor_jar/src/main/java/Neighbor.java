package main.java;

public class Neighbor extends Character {
    int pathIndex = -1;
    private int lastLocIndex;
    private static final int[] PATH = {20, 19, 21, 19, 11, 12, 13, 12, 14, 12, 15, 16, 15, 17, 15, 18, 15, 12, 11, 19, 20};

    // no constructor needed - zero argument by default

    // Override methods
    @Override
    public void setLocationIndex(int locationIndex) {
        if (pathIndex == 0) {
            lastLocIndex = pathIndex;
            pathIndex++;
        } else if (pathIndex < PATH.length - 1) {
            lastLocIndex = pathIndex;
            pathIndex++;
        } else if (pathIndex == PATH.length -1) {
            lastLocIndex = pathIndex;
            pathIndex--;
        } else if (pathIndex < lastLocIndex) {
            lastLocIndex = pathIndex;
            pathIndex--;
        }

        locationIndex = PATH[pathIndex];

        super.setLocationIndex(locationIndex);
    }


}
