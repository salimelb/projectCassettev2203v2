package Class_Diagram_CassetteDeck.States;

import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.*;

public class FastForwardState extends DeckState {




    public  FastForwardState(CassetteDeck_Basic cassetteDeck_Basic) {
        super(cassetteDeck_Basic);

    }

    @Override
    public void onHold() {

    }

    @Override
    public void onPlay() {
            cassetteDeck_Basic.changeState(new PlayingState(cassetteDeck_Basic));
            cassetteDeck_Basic.setPlaying(true);
            System.out.println(this.cassetteDeck_Basic.getState());
            cassetteDeck_Basic.play();


    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

//        if (!cassetteDeck_Basic.isPlaying()) {
            cassetteDeck_Basic.changeState(new StopState(cassetteDeck_Basic));
//            cassetteDeck_Basic.setPlaying(false);
            System.out.println(this.cassetteDeck_Basic.getState());
//            cassetteDeck_Basic.play();
            cassetteDeck_Basic.pause();
//        }
//            cassetteDeck_Basic.changeState(new StopState(cassetteDeck_Basic));
//            cassetteDeck_Basic.setPlaying(false);
//            System.out.println(this.cassetteDeck_Basic.getState());
//            cassetteDeck_Basic.pause();
    }

    @Override
    public void onFR() {
//        if (cassetteDeck_Basic.isPlaying()) {
            cassetteDeck_Basic.fastRewind();
//        }

    }

    public void onFF() {
//        if (cassetteDeck_Basic.isPlaying()) {
//            cassetteDeck_Basic.fastForward();
//        }
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
//        cassetteDeck_Basic.stop();
        cassetteDeck_Basic.powerOff();

    }


	public void signalChangeState() {
		// TODO - implement FastForwardState.signalChangeState
		throw new UnsupportedOperationException();
	}

}