import java.io.*;
import java.io.File;
import javax.sound.sampled.*;


public class Sound {
	/*public static synchronized void playSound(final String url) {
  new Thread(new Runnable() {
  // The wrapper thread is unnecessary, unless it blocks on the
  // Clip finishing; see comments.
    public void run() {
      try {
        Clip clip = AudioSystem.getClip();
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
         MyFrame.class.getResourceAsStream("GameFrame/HappyAdventure.wav"));
        clip.open(inputStream);
        clip.start(); 
      } catch (Exception e) {
        System.err.println(e.getMessage());
      }
    }
  }).start();
}*/

	public static void main(String[] args){
		try{
			AudioInputStream bg = AudioSystem.getAudioInputStream(new File("HappyAdventure.wav"));

			Clip clip = AudioSystem.getClip();
			clip.open(bg);

			clip.start();

			for (int i=0; i<30000; i++)
			System.out.println("");

		}catch(Exception e){e.printStackTrace();}
	}
}