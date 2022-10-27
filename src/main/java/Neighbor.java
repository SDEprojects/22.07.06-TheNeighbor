package main.java;

public class Neighbor {
    int locationIndex = 0;
    private static final int[] PATH = {20, 19, 21, 19, 11, 12, 13, 12, 14, 12, 15, 16, 15, 17, 15, 18, 15, 12, 11, 19, 20};

    // no constructor needed - zero argument by default

    public int getLocation() {
        return PATH[locationIndex];
    }

    public void setLocation() {
        if (locationIndex < PATH.length) {
            locationIndex++;
        } else {
            locationIndex--;
        }
    }
}
