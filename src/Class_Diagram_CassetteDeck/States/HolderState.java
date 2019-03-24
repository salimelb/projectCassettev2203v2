package Class_Diagram_CassetteDeck.States;

import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.*;

public class HolderState extends DeckState {

	public void openState() {
		// TODO - implement HolderState.openState
		throw new UnsupportedOperationException();
	}

	public void closeState() {
		// TODO - implement HolderState.closeState
		throw new UnsupportedOperationException();
	}


	 HolderState(CassetteDeck_Basic cassetteDeck_Basic) {
	 	super(cassetteDeck_Basic);

	 }

	@Override
	public void onHold() {

	}

	public void signalChangeState() {
		// TODO - implement HolderState.signalChangeState
		throw new UnsupportedOperationException();
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