package com.company.utils;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


public class Sounds {

   /**
    * Method plays sounds
    */
    public void playSound(String fileName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/"+fileName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
        }
    }
}
