package Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.basic_button;

import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.CassetteDeck_Basic;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PlayButton extends AbstractButton{
   final static String iconName = "play-icon.png";

    public PlayButton(CassetteDeck_Basic cassetteDeck_basic) {
        super(iconName);
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (cassetteDeck_basic.isOn() & cassetteDeck_basic.isInsert()){
//                if (cassetteDeck_basic.isOn());
                    cassetteDeck_basic.getCurrentLabelState().setText("Play");
                    cassetteDeck_basic.getState().onPlay();
                }

            }
        });
    }



}
