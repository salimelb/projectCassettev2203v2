package Class_Diagram_CassetteDeck.CassetteDeck_BasicComp;

import Class_Diagram_CassetteDeck.States.*;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import sample.MySeek;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class CassetteDeck_Basic{

	private DeckState deckState;
	private boolean playing = false;
	private Media media;
	private MediaPlayer mediaPlayer;
	private MediaView mediaView;
	private Duration duration;
	private Label playTime;
	private Slider timeSlider;
	private Slider volumeSlider;
	private Timer counter;
	private boolean isOn = false;
//	private boolean isInsert = false;
	private File audioFile = null;

	private Duration currentTime;
	Thread thread = null;
	MySeek mySeek = null;
	private String currentState = "";
	File[] listSongs = null;
	int currentSong = 0;

	public Label getCurrentLabelState() {
		return currentLabelState;
	}

	public void setCurrentLabelState(Label currentLabelState) {
		this.currentLabelState = currentLabelState;
	}

	Label currentLabelState;
	private boolean isInsert = false;


//	private HBox mediaBar,mediaButton;

//	private boolean atEndOfMedia = false;



	public CassetteDeck_Basic(Label currentLabelState) {
		this.deckState = new OffState(this);
		this.currentLabelState = currentLabelState;

        String path = new File("sounds/akram.mp3").getAbsolutePath();
        this.media = new Media(new File(path).toURI().toString());
//		String path = new File("sounds/vide.mp3").getAbsolutePath();
//		this.media = new Media(new File(path).toURI().toString());
        this.mediaPlayer = new MediaPlayer(media);
		mySeek = new MySeek(this.mediaPlayer);

	}

	public Label getPlayTime() {
		return playTime;
	}

	public void setPlayTime(Label playTime) {
		this.playTime = playTime;
	}

	public HBox createMediaBar(){
		HBox mediaBar = new HBox();
		mediaBar.setAlignment(Pos.CENTER);
		mediaBar.setPadding(new Insets(5, 10, 5, 10));
		BorderPane.setAlignment(mediaBar, Pos.CENTER);

		// Add Time label
		Label timeLabel = new Label("Time: ");
		//Add vol Label
		Label volLabel = new Label("VOL: ");

		//permet de bouger le slider de lecture
		getMediaPlayer().currentTimeProperty().addListener(new InvalidationListener() {
			public void invalidated(Observable ov) {
				updateValues();
			}
		});

		getMediaPlayer().setOnReady(new Runnable() {
			public void run() {
				duration = getMediaPlayer().getMedia().getDuration();
				updateValues();
			}
		});
//		mediaBar.getChildren().addAll(timeLabel);
		// Add time slider
		timeSlider = new Slider();
		HBox.setHgrow(timeSlider, Priority.ALWAYS);
		timeSlider.setMinWidth(50);
		timeSlider.setMaxWidth(Double.MAX_VALUE);
		timeSlider.valueProperty().addListener(new InvalidationListener() {
			public void invalidated(Observable ov) {
				if (timeSlider.isValueChanging()) {
//					 multiply duration by percentage calculated by slider position
					getMediaPlayer().seek(duration.multiply(timeSlider.getValue() / 100.0));
				}
				updateValues();
			}
		});
//		mediaBar.getChildren().add(timeSlider);

		// Add Play label
		playTime = new Label();
		playTime.setPrefWidth(130);
		playTime.setMinWidth(50);
		mediaBar.getChildren().addAll(timeLabel,timeSlider, playTime);
//		mediaBar.getChildren().add(playTime);

		// Add Volume slider
		volumeSlider = new Slider();
		volumeSlider.setPrefWidth(70);
		volumeSlider.setMaxWidth(Region.USE_PREF_SIZE);
		volumeSlider.setMinWidth(30);
		volumeSlider.valueProperty().addListener(new InvalidationListener() {
			public void invalidated(Observable ov) {
				if (volumeSlider.isValueChanging()) {
					getMediaPlayer().setVolume(volumeSlider.getValue() / 100.0);
				}
			}
		});
		mediaBar.getChildren().addAll(volLabel,volumeSlider);

//		mediaBar.getChildren().addAll(timeLabel,timeSlider,playTime,volLabel,volumeSlider);
		return mediaBar;

	}

	public void updateValues() {
		if (playTime != null && timeSlider != null && volumeSlider != null) {
			Platform.runLater(new Runnable() {
				public void run() {
					Duration currentTime = getMediaPlayer().getCurrentTime();
					playTime.setText(formatTime(currentTime, duration));
					timeSlider.setDisable(duration.isUnknown());
					if (!timeSlider.isDisabled()
							&& duration.greaterThan(Duration.ZERO)
							&& !timeSlider.isValueChanging()) {
						timeSlider.setValue(currentTime.divide(duration).toMillis()
								* 100.0);
					}
					if (!volumeSlider.isValueChanging()) {
						volumeSlider.setValue((int) Math.round(getMediaPlayer().getVolume()
								* 100));
					}
				}
			});
		}
	}

	public Duration getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Duration currentTime) {
		this.currentTime = currentTime;
	}

	public static String formatTime(Duration elapsed, Duration duration) {
		int intElapsed = (int) Math.floor(elapsed.toSeconds());
		int elapsedHours = intElapsed / (60 * 60);
		if (elapsedHours > 0) {
			intElapsed -= elapsedHours * 60 * 60;
		}
		int elapsedMinutes = intElapsed / 60;
		int elapsedSeconds = intElapsed - elapsedHours * 60 * 60
				- elapsedMinutes * 60;

		if (duration.greaterThan(Duration.ZERO)) {
			int intDuration = (int) Math.floor(duration.toSeconds());
			int durationHours = intDuration / (60 * 60);
			if (durationHours > 0) {
				intDuration -= durationHours * 60 * 60;
			}
			int durationMinutes = intDuration / 60;
			int durationSeconds = intDuration - durationHours * 60 * 60
					- durationMinutes * 60;
			if (durationHours > 0) {
				return String.format("%d:%02d:%02d/%d:%02d:%02d",
						elapsedHours, elapsedMinutes, elapsedSeconds,
						durationHours, durationMinutes, durationSeconds);
			} else {
				return String.format("%02d:%02d/%02d:%02d",
						elapsedMinutes, elapsedSeconds, durationMinutes,
						durationSeconds);
			}
		} else {
			if (elapsedHours > 0) {
				return String.format("%d:%02d:%02d", elapsedHours,
						elapsedMinutes, elapsedSeconds);
			} else {
				return String.format("%02d:%02d", elapsedMinutes,
						elapsedSeconds);
			}
		}
	}

	public DeckState getState() {
		return deckState;
	}

	public void powerOff() {
//		// TODO - implement CassetteDeck_Basic.powerOff
//		throw new UnsupportedOperationException();
        isOn = false;
		this.mediaPlayer.stop();
	}
