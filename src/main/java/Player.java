package main.java;

import javax.sound.sampled.LineUnavailableException;
import java.util.Scanner;

public class Player extends Character {

    private int suspicion = 0;
    Scanner scanner = new Scanner(System.in);
    PlayerGoodies goodies = new PlayerGoodies();
    MusicPlayer audio = new MusicPlayer();
    TextParser myTest = null;
    private String input;
    private int locationIndex = 0;
    private String currentLocation;
    private boolean isValid = false;
    private boolean help;

    public void playerInput() {
        while (!isValid) {
            System.out.print("Ⲉⲛⲧⲉꞅ ⲁⲛ ⲁⲥⲧⲓⲟⲛ:\n" +
                    ">");
            input = scanner.nextLine().toLowerCase();
            myTest = new TextParser(input); // pass user input to new TextParser
            isValid = myTest.getValid(); // set the loop validation to TextParser validation
            if (myTest.getHelp()) { // if not valid, will generate invalid message
                isValid = myTest.getHelp();
            } else if (myTest.getVerb().equals("look")) {
                isValid = true;
            } else if (myTest.getVerb().equals("take")) {
                isValid = true;
            }else if (myTest.getExit()){
                isValid = true;
            }
            else if (!isValid) {
                System.out.println("\nThat is not a valid input. Please try again.\n" +
                        "Enter 'go', 'look' , or 'take' as a verb");
            }
        }
        isValid = false;
    }

public void playerMove() throws LineUnavailableException {
        switch (myTest.getNoun()) {
            case "north":
                audio.startPlayer("src/resources/footsteps.wav");
                currentLocation = getLocation().get(locationIndex).getExit().getNorth();
                break;
            case "south":
                audio.startPlayer("src/resources/footsteps.wav");
                currentLocation = getLocation().get(locationIndex).getExit().getSouth();
                break;
            case "east":
                audio.startPlayer("src/resources/footsteps.wav");
                currentLocation = getLocation().get(locationIndex).getExit().getEast();
                break;
            case "west":
                audio.startPlayer("src/resources/footsteps.wav");
                currentLocation = getLocation().get(locationIndex).getExit().getWest();
                break;
            case "stairs":
                audio.startPlayer("src/resources/stepsInStairs.wav");
                currentLocation = getLocation().get(locationIndex).getExit().getStairs();
                break;
        }

        for (int i = 0; i < getLocation().size(); i++) {
            if (getLocation().get(i).getName().equals(currentLocation)) {
                locationIndex = i;
                setLocationIndex(locationIndex);
            }
        }
        setSuspicion(suspicion);
    }

    public void playerLook() {
        if (myTest.getVerb().equals("look")) {
            if (getLocation().get(locationIndex).getItems() == null) {
                System.out.println("There are no items in " + getLocation().get(locationIndex).getName() + " to collect for you");
            } else {
                System.out.println(getLocation().get(locationIndex).getItems());
            }
        }
    }

    public void takeItem() {
        if (myTest.getVerb().equals("take")) {
            if (getLocation().get(locationIndex).getItems() == null) {
                System.out.println("There are no items to take in " + getLocation().get(locationIndex).getName());
            } else {
                String[] userInput = myTest.getT();
                String playerItem = "";
                for (int i = 1; i < userInput.length; i++) {
                    playerItem = playerItem + userInput[i] + " ";
                }
                playerItem = playerItem.substring(0, playerItem.length() - 1);

                if (getLocation().get(locationIndex).getItems().getName().equals(playerItem)) {
                    // check if the player already has the selected item
                    if (goodies.getInventory().contains(playerItem)) {
                        System.out.println("You already have " + playerItem + " in your inventory");
                    } else {
                        goodies.getInventory().add(playerItem);
                        System.out.println(playerItem + " is added to your inventory.");
                    }
                } else {
                    System.out.println("You did not take the correct item. Try taking again!");
                }
            }
        }
    }

    public Boolean winCheck() {
        Boolean win = false;
        if ((goodies.getInventory().contains("wadded note") ||
                goodies.getInventory().contains("bedside notepad")) &&
                (getLocation().get(getLocationIndex()).getName().equals("outside"))) {
            System.out.println("You made it outside!!!");
            win = true;
        }
        return win;
    }

    public Boolean lossCheck(Player player, Neighbor npc) {
        Boolean lose = false;
        if (player.getLocationIndex() == npc.getLocationIndex()) {
            lose = true;
        } else if (player.getLocation().get(locationIndex).getName().equals("outside") &&
                (!goodies.getInventory().contains("wadded note") && !goodies.getInventory().contains("bedside notepad"))
        ) {
            System.out.println("You didn't find the security code....");
            lose = true;
        }else if (getSuspicion() == 100){
            System.out.println("The neighbor knows you're in the house!! You're caught!!");
            lose = true;
        }

        return lose;
    }

    public int getSuspicion() {
        return suspicion;
    }

    private void setSuspicion(int suspicion) {
        this.suspicion = suspicion + 5;
    }

    // Character override methods
    @Override
    public void setLocationIndex(int locationIndex) {
        locationIndex = this.locationIndex;
        super.setLocationIndex(locationIndex);
    }
}
