package alien_attack;

import javax.sound.sampled.Clip;
import java.util.ArrayList;

/**
 * Created by frances on 2016-12-30.
 */
public class MusicPlayer implements Runnable {

    private ArrayList<String> musicFiles;
    public Clip clip;
    public int volume = -20;

    public static MusicPlayer songMenu = new MusicPlayer("likefaith.au");
    public static MusicPlayer songGame = new MusicPlayer("wasteland.au");
    public static MusicPlayer songGameOver = new MusicPlayer("stars.au");
    public static MusicPlayer zap = new MusicPlayer("zap.au");
    public static MusicPlayer hit = new MusicPlayer("hit.au");
    public static MusicPlayer hatch = new MusicPlayer("hatch.au");
    public static MusicPlayer start = new MusicPlayer("start.au");
    public static MusicPlayer bounce = new MusicPlayer("bounce.au");


    public MusicPlayer(String... files) {
        musicFiles = new ArrayList<>();
        for (String file : files) {
            musicFiles.add("music/" + file);
        }


    }

 /*   private void playSound(String fileName) {
        try {
            File soundFile = new File(fileName);
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            AudioFormat format = ais.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(ais);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(getVolume());
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */

    public void stopSound() {
        clip.stop();
    }

    public void setVolume(int vol) {
        this.volume = vol;
    }

    public int getVolume() {
        return this.volume;
    }


    @Override
    public void run() {

    }
}