//
	public void powerOn() {
//		// TODO - implement CassetteDeck_Basic.powerOn
//		throw new UnsupportedOperationException();
        isOn = true;

	}

	public void play() {
		System.out.println("Playing .........");
		System.out.println(mediaPlayer.getCurrentTime().toSeconds());

		if (thread != null) {
			mySeek.terminate();
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.mediaPlayer.seek(mediaPlayer.getCurrentTime());
		this.mediaPlayer.play();
		mySeek.setRunning(true);
	}

	public void pause() {
		if (thread != null) {
			mySeek.terminate();
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.mediaPlayer.seek(mediaPlayer.getCurrentTime());
		this.mediaPlayer.pause();
		mySeek.setRunning(true);
	}

	public void fastRewind() {
		mySeek.setFF(false);
		thread = new Thread(mySeek);
		thread.start();
	}

	public void fastForward() {
		mySeek.setFF(true);
		thread = new Thread(mySeek);
		thread.start();
	}

	public void nextSong(){
		this.mediaPlayer.stop();
		setCurrentSong( getCurrentSong() + 1);
		File song = getListSongs()[getCurrentSong()];
		setAudioFile(song.getAbsoluteFile());
		setMedia(new Media(getAudioFile().toURI().toString()));
		setMediaPlayer(new MediaPlayer(getMedia()));
		setMediaView(new MediaView());
		getMediaView().setMediaPlayer(getMediaPlayer());
		getMediaPlayer().setOnReady(new Runnable() {
			public void run() {
				setDuration(getMediaPlayer().getMedia().getDuration());
				updateValues();
			}
		});
		this.mediaPlayer.play();
	}

	public void previousSong(){
//		cassetteDeck_Basic.changeState(new NextSongState(cassetteDeck_Basic));
		this.mediaPlayer.stop();
		setCurrentSong( getCurrentSong() - 1);
		File song = getListSongs()[getCurrentSong()];
		setAudioFile(song.getAbsoluteFile());
		setMedia(new Media(getAudioFile().toURI().toString()));
		setMediaPlayer(new MediaPlayer(getMedia()));
		setMediaView(new MediaView());
		getMediaView().setMediaPlayer(getMediaPlayer());
		getMediaPlayer().setOnReady(new Runnable() {
			public void run() {
				setDuration(getMediaPlayer().getMedia().getDuration());
				updateValues();
			}
		});
		this.mediaPlayer.play();
	}

	public void resetCounter() {
		// TODO - implement CassetteDeck_Basic.resetCounter
//		throw new UnsupportedOperationException();
//        add

	}

	public void stop() {this.mediaPlayer.stop();}
	public void record() {
//		this.mediaPlayer.pause();
	

	}

	public void eject() { //TODO change to insert
	        System.out.println("insert");
			DirectoryChooser dc = new DirectoryChooser();
			File musicFile = dc.showDialog(null);
			if (musicFile.isDirectory()) {
				listSongs = musicFile.listFiles();
			}
			System.out.println("files :"+ listSongs.length);
			changeState(new ReadyState(this));
	}

	public void changeState(DeckState deckState) {
		this.deckState = deckState;
	}

	public boolean isPlaying() {
		return playing;
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public MediaPlayer getMediaPlayer() {
		return mediaPlayer;
	}

	public void setMediaPlayer(MediaPlayer mediaPlayer) {
		this.mediaPlayer = mediaPlayer;
	}

	public MediaView getMediaView() {
		return mediaView;
	}

	public void setMediaView(MediaView mediaView) {
		this.mediaView = mediaView;
	}

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
//	@Override
//	public void OpenFailPanel() {
//
//	}


	public File[] getListSongs() {
		return listSongs;
	}

	public void setListSongs(File[] listSongs) {
		this.listSongs = listSongs;
	}

	public int getCurrentSong() {
		return currentSong;
	}

	public void setCurrentSong(int currentSong) {
		this.currentSong = currentSong;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public boolean isInsert() {
		return isInsert;
	}

	public void setInsert(boolean insert) {
		isInsert = insert;
	}

	public File getAudioFile() {
		return audioFile;
	}

	public void setAudioFile(File audioFile) {
		this.audioFile = audioFile;
	}
}