package main.java;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {
    private Clip audioClip;
    public MusicPlayer() {

    }

    public void startPlayer(String path) throws LineUnavailableException {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(path));
            audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
            audioClip.loop(0);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }
    public void stopPlayer(){
        audioClip.close();

    }
}
