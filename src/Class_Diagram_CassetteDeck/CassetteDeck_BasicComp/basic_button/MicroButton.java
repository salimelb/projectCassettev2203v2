package Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.basic_button;

//public class MicroButton {
//}
import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.CassetteDeck_Basic;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContentDisplay;

public class MicroButton extends AbstractButton {
    final static String iconName = "mic.png";

    private SimpleBooleanProperty microOn = new SimpleBooleanProperty(true);

    public MicroButton(CassetteDeck_Basic cassetteDeck_basic) {
        super(iconName);
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t){
                microOn.set(!microOn.get());
            }
        });

        microOn.addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> ov,
                                Boolean t, Boolean t1)
            {
                if (cassetteDeck_basic.isOn() & cassetteDeck_basic.isInsert()) {
                    if (t1) {
                        setText("ON");
                        setStyle("-fx-background-color: green;-fx-text-fill:white;");
                        setContentDisplay(ContentDisplay.RIGHT);
//                    cassetteDeck_basic.getState().ledON();

                    } else {
                        setText("OFF");
                        setStyle("-fx-background-color: grey;-fx-text-fill:black;");
                        setContentDisplay(ContentDisplay.LEFT);
                        cassetteDeck_basic.getCurrentLabelState().setText("-----");
//                    cassetteDeck_basic.getState().ledOFF();

                    }
                }
            }
        });

        microOn.set(false);

    }

    public SimpleBooleanProperty switchOnProperty() { return microOn; }
}