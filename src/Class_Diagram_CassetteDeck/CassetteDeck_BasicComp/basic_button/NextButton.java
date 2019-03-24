package Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.basic_button;

import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.CassetteDeck_Basic;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class NextButton extends AbstractButton {
    final static String iconName = "next1.png";

    public NextButton(CassetteDeck_Basic cassetteDeck_basic) {
        super(iconName);
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (cassetteDeck_basic.isOn() & cassetteDeck_basic.isInsert()){
                    cassetteDeck_basic.nextSong();
//                    cassetteDeck_basic.getState().onNextSong();
                    System.out.println("next button pushed");
                }
            }
        });
    }

}