package Class_Diagram_CassetteDeck.States;

import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.*;

public class FastRewindState extends DeckState {


	/**
	 * @param cassetteDeck_Basic
	 */
	FastRewindState(CassetteDeck_Basic cassetteDeck_Basic) {
		super(cassetteDeck_Basic);
	}

	@Override
	public void onHold() {

	}

	@Override
	public void onPlay() {
//		if (!cassetteDeck_Basic.isPlaying()) {
			cassetteDeck_Basic.changeState(new PlayingState(cassetteDeck_Basic));
			cassetteDeck_Basic.setPlaying(true);
			cassetteDeck_Basic.play();
//		}

	}

	@Override
	public void onPause() {

	}

	@Override
	public void onStop() {
		cassetteDeck_Basic.changeState(new StopState(cassetteDeck_Basic));
//		cassetteDeck_Basic.setPlaying(false);
		System.out.println(this.cassetteDeck_Basic.getState());
//		cassetteDeck_Basic.play();
		cassetteDeck_Basic.pause();

	}

	public void onFR() {
	}

	@Override
	public void onFF() {
		cassetteDeck_Basic.fastForward();
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
		cassetteDeck_Basic.stop();
		cassetteDeck_Basic.powerOff();

	}


	public void signalChangeState() {
		// TODO - implement FastRewindState.signalChangeState
		throw new UnsupportedOperationException();
	}

}