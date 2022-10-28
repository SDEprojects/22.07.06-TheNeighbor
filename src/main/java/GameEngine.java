package main.java;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class GameEngine {

    boolean quit = false;
    Scanner scanner = new Scanner(System.in);


    public void execute() {

        gameTitle();
        while (!quit) {
            menu();
        }
    }

    private void gameTitle() {

        try {
            List<String> allLines = Files.readAllLines(Paths.get("src/resources/asciiGame.txt"));

            for (String line : allLines) {
                DataInputStream dis = new DataInputStream(System.in);
                if (dis.available() == 0) {
                    Thread.sleep(250);
                    System.out.println("\u001B[31m" + line + "\u001B[0m");
                } else {
                    scanner.nextLine();
                    break;
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void menu() {

        System.out.println("\u001B[31m" + ".--------------.\n|" + "\u001B[0m" + " MENU OPTIONS " + "\u001B[31m" +
                "|\n'--------------'" + "\u001B[0m");
        System.out.println("Please type your option:\n| INTRO |-------| START GAME |-------| QUIT |\n");

        String input;
        input = scanner.nextLine().toLowerCase();

        switch (input) {
            case "intro":
                clearScreen();
                intro();
                break;
            case "start game":
                clearScreen();
                try {
                    startGame();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case "quit":
                clearScreen();
                quitGame();
                break;
            default:
                clearScreen();
                System.out.println("INVALID INPUT.\n");
                break;
        }
    }


    private void intro() {

        try {
            List<String> allLines = Files.readAllLines(Paths.get("src/resources/GameStoryIntro.txt"));

            for (String line : allLines) {
                DataInputStream dis = new DataInputStream(System.in);
                if (dis.available() == 0) {
                    Thread.sleep(2000);
                    System.out.println("\u001B[31m" + line + "\u001B[0m");
                } else {
                    scanner.nextLine();
                    break;
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void startGame() throws InterruptedException {
        // Generates Player & NPC
        Player player = new Player();
        Neighbor npc = new Neighbor();

        // Game loop
        boolean gameOn = true;
        while (gameOn) {
            // Information output
            HUD(player);
            Thread.sleep(300);
            player.playerInput();
            if (player.myTest.getHelp()) {
                helpMenu();
            } else if (player.myTest.getVerb().equals("go")) {
                player.playerMove();
                npc.setLocationIndex(npc.getLocationIndex());
            } else if (player.myTest.getVerb().equals("look")) {
            }

        }
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
        quit = true;
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
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

    private void HUD(Player player) {


        System.out.println("\nYou are in the "
                + player.getLocation().get(player.getLocationIndex()).getName());
        System.out.println("Your possible exit routes are"
                + player.getLocation().get(player.getLocationIndex()).getExit()
                + "\n");
    }
}