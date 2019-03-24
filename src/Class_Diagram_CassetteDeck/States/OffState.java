package Class_Diagram_CassetteDeck.States;

import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.*;

public class OffState extends DeckState {

	/**
	 * @param cassetteDeck_Basic
	 */
	public OffState(CassetteDeck_Basic cassetteDeck_Basic) {
		super(cassetteDeck_Basic);
	}

	public void LedOff() {
		// TODO - implement OffState.LedOff
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cassetteDeck_Basic
	 */
	public void LedOffState(CassetteDeck_Basic cassetteDeck_Basic) {
		// TODO - implement OffState.LedOffState
		throw new UnsupportedOperationException();
	}

	public void signalChangeState() {
		// TODO - implement OffState.signalChangeState
		throw new UnsupportedOperationException();
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

	@Override
	public void onPreviousSong() {

	}

	@Override
	public void ledON() {
		cassetteDeck_Basic.changeState(new OnState(cassetteDeck_Basic));

		if (cassetteDeck_Basic.getState() != null )System.out.println(this.cassetteDeck_Basic.getState());
//		cassetteDeck_Basic.lcdDisplay();
		cassetteDeck_Basic.powerOn();

	}

	@Override
	public void ledOFF() {

	}
}