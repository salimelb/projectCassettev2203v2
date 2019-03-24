package Class_Diagram_CassetteDeck.States;

import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.CassetteDeck_Basic;
import Class_Diagram_CassetteDeck.Options.*;

public class NextSongState extends DeckState {
	/**
	 * @param cassetteDeck_Basic
	 */
	NextSongState(CassetteDeck_Basic cassetteDeck_Basic) {
		super(cassetteDeck_Basic);
	}

//	private cassetteDeck curCassetteDeck;



	@Override
	public void onHold() {

	}

	@Override
	public void onPlay() {
		cassetteDeck_Basic.changeState(new PlayingState(cassetteDeck_Basic));
		cassetteDeck_Basic.play();

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

	public void onNextSong() {
		// TODO - implement NextSongState.onNextSong
		throw new UnsupportedOperationException();
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


	/**
	 * 
	 * @param songDetection
	 */
	public void signalChangeState(SongDetection songDetection) {
		// TODO - implement NextSongState.signalChangeState
		throw new UnsupportedOperationException();
	}

//	@Override
//	public void OpenFailPanel() {
//
//	}
}