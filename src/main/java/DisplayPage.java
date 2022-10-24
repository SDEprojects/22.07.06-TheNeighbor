import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class DisplayPage {
    private Scanner scanner = new Scanner(System.in);

    public void execute() {
        gameTitle();
        pressEnter();
//        menu();
//        ContOrQuit();
    }

    private void gameTitle() {
//        try {
//            Files.lines(Path.of("src/resources/", "asciiGame.txt"))
//                    .forEach(line -> System.out.println("\u001B[31m" + "\033[1;31m" + line));
//        } catch (Exception e) {
//            System.err.println("Error: " + e.getMessage());
//        }
        try {
            List<String> allLines = Files.readAllLines(Paths.get("src/resources/asciiGame.txt"));
            for (String line : allLines) {
                Thread.sleep(500);
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
        if (input.equals("enter")) {
            menu();
        }
    }

    private void menu() {

        System.out.println("\033[0;34m" + ".--------------.\n| MENU OPTIONS |\n'--------------'" + "\u001B[0m");
        System.out.println("Please type your option:\n| INTRO |-------| START GAME |-------| QUIT |\n");

        String input = scanner.nextLine().toLowerCase();

        while (!input.equals("intro") && input.equals("start game")
                && input.equals("quit")) {
            System.out.println("invalid selection.\n");
            input = scanner.nextLine().toLowerCase();
        }
        if (input.equals("intro") || input.equals("1")) {
            intro();
        } else if (input.equals("start game")) {
            startGame();
        } else if (input.equals("quit")) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("I SEE THAT YOU ARE SCARED.\n COMEBACK WHEN YOU STOP BEING WEAK");
            System.exit(0);
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

    private void subMenu() {
        System.out.print("Enter a number option:\n [1]START GAME ------- [2]QUIT\n");
        boolean validInput = true;
        int option = 0;
        while (validInput) {
            String input = scanner.nextLine().trim();
            if (input.matches("\\d{1}")) {
                option = Integer.parseInt(input);
                if (!(option >= 1 && option <= 2)) {
                } else {
                    switch (option) {
                        case 1:
                            startGame();
                            break;
                        case 2:
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            System.out.println("I SEE THAT YOU ARE SCARED.\n COMEBACK WHEN YOU STOP BEING WEAK");
                            System.exit(0);
                            validInput = false;
                            break;
                    }
                }
            } else {
                System.out.println("invalid selection. Your options is from [1-2]\n");
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
            int currentLocationIndex = 0;
            TextParser myTest = null;

            // user input validation
            boolean isValid = false;
            while (!isValid) {
                System.out.println("Enter an action:\n" +
                        ">");
                String test = scanner.next().toLowerCase(); //get user input
                myTest = new TextParser(test); // pass user input to new TextParser
                isValid = myTest.getValid(); // set the loop validation to TextParser validation
                if (!isValid) { // if not valid, will generate invalid message
                    System.out.println("\nThat is not a valid input. Please try again.\n" +
                            "Enter 'go', 'look' , or 'take' as a verb");
                }
            }

            String verb = myTest.getVerb();
            String noun = myTest.getNoun();
            System.out.printf("the verb is: %s, and the noun is: %s.\n",
                    verb, noun);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        subMenu();

    }
}


