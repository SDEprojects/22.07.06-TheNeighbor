package main.java;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DisplayPage display = new DisplayPage();

        boolean gameOn = true;
        while (gameOn) {
            display.execute();


        }
    }

}
