package Class_Diagram_CassetteDeck.States;

import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.*;

public class PauseState extends DeckState {


	/**
	 * @param cassetteDeck_Basic
	 */
	PauseState(CassetteDeck_Basic cassetteDeck_Basic) {
		super(cassetteDeck_Basic);
	}

	@Override
	public void onHold() {

	}

	@Override
	public void onPlay() {
		System.out.println("onplay in pause");
		cassetteDeck_Basic.changeState(new PlayingState(cassetteDeck_Basic));
		cassetteDeck_Basic.play();

	}

	public void onPause() {
	}

	@Override
	public void onStop() {
//		cassetteDeck_Basic.pause();
		cassetteDeck_Basic.changeState(new StopState(cassetteDeck_Basic));
		System.out.println(this.cassetteDeck_Basic.getState());
		cassetteDeck_Basic.pause();
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
		cassetteDeck_Basic.changeState(new OffState(cassetteDeck_Basic));
		if (cassetteDeck_Basic.getState() != null )System.out.println(this.cassetteDeck_Basic.getState());
		cassetteDeck_Basic.powerOff();

	}


	public void signalChangeState() {
		// TODO - implement PauseState.signalChangeState
		throw new UnsupportedOperationException();
	}

}