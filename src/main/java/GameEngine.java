package main.java;

import com.fasterxml.jackson.databind.ObjectMapper;


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
        // gameController();
        boolean gameOn = true;

        // player starts from the basement
        System.out.println("You are starting from a basement\n\n");
        System.out.println("Your possible exit routes are: \n");
        System.out.println("Exit{north=''}");

        while (gameOn) {

            Player player = new Player();
            // player input
            player.playerInput();
            // player movement
            player.playerMove();
        }
    }
        private void quitGame () {
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

        private void clearScreen () {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
