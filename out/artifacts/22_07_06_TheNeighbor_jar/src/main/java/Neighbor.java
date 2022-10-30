package main.java;

public class Neighbor extends Character {
    private int lastLocIndex = getLocationIndex();
    private static final int[] PATH = {20, 19, 21, 19, 11, 12, 13, 12, 14, 12, 15, 16, 15, 17, 15, 18, 15, 12, 11, 19, 20};

    // no constructor needed - zero argument by default

    // Override methods
    @Override
    public void setLocationIndex(int locationIndex) {
        if ((getLocationIndex() < PATH.length && lastLocIndex < getLocationIndex())
                || getLocationIndex() == 0) {
            lastLocIndex = locationIndex;
            locationIndex++;
        } else {
            lastLocIndex = locationIndex;
            locationIndex--;
        }

        super.setLocationIndex(locationIndex);
    }


}
