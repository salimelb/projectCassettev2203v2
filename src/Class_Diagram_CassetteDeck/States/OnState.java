package Class_Diagram_CassetteDeck.States;

import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.*;

public class OnState extends DeckState {


	/**
	 * @param cassetteDeck_Basic
	 */
	public OnState(CassetteDeck_Basic cassetteDeck_Basic) {
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
			System.out.println(this.cassetteDeck_Basic.getState());
			cassetteDeck_Basic.play();
//		}

	}

	@Override
	public void onPause() {
		if (cassetteDeck_Basic.isPlaying()) {
			cassetteDeck_Basic.changeState(new PauseState(cassetteDeck_Basic));
			System.out.println(this.cassetteDeck_Basic.getState());
			cassetteDeck_Basic.pause();
		}

	}

	@Override
	public void onStop() {
//		if (cassetteDeck_Basic.isPlaying()) {
				cassetteDeck_Basic.changeState(new StopState(cassetteDeck_Basic));
				System.out.println(this.cassetteDeck_Basic.getState());
				cassetteDeck_Basic.setPlaying(false);
				cassetteDeck_Basic.pause();
//		}

	}

	@Override
	public void onFR() {
//			if (cassetteDeck_Basic.isPlaying()) {
				cassetteDeck_Basic.changeState(new FastRewindState(cassetteDeck_Basic));
				System.out.println(this.cassetteDeck_Basic.getState());
				cassetteDeck_Basic.setPlaying(false);
				cassetteDeck_Basic.fastRewind();
//			}

	}

	@Override
	public void onFF() {
//		if (cassetteDeck_Basic.isPlaying()) {
			cassetteDeck_Basic.changeState(new FastForwardState(cassetteDeck_Basic));
			System.out.println(this.cassetteDeck_Basic.getState());
			cassetteDeck_Basic.fastForward();
//		}

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

	public void ledON() {
		// TODO - implement OnState.ledON
//		throw new UnsupportedOperationException();
	}

	@Override
	public void ledOFF() {
		cassetteDeck_Basic.changeState(new OffState(cassetteDeck_Basic));
		if (cassetteDeck_Basic.getState() != null )System.out.println(this.cassetteDeck_Basic.getState());
		cassetteDeck_Basic.powerOff();

	}

	/**
	 * 
	 * @param cassetteDeck_Basic
	 */
	public void LedOnState(CassetteDeck_Basic cassetteDeck_Basic) {
		// TODO - implement OnState.LedOnState
		throw new UnsupportedOperationException();
	}

	public void signalChangeState() {
		// TODO - implement OnState.signalChangeState
		throw new UnsupportedOperationException();
	}

}