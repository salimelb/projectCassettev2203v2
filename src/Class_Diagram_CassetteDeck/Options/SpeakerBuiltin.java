package Class_Diagram_CassetteDeck.Options;

import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.CassetteDeck_Basic;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;

public class SpeakerBuiltin extends OptionsSelect {

	private int KnobVolume;
	private int KnobBalance;
//	private Slider balanceKnob,volumeKnob;

//	private CassetteDeck_Basic cassetteDeck_basic = new CassetteDeck_Basic();


//public Hbox creatKnob(){
//
//	Slider balanceKnob = new Slider(-1,1,0);
//	balanceKnob.setBlockIncrement(0.1);
//	balanceKnob.setId("balance");
//	balanceKnob.getStyleClass().add("knobStyle");
//	balanceKnob.valueProperty().addListener(new ChangeListener<Number>() {
//		@Override public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number newValue) {
//			if(mediaPlayer != null) mediaPlayer.setBalance(newValue.doubleValue());
//		}
//	});
//	Slider volumeKnob = new Slider(0,1,1);
//	volumeKnob.setBlockIncrement(0.1);
//	volumeKnob.setId("volume");
//	volumeKnob.getStyleClass().add("knobStyle");
//	volumeKnob.valueProperty().addListener(new ChangeListener<Number>() {
//		@Override public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number newValue) {
//			if(mediaPlayer != null) mediaPlayer.setVolume(newValue.doubleValue());
//		}
//	});
//
//}



	public int volumeUp() {
		// TODO - implement SpeakerBuiltin.volumeUp
		throw new UnsupportedOperationException();
	}

	public int volumeDown() {
		// TODO - implement SpeakerBuiltin.volumeDown
		throw new UnsupportedOperationException();
	}

	public int turnLeft() {
		// TODO - implement SpeakerBuiltin.turnLeft
		throw new UnsupportedOperationException();
	}

	public int turnRight() {
		// TODO - implement SpeakerBuiltin.turnRight
		throw new UnsupportedOperationException();
	}

	public void addSpeakerB() {
		// TODO - implement SpeakerBuiltin.addSpeakerB
		throw new UnsupportedOperationException();
	}

	public void FailSpeaker() {
		// TODO - implement SpeakerBuiltin.FailSpeaker
		throw new UnsupportedOperationException();
	}

	@Override
	public void OpenFailPanel() {

	}
}