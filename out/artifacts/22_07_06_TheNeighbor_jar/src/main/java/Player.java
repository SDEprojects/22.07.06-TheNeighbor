package main.java;

import java.util.Scanner;

public class Player extends Character {

    Scanner scanner = new Scanner(System.in);
    TextParser myTest = null;

    private String input;
    private int locationIndex = 0;
    private String currentLocation;
    private boolean isValid = false;
    private boolean help;
    private int suspicion = 0;


    public void playerInput() {
        while (!isValid) {
            System.out.print("Enter an action:\n" +
                    ">");
            input = scanner.nextLine().toLowerCase();
            myTest = new TextParser(input); // pass user input to new TextParser
            isValid = myTest.getValid(); // set the loop validation to TextParser validation
            if (myTest.getHelp()) { // if not valid, will generate invalid message
                isValid = myTest.getHelp();
            } else if (!isValid) {
                System.out.println("\nThat is not a valid input. Please try again.\n" +
                        "Enter 'go', 'look' , or 'take' as a verb");
            }
        }
        isValid = false;
    }


    public void playerMove() {
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
                currentLocation = getLocation().get(locationIndex).getExit().getStairs();
                break;
        }

        for (int i = 0; i < getLocation().size(); i++) {
            if (getLocation().get(i).getName().equals(currentLocation)) {
                locationIndex = i;
                setLocationIndex(locationIndex);
            }
        }
    }

    @Override
    public void setLocationIndex(int locationIndex) {
        super.setLocationIndex(locationIndex);
    }
}
