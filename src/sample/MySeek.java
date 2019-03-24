package sample;

import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class MySeek implements Runnable{
    private MediaPlayer mediaPlayer;
    private volatile boolean running = true;
    private volatile boolean isFF;

    public MySeek(MediaPlayer mediaPlayerl) {
        mediaPlayer = mediaPlayerl;
    }


//    public void stop() {
//        running.set(false);
    //    }
    public void terminate() {
        running = false;
    }


    @Override
    public void run() {
        System.out.println("Running...");
        while (running) {
//            if(mediaPlayer.getCurrentTime().toSeconds() < mediaPlayer.getTotalDuration().toSeconds()) {
//                this.mediaPlayer.seek(mediaPlayer.getCurrentTime().add(Duration.seconds(10)));
//            }
            if (isFF) {
                System.out.println("Running...FF");
                this.mediaPlayer.seek(mediaPlayer.getCurrentTime().add(Duration.seconds(10)));

            }else {
                System.out.println("Running...FR");

                this.mediaPlayer.seek(mediaPlayer.getCurrentTime().subtract(Duration.seconds(10)));
            }
        }

    }

    public boolean isFF() {
        return isFF;
    }

    public void setFF(boolean FF) {
        this.isFF = FF;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
