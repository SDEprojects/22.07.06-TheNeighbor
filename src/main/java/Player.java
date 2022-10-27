package main.java;

import java.util.List;
import java.util.Scanner;

public class Player extends Character {

    Scanner scanner = new Scanner(System.in);
    TextParser myTest = null;

    private int locationIndex = 0;
    private String currentLocation;
    private boolean isValid = false;
    private boolean help;
    private int suspicion = 0;


    public void playerInput() {
        String input;
        while (!isValid) {
            System.out.print("Enter an action:\n" +
                    ">");
            input = scanner.nextLine().toLowerCase(); //get user input
            myTest = new TextParser(input); // pass user input to new TextParser
            isValid = myTest.getValid(); // set the loop validation to TextParser validation
            validateUserInput(isValid);
            if (!isValid) { // if not valid, will generate invalid message
                System.out.println("\nThat is not a valid input. Please try again.\n" +
                        "Enter 'go', 'look' , or 'take' as a verb");
            }

        }
    }


    public void playerMove() {


        for (int i = 0; i < getLocation().size(); i++) {
            setLocationIndex(i);
        }
    }

    private void validateUserInput(boolean isValid) {

    }

    @Override
    public void setLocationIndex(int locationIndex) {
        switch (myTest.getNoun()) {
            case "north":
                currentLocation = getLocation().get(locationIndex).getExit().getNorth();
                break;
            case "south":
                currentLocation = getLocation().get(locationIndex).getExit().getSouth();
                break;
            case "east":
                currentLocation = getLocation().get(locationIndex).getExit().getEast();
                break;
            case "west":
                currentLocation = getLocation().get(locationIndex).getExit().getWest();
                break;
            case "stairs":
                locationIndex = getLocation().indexOf(getLocation().get(getLocationIndex()).getExit().getStairs());
                break;
        }

        super.setLocationIndex(locationIndex);
    }
}
