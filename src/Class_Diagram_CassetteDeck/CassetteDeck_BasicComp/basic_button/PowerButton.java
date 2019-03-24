package Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.basic_button;

import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.CassetteDeck_Basic;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;

public class PowerButton extends AbstractButton {
    final static String iconName = "power-icon.png";

    private SimpleBooleanProperty switchedOn = new SimpleBooleanProperty(true);

    public PowerButton(CassetteDeck_Basic cassetteDeck_basic) {
        super(iconName);
//        this.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                //sound.stop();
//                System.out.println("On/Off pushed");
//            }
//        });

        //AddNiz
//        Button powerBtn = new Button();
//        powerBtn.setPrefWidth(40);
        this.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t){
                switchedOn.set(!switchedOn.get());
            }
        });
//        setGraphic(this);
        switchedOn.addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> ov,
                                Boolean t, Boolean t1)
            {
                if (t1)
                {
                    setText("ON");
                    setStyle("-fx-background-color: green;-fx-text-fill:white;");
                    setContentDisplay(ContentDisplay.RIGHT);
                    cassetteDeck_basic.getCurrentLabelState().setText("ON");
                    cassetteDeck_basic.getState().ledON();

                }
                else
                {
                    setText("OFF");
                    setStyle("-fx-background-color: grey;-fx-text-fill:black;");
                    setContentDisplay(ContentDisplay.LEFT);
                    cassetteDeck_basic.getCurrentLabelState().setText("OFF");
                    cassetteDeck_basic.getState().ledOFF();

                }
            }
        });

        switchedOn.set(false);
    }

    public SimpleBooleanProperty switchOnProperty() { return switchedOn; }

    }

//}
