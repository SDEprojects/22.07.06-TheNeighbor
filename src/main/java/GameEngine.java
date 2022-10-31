package main.java;

import javax.sound.sampled.LineUnavailableException;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


public class GameEngine {

    boolean quit = false;
    Scanner scanner = new Scanner(System.in);
    MusicPlayer audioPlayer = new MusicPlayer();

    public void execute() {

        gameTitle();
        while (!quit) {
            menu();
        }
    }


    //("src/resources/thrillerAmbient.wav");
    private void gameTitle() {

        try {
            audioPlayer.startPlayer("src/resources/thrillerAmbient.wav");
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
        } catch (IOException | InterruptedException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void menu() {
        audioPlayer.stopPlayer();
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
                } catch (InterruptedException | LineUnavailableException e) {
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
            audioPlayer.stopPlayer();
            audioPlayer.startPlayer("src/resources/lullaby.wav");
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

        } catch (IOException | InterruptedException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }


    private void startGame() throws InterruptedException, LineUnavailableException {
        // Generates Player & NPC
        audioPlayer.stopPlayer();
        audioPlayer.startPlayer("src/resources/gameplaySound.wav");
        audioPlayer.loopSound();
        Player player = new Player();
        Neighbor npc = new Neighbor();
        PlayerGoodies goodies = new PlayerGoodies();

        // Game loop
        boolean gameOn = true;
        while (gameOn) {
            // Information output
            if (!player.winCheck()) {
                HUD(player);
                player.playerInput();
                if (player.myTest.getHelp()) {
                    helpMenu();
                } else if (player.myTest.getVerb().equals("go")) {
                    player.playerMove();
                    npc.setLocationIndex(npc.getLocationIndex());
                    System.out.println("player location index: " + player.getLocationIndex());
                    System.out.println("npc location index: " + npc.getLocationIndex());
                } else if (player.myTest.getVerb().equals("look")) {
                    player.playerLook();
                } else if (player.myTest.getVerb().equals("take")) {
                    player.takeItem();
                }
            }

            if(player.winCheck()){
                System.out.println(" You WIN!!");
                gameOn = false;
            }else if (player.lossCheck(player, npc)){
                System.out.println("Sorry, but you lose.....");
                gameOn = false;
            }
        }
    }

    private void quitGame() {
        try {
            audioPlayer.stopPlayer();
            audioPlayer.startPlayer("src/resources/evilLaugh.wav");
            List<String> allLines = Files.readAllLines(Paths.get("src/resources/quitNeighbor.txt"));
            for (String line : allLines) {
                Thread.sleep(500);
                System.out.println("\u001B[31m" + line + "\u001B[0m");
            }
        } catch (IOException | InterruptedException | LineUnavailableException e) {
            e.printStackTrace();
        }
        quit = true;
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void helpMenu() {
        try {
            clearScreen();
            audioPlayer.stopPlayer();
            audioPlayer.startPlayer("src/resources/mapSound.wav");
            List<String> allLines = Files.readAllLines(Paths.get("src/resources/helpMenu.txt"));
            for (String line : allLines) {
                Thread.sleep(100);
                System.out.println("\u001B[31m" + line + "\u001B[0m");
            }
        } catch (IOException | InterruptedException | LineUnavailableException e) {
            e.printStackTrace();
        }

    }

    private void HUD(Player player) {

        //ascii code for "you are in"
        System.out.println("\nჄ\uD835\uDDAEυ Ꭿᖇ∈ ⫯ﬡ \uD835\uDF0FᏂ∈ "
                + player.getLocation().get(player.getLocationIndex()).getName());
        //ascii code for "your possible routes are"
        System.out.println("Ⴤᗝυᖇ ᖰ\uD835\uDDAE⟆⟆⫯ᑲ\uD835\uDE2D∈ ᖇ\uD835\uDDAEυ\uD835\uDF0F∈⟆ Ꭿᖇ∈ "
                + player.getLocation().get(player.getLocationIndex()).getExit()
                + "\n");
        if (!player.goodies.getInventory().isEmpty()) {
            //ascii code for ""
            System.out.println("Ⲩⲟ\uD800\uDF35ꞅ ⲥ\uD800\uDF35ꞅꞅⲉⲛⲧ ⲓⲛ\uD835\uDCFFⲉⲛⲧⲟꞅⲩ ⲓ\uD835\uDED3:");
            for (String inventory : player.goodies.getInventory())
                System.out.println(inventory);
        }
    }
}