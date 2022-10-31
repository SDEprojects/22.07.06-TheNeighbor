package main.java;

public class Neighbor extends Character {
    private int pathIndex = 0;
    private int lastLocIndex = pathIndex;
    private static final int[] PATH = {20, 19, 21, 19, 11, 12, 13, 12, 14, 12, 15, 16, 15, 17, 15, 18, 15, 12, 11, 19, 20};

    // no constructor needed - zero argument by default

    // Override methods
    @Override
    public void setLocationIndex(int locationIndex) {
        if ((pathIndex < PATH.length && lastLocIndex < pathIndex)
                || pathIndex == 0) {
            lastLocIndex = pathIndex;
            pathIndex++;
        } else {
            lastLocIndex = pathIndex;
            pathIndex--;
        }
        locationIndex = PATH[pathIndex];

        super.setLocationIndex(locationIndex);
    }


}
