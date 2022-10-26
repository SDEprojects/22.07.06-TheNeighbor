package main.java;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GameEngine display = new GameEngine();

        boolean gameOn = true;
        while (gameOn) {
            display.execute();


        }
    }

}
