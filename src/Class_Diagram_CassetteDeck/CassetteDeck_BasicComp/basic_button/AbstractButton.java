package Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.basic_button;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.sound.sampled.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class AbstractButton extends Button {

   final static String path = "images/icons/";

    public AbstractButton(String iconName){
        Image image_pl = null;
        try {
            image_pl = new Image(new FileInputStream(path + iconName));
        } catch (FileNotFoundException e) {
            System.out.println("File not find "+ e.getMessage());
        }
        ImageView imageView = new ImageView(image_pl);
        this.setGraphic(imageView);

//        this.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//
//            }
//        });

    }


}
