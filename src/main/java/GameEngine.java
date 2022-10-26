package main.java;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class GameEngine {
    Scanner scanner = new Scanner(System.in);
    Player player = new Player();
    public void execute() {
        gameTitle();
        pressEnter();
        menu();
    }

    private void gameTitle() {

        try {
            List<String> allLines = Files.readAllLines(Paths.get("src/resources/asciiGame.txt"));
            for (String line : allLines) {
                Thread.sleep(250);
                System.out.println("\u001B[31m" + line + "\u001B[0m");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void pressEnter() {
        System.out.println("Type 'Enter' to continue\n");
        String input = scanner.nextLine().toLowerCase();

        while (!input.equals("enter")) {
            System.out.println("Invalid command");
            input = scanner.nextLine();
        }
        clearScreen();
    }

    private void menu() {

        System.out.println("\u001B[31m" + ".--------------.\n|" + "\u001B[0m" + " MENU OPTIONS " + "\u001B[31m" +
                "|\n'--------------'" + "\u001B[0m");
        System.out.println("Please type your option:\n| INTRO |-------| START GAME |-------| QUIT |\n");

        String input;
        while (true) {

            input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "intro":
                    clearScreen();
                    intro();
                    break;
                case "start game":
                    clearScreen();
                    startGame();
                    break;
                case "quit":
                    clearScreen();
                    quitGame();
                    System.exit(0);
                default:
                    System.out.println("INVALID SELECTION.\n" +
                            "Please type your option:\n" +
                            "| INTRO |-------| START GAME |-------| QUIT |\n");
                    break;
            }
        }
    }

    private void intro() {

        try {
            List<String> allLines = Files.readAllLines(Paths.get("src/resources/GameStoryIntro.txt"));
            for (String line : allLines) {
                Thread.sleep(2000);
                System.out.println("\u001B[31m" + line + "\u001B[0m");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        subMenu();
    }

    private void quitGame() {
        try {
            List<String> allLines = Files.readAllLines(Paths.get("src/resources/quitNeighbor.txt"));
            for (String line : allLines) {
                System.out.println("\u001B[31m" + line + "\u001B[0m");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void subMenu() {
        System.out.print("Enter a number option:\n| START GAME | ------- | QUIT |\n");
        String input;
        while (true) {

            input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "start game":
                    clearScreen();
                    startGame();
                    break;
                case "quit":
                    clearScreen();
                    quitGame();
                    System.exit(0);
                default:
                    System.out.println("INVALID SELECTION.\n" +
                            "Please type your option:\n" +
                            "| START GAME |-------| QUIT |\n");
                    break;
            }
        }
    }

    private void startGame() {
        // gameController();
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON array to list of items
            List<Items> items = Arrays.asList(mapper.readValue(Paths.get("src/resources/items.json").toFile(), Items[].class));

            // convert JSON array to list of locations
            List<Location> locations = List.of(mapper.readValue(Paths.get("src/resources/locations.json").toFile(), Location[].class));
            //Location loc = mapper.readValue(Paths.get("src/resources/locations.json").toFile(),Location.class);
            TextParser myTest = null;
            boolean gameOn = true;
            while (gameOn) {

                // player starts from the basement
                System.out.println("You are starting from a basement\n\n");
                System.out.println("Your possible exit routes are: \n");
                System.out.println(locations.get(0).getExit().toString());

                // user input validation
                boolean isValid = false;
                while (!isValid) {
                    System.out.print("Enter an action:\n" +
                            ">");
                    String test = scanner.nextLine().toLowerCase(); //get user input
                        myTest = new TextParser(test); // pass user input to new TextParser
                        isValid = myTest.getValid(); // set the loop validation to TextParser validation
                        validateUserInput(isValid);
                }

                // variable to store noun and verb
                String noun = myTest.getNoun();
                String verb = myTest.getVerb();

                boolean gameMovement = true;
                while (gameMovement) {
                    switch (verb) {
                        case "go":
                            switch (noun) {
                                case "north":
                                    GameGlobalVariable.currentLocation = locations.get(GameGlobalVariable.currentLocationIndex).getExit().getNorth();
                                    break;
                                case "south":
                                    GameGlobalVariable.currentLocation = locations.get(GameGlobalVariable.currentLocationIndex).getExit().getSouth();
                                    break;
                                case "east":
                                    GameGlobalVariable.currentLocation = locations.get(GameGlobalVariable.currentLocationIndex).getExit().getEast();
                                    break;
                                case "west":
                                    GameGlobalVariable.currentLocation = locations.get(GameGlobalVariable.currentLocationIndex).getExit().getWest();
                                    break;
                                case "stairs":
                                    GameGlobalVariable.currentLocation = locations.get(GameGlobalVariable.currentLocationIndex).getExit().getStairs();
                                    break;
                            }

                            for (int i = 0; i < locations.size(); i++) {
                                if (locations.get(i).getName().equals(GameGlobalVariable.currentLocation)) {
                                    GameGlobalVariable.currentLocationIndex = i;
                                }
                            }
                            System.out.println();
                            System.out.println("You are in a " + locations.get(GameGlobalVariable.currentLocationIndex).getName());
                            System.out.println(locations.get(GameGlobalVariable.currentLocationIndex).getDescription());
                            Thread.sleep(2000);
                            System.out.println("Your possible exit routes are");
                            System.out.println(locations.get(GameGlobalVariable.currentLocationIndex).getExit().toString());
                            Thread.sleep(2000);
                            System.out.println();

                            System.out.println("Where would you like to go?");
                            String userValue = scanner.nextLine().toLowerCase();
                            myTest = new TextParser(userValue);
                            isValid = myTest.getValid();
                            validateUserInput(isValid);
                            noun = myTest.noun;
                            verb = myTest.verb;
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


            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        subMenu();
    }

    private void validateUserInput(boolean isValid) {
        if (!isValid) { // if not valid, will generate invalid message
            System.out.println("\nThat is not a valid input. Please try again.\n" +
                    "Enter 'go', 'look' , or 'take' as a verb");
        }
    }



    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}