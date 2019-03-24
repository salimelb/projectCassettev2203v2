package Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.basic_button;

import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.CassetteDeck_Basic;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EjectButton extends AbstractButton {
    final static String iconName = "eject-icon.png";

    public EjectButton(CassetteDeck_Basic cassetteDeck_basic) {
        super(iconName);
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                if (cassetteDeck_basic.isOn())
//                    cassetteDeck_basic.eject();
                if (cassetteDeck_basic.getAudioFile() == null) {
                    cassetteDeck_basic.eject();
                    cassetteDeck_basic.getCurrentLabelState().setText("cassette inserer");
                    cassetteDeck_basic.setInsert(true);
                }else {
                    cassetteDeck_basic.setAudioFile(null);
                    cassetteDeck_basic.getCurrentLabelState().setText("pas de cassette");
                    cassetteDeck_basic.getMediaPlayer().stop();
                    cassetteDeck_basic.setInsert(false);
                }
            }
        });
    }
}