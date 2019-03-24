package Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.basic_button;

import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.CassetteDeck_Basic;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StopButton extends AbstractButton {
    final static String iconName = "stop-icon.png";

    public StopButton(CassetteDeck_Basic cassetteDeck_basic) {
        super(iconName);
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (cassetteDeck_basic.isOn() & cassetteDeck_basic.isInsert()){
                    cassetteDeck_basic.getCurrentLabelState().setText("Stop");
                    cassetteDeck_basic.getState().onStop();
                }

            }
        });
    }

}