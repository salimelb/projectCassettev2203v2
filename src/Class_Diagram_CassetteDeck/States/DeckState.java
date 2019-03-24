package Class_Diagram_CassetteDeck.States;

import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.*;

public abstract class DeckState {

	CassetteDeck_Basic cassetteDeck_Basic;
	/**
	 * 
	 * @param cassetteDeck_Basic
	 */
	DeckState(CassetteDeck_Basic cassetteDeck_Basic){
		this.cassetteDeck_Basic = cassetteDeck_Basic;
	}

	public abstract void onHold();

	public abstract void onPlay();

	public abstract void onPause();

	public abstract void onStop();

	public abstract void onFR();

	public abstract void onFF();

	public abstract void onRecord();

	public abstract void onNextSong();

	public abstract void onPreviousSong();

	public abstract void ledON();

	public abstract void ledOFF();

}