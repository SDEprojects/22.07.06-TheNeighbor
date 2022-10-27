package main.java;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Player {

    Scanner scanner = new Scanner(System.in);
    TextParser myTest = null;


    private int currentLocationIndex = 0;
    private String currentLocation;
    private boolean isValid = false;
    private boolean help;


    // create object mapper instance
    ObjectMapper mapper = new ObjectMapper();

    // convert JSON array to list of items
    List<Items> items;
    List<Location> locations;
    {
        try {
            items = Arrays.asList(mapper.readValue(Paths.get("src/resources/items.json").toFile(), Items[].class));
            locations = List.of(mapper.readValue(Paths.get("src/resources/locations.json").toFile(), Location[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void playerInput() {
        while (!isValid) {
            System.out.print("Enter an action:\n" +
                    ">");
            String test = scanner.nextLine().toLowerCase(); //get user input
            myTest = new TextParser(test); // pass user input to new TextParser

            boolean help = myTest.getHelp();
            if (help) {
                helpMenu();
            } else {
                isValid = myTest.getValid(); // set the loop validation to TextParser validation
                validateUserInput(isValid);
            }
        }
    }


    public void playerMove() throws InterruptedException {
        // variable to store noun and verb
        String noun = myTest.getNoun();
        String verb = myTest.getVerb();

        switch (verb) {
            case "go":
                switch (noun) {
                    case "north":
                        currentLocation = locations.get(currentLocationIndex).getExit().getNorth();
                        break;
                    case "south":
                        currentLocation = locations.get(currentLocationIndex).getExit().getSouth();
                        break;
                    case "east":
                        currentLocation = locations.get(currentLocationIndex).getExit().getEast();
                        break;
                    case "west":
                        currentLocation = locations.get(currentLocationIndex).getExit().getWest();
                        break;
                    case "stairs":
                        currentLocation = locations.get(currentLocationIndex).getExit().getStairs();
                        break;
                }

                for (int i = 0; i < locations.size(); i++) {
                    if (locations.get(i).getName().equals(currentLocation)) {
                        currentLocationIndex = i;
                    }
                }
                System.out.println();
                System.out.println("You are in a " + locations.get(currentLocationIndex).getName());
                System.out.println(locations.get(currentLocationIndex).getDescription());
                Thread.sleep(2000);
                System.out.println("Your possible exit routes are");
                System.out.println(locations.get(currentLocationIndex).getExit().toString());
                Thread.sleep(2000);

                help = myTest.getHelp();
                if (help) {
                    helpMenu();
                } else {
                    isValid = myTest.getValid();
                    validateUserInput(isValid);
                    noun = myTest.noun;
                    verb = myTest.verb;
                }
                break;

            case "look":
                System.out.println("Looking....");
                System.out.println("___________---");
                break;

            case "take":
                System.out.println("I am taking something");
                System.out.println("**********************");
                break;
        }


    }


    private void helpMenu() {
        System.out.println("Possible commands: \n");
        System.out.println("****************************************");
        System.out.println("--go north   --go south  --go east\n" +
                "--go west   --go stairs \n \n OR");
        System.out.println("continue--to play the game");
        System.out.println("exit---to exit the game");
        System.out.println("******************************************");
    }

    private void validateUserInput(boolean isValid) {
        if (!isValid) { // if not valid, will generate invalid message
            System.out.println("\nThat is not a valid input. Please try again.\n" +
                    "Enter 'go', 'look' , or 'take' as a verb");
        }
    }
}
