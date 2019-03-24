package Class_Diagram_CassetteDeck.States;

import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.CassetteDeck_Basic;
import Class_Diagram_CassetteDeck.Options.*;

public class RecordState extends DeckState {


	/**
	 * @param cassetteDeck_Basic
	 */
	RecordState(CassetteDeck_Basic cassetteDeck_Basic) {
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

	public void onRecord() {
		// TODO - implement RecordState.onRecord
		throw new UnsupportedOperationException();
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

//	@Override
//	public void OpenFailPanel() {
//
//	}
}