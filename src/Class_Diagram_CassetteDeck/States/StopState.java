package Class_Diagram_CassetteDeck.States;

import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.*;

public class StopState extends DeckState {


	StopState(CassetteDeck_Basic cassetteDeck_Basic) {
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
//		if (!cassetteDeck_Basic.isPlaying()) {
//			cassetteDeck_Basic.changeState(new PauseState(cassetteDeck_Basic));
//			cassetteDeck_Basic.play();
//		}
	}

	public void onStop() {
	}

	@Override
	public void onFR() {

				cassetteDeck_Basic.changeState(new FastRewindState(cassetteDeck_Basic));
				cassetteDeck_Basic.fastRewind();

	}

	@Override
	public void onFF() {


//		if (!cassetteDeck_Basic.isPlaying()) {
			cassetteDeck_Basic.changeState(new FastForwardState(cassetteDeck_Basic));
//			cassetteDeck_Basic.setPlaying(true);
			cassetteDeck_Basic.fastForward();
//		}
//			cassetteDeck_Basic.changeState(new FastRewindState(cassetteDeck_Basic));
//			cassetteDeck_Basic.fastRewind();

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
		System.out.println("signal is stopping");
	}

}