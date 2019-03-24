package Class_Diagram_CassetteDeck.States;

import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.CassetteDeck_Basic;
import Class_Diagram_CassetteDeck.Options.*;

public class PreviousSongState extends DeckState {


	/**
	 * @param cassetteDeck_Basic
	 */
	PreviousSongState(CassetteDeck_Basic cassetteDeck_Basic) {
		super(cassetteDeck_Basic);
	}

	@Override
	public void onHold() {

	}

	@Override
	public void onPlay() {

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

	public void onPreviousSong() {
		// TODO - implement PreviousSongState.onPreviousSong
		throw new UnsupportedOperationException();
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
	public void previousSong(SongDetection songDetection) {
		// TODO - implement PreviousSongState.previousSong
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param songDetection
	 */
	public void signalChangeState(SongDetection songDetection) {
		// TODO - implement PreviousSongState.signalChangeState
		throw new UnsupportedOperationException();
	}

//	@Override
//	public void OpenFailPanel() {
//
//	}
}