package Class_Diagram_CassetteDeck.States;

import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;

public class PlayingState extends DeckState {



	public PlayingState(CassetteDeck_Basic cassetteDeck_Basic) {
		super(cassetteDeck_Basic);
	}

	@Override
	public void onHold() {

	}

	public void onPlay() {

	}

	@Override
	public void onPause() {
//		if (cassetteDeck_Basic.isPlaying()) {
			cassetteDeck_Basic.changeState(new PauseState(cassetteDeck_Basic));
			System.out.println(this.cassetteDeck_Basic.getState());
			cassetteDeck_Basic.pause();
//		}
	}

	@Override
	public void onStop() {
		System.out.println("onStop");
//		if (cassetteDeck_Basic.isPlaying()) {
			cassetteDeck_Basic.changeState(new StopState(cassetteDeck_Basic));
//			cassetteDeck_Basic.setPlaying(false);
			System.out.println(this.cassetteDeck_Basic.getState());
			cassetteDeck_Basic.pause();
//		}


	}

	@Override
	public void onFR() {
		if (cassetteDeck_Basic.isPlaying()) {
			cassetteDeck_Basic.changeState(new FastRewindState(cassetteDeck_Basic));
			cassetteDeck_Basic.setPlaying(false);
			System.out.println(this.cassetteDeck_Basic.getState());
			cassetteDeck_Basic.fastRewind();
		}
	}

	@Override
	public void onFF() {
		if (cassetteDeck_Basic.isPlaying()) {
			cassetteDeck_Basic.changeState(new FastForwardState(cassetteDeck_Basic));
			System.out.println(this.cassetteDeck_Basic.getState());
			cassetteDeck_Basic.fastForward();
		}

	}

	@Override
	public void onRecord() {

//		!!!modifier avec la méthode adequat!!!
//		if (cassetteDeck_Basic.isPlaying()) {
//			cassetteDeck_Basic.changeState(new RecordState(cassetteDeck_Basic));
//			cassetteDeck_Basic.setPlaying(false);
//			cassetteDeck_Basic.stop();
//		}

	}

	@Override
	public void onNextSong() {
		//		!!!modifier avec la méthode adequat!!!
//		if (cassetteDeck_Basic.isPlaying()) {
//			cassetteDeck_Basic.changeState(new NextSongState(cassetteDeck_Basic));
//			cassetteDeck_Basic.setPlaying(false);
//			cassetteDeck_Basic.stop();
//		}
//		cassetteDeck_Basic.changeState(new NextSongState(cassetteDeck_Basic));
//		cassetteDeck_Basic.setCurrentSong( cassetteDeck_Basic.getCurrentSong() + 1);
//		cassetteDeck_Basic.changeState(new PlayingState(cassetteDeck_Basic));

//		File song = cassetteDeck_Basic.getListSongs()[cassetteDeck_Basic.getCurrentSong()];
//		cassetteDeck_Basic.setAudioFile(song.getAbsoluteFile());
//		cassetteDeck_Basic.setMedia(new Media(cassetteDeck_Basic.getAudioFile().toURI().toString()));
//		cassetteDeck_Basic.setMediaPlayer(new MediaPlayer(cassetteDeck_Basic.getMedia()));
//		cassetteDeck_Basic.setMediaView(new MediaView());
//		cassetteDeck_Basic.getMediaView().setMediaPlayer(cassetteDeck_Basic.getMediaPlayer());
//		cassetteDeck_Basic.getMediaPlayer().setOnReady(new Runnable() {
//			public void run() {
//				cassetteDeck_Basic.setDuration(cassetteDeck_Basic.getMediaPlayer().getMedia().getDuration());
//				cassetteDeck_Basic.updateValues();
//			}
//		});



	}

	@Override
	public void onPreviousSong() {
		//		!!!modifier avec la méthode adequat!!!
//		if (cassetteDeck_Basic.isPlaying()) {
//			cassetteDeck_Basic.changeState(new PreviousSongState(cassetteDeck_Basic));
//			cassetteDeck_Basic.setPlaying(false);
//			cassetteDeck_Basic.stop();
//		}
//
//		cassetteDeck_Basic.changeState(new NextSongState(cassetteDeck_Basic));
//		cassetteDeck_Basic.setCurrentSong( cassetteDeck_Basic.getCurrentSong() - 1);
//
//		File song = cassetteDeck_Basic.getListSongs()[cassetteDeck_Basic.getCurrentSong()];
//		cassetteDeck_Basic.setAudioFile(song.getAbsoluteFile());
//		cassetteDeck_Basic.setMedia(new Media(cassetteDeck_Basic.getAudioFile().toURI().toString()));
//		cassetteDeck_Basic.setMediaPlayer(new MediaPlayer(cassetteDeck_Basic.getMedia()));
//		cassetteDeck_Basic.setMediaView(new MediaView());
//		cassetteDeck_Basic.getMediaView().setMediaPlayer(cassetteDeck_Basic.getMediaPlayer());
//		cassetteDeck_Basic.getMediaPlayer().setOnReady(new Runnable() {
//			public void run() {
//				cassetteDeck_Basic.setDuration(cassetteDeck_Basic.getMediaPlayer().getMedia().getDuration());
//				cassetteDeck_Basic.updateValues();
//			}
//		});


	}

	@Override
	public void ledON() {

	}

	@Override
	public void ledOFF() {
		cassetteDeck_Basic.changeState(new OffState(cassetteDeck_Basic));
		if (cassetteDeck_Basic.getState() != null )System.out.println(this.cassetteDeck_Basic.getState());
		cassetteDeck_Basic.powerOff();
	}


	public void signalChangeState() {
		System.out.println("signal is playing");
	}

}