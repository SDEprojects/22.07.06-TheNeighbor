package main.java;


import javax.sound.sampled.LineUnavailableException;

public class ClientMain {
    public static void main(String[] args) throws LineUnavailableException {

        GameEngine game = new GameEngine();
        game.execute();


    }
}

