package Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.basic_button;

import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.CassetteDeck_Basic;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BackButton extends AbstractButton {
    final static String iconName = "back1.png";

    public BackButton(CassetteDeck_Basic cassetteDeck_basic) {
        super(iconName);
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (cassetteDeck_basic.isOn() & cassetteDeck_basic.isInsert()){
                    cassetteDeck_basic.previousSong();
                    System.out.println("back button pushed");
                }


            }
        });
    }

}