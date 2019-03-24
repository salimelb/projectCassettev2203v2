package Class_Diagram_CassetteDeck.States;

import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.CassetteDeck_Basic;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;

public class ReadyState extends DeckState {

    public ReadyState(CassetteDeck_Basic cassetteDeck_Basic) {
        super(cassetteDeck_Basic);
    }

    @Override
    public void onHold() {

    }

    @Override
    public void onPlay() {
        File song = cassetteDeck_Basic.getListSongs()[cassetteDeck_Basic.getCurrentSong()];
        cassetteDeck_Basic.setAudioFile(song.getAbsoluteFile());
        cassetteDeck_Basic.setMedia(new Media(cassetteDeck_Basic.getAudioFile().toURI().toString()));
        cassetteDeck_Basic.setMediaPlayer(new MediaPlayer(cassetteDeck_Basic.getMedia()));
        cassetteDeck_Basic.setMediaView(new MediaView());
        cassetteDeck_Basic.getMediaView().setMediaPlayer(cassetteDeck_Basic.getMediaPlayer());
        cassetteDeck_Basic.getMediaPlayer().setOnReady(new Runnable() {
            public void run() {
                cassetteDeck_Basic.setDuration(cassetteDeck_Basic.getMediaPlayer().getMedia().getDuration());
                cassetteDeck_Basic.updateValues();
            }
        });


        if (!cassetteDeck_Basic.isPlaying()) {
            cassetteDeck_Basic.changeState(new PlayingState(cassetteDeck_Basic));
            cassetteDeck_Basic.setPlaying(true);
            cassetteDeck_Basic.play();
        }
//        cassetteDeck_Basic.changeState(new PlayingState(cassetteDeck_Basic));
//
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onFR() {

    }

    @Override
    public void onFF() {

    }

    @Override
    public void onRecord() {

    }

    @Override
    public void onNextSong() {

    }

    @Override
    public void onPreviousSong() {

    }

    @Override
    public void ledON() {

    }

    @Override
    public void ledOFF() {

    }
}
