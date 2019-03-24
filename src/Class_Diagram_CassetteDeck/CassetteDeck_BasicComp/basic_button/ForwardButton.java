package Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.basic_button;

        import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.CassetteDeck_Basic;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;

public class ForwardButton extends AbstractButton {
    final static String iconName = "forward-icon.png";

    public ForwardButton(CassetteDeck_Basic cassetteDeck_basic) {
        super(iconName);
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (cassetteDeck_basic.isOn() & cassetteDeck_basic.isInsert()) {
                    System.out.println("FF button pushed");
                    cassetteDeck_basic.getCurrentLabelState().setText("FF");
                    cassetteDeck_basic.getState().onFF();
                }

            }
        });
    }

}