package Class_Diagram_CassetteDeck.UI;

public class CheckBox extends javafx.scene.control.CheckBox {

    public void check() {
        System.out.println("check :" + this.getText());
	}

	public void uncheck() {
        System.out.println("uncheck :" + this.getText());
	}


}