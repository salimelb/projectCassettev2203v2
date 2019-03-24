package Class_Diagram_CassetteDeck.UI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptionalFeatures {

    private VBox optionalFeaturesVBox;
    private List<CheckBox> checkBoxList = new ArrayList<>();
    Button launchButton = new Button("Launch Similator");

    public OptionalFeatures() {
        init();
    }

    private void init() {
        List<String> checkBoxListNames = new ArrayList<>(Arrays.asList("Built-in stereo speakers","Built-in microphone","Auto-Reverse","Double-Deck","Song Detection","Recording functionalty"));


        VBox vBoxCheckBoxList = new VBox();
        vBoxCheckBoxList.getChildren().add(new Label("Optional feature"));

        checkBoxListNames.forEach(checkBoxName -> {
            CheckBox checkBox = new CheckBox();
            checkBox.setText(checkBoxName);
            checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (checkBox.isSelected()) {
                        checkBoxList.add(checkBox);
                        checkBox.check();
                    } else {
                        checkBoxList.remove(checkBox);
                        checkBox.uncheck();
                    }
                }
            });

            vBoxCheckBoxList.getChildren().add(checkBox);
        });


        vBoxCheckBoxList.getChildren().add(launchButton);


        setOptionalFeaturesVBox(vBoxCheckBoxList);
    }

    public VBox getOptionalFeaturesVBox() {
        return optionalFeaturesVBox;
    }

    public void setOptionalFeaturesVBox(VBox optionalFeaturesVBox) {
        this.optionalFeaturesVBox = optionalFeaturesVBox;
    }

    public List<CheckBox> getCheckBoxList() {
        return checkBoxList;
    }

    public void setCheckBoxList(List<CheckBox> checkBoxList) {
        this.checkBoxList = checkBoxList;
    }

    public Button getLaunchButton() {
        return launchButton;
    }
}
