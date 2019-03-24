package sample;
import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.basic_button.PauseButton;
import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.basic_button.PlayButton;
import Class_Diagram_CassetteDeck.UI.CheckBox;
import Class_Diagram_CassetteDeck.UI.UI_Singleton;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main extends Application {

    BorderPane borderPane;
    Scene scene;
    UI_Singleton ui_singleton;
    Clip clip;
    String status;
    Long currentFrame;


    @Override
    public void start(Stage primaryStage) throws Exception{

        ui_singleton = UI_Singleton.getInstance();

//        borderPane = new BorderPane();
//        borderPane.setTop(createHBox());
//        scene = new Scene(borderPane, 650, 500);
//        primaryStage.setScene(scene);
//        CassetteDeck_Basic cassetteDeck_basic = new CassetteDeck_Basic();

//        String path = new File("sounds/akram.mp3").getAbsolutePath();
//        Media media = new Media(new File(path).toURI().toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(media);

        primaryStage.setScene(ui_singleton.getScene());


        primaryStage.show();






    }


    public static void main(String[] args) {
        launch(args);
    }

//    private VBox createMenu() {
//        List<String> checkBoxListNames = new ArrayList<>(Arrays.asList("Built-in stereo speakers","Built-in microphone","Auto-Reverse","Double-Deck","Song Detection","Recording functionalty"));
//        ListView<CheckBox> listView = new ListView<>();
//
//        VBox vBoxCheckBoxList = new VBox();
//        vBoxCheckBoxList.getChildren().add(new Label("Optional feature"));
//
//        checkBoxListNames.forEach(checkBoxName -> {
//            CheckBox checkBox = new CheckBox();
//            checkBox.setText(checkBoxName);
//            checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
//                @Override
//                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
//                    if (checkBox.isSelected()) {
//                        checkBox.check();
//                    } else {
//                        checkBox.uncheck();
//                    }
//                }
//            });
//
//
//            vBoxCheckBoxList.getChildren().add(checkBox);
//            listView.getItems().add(checkBox);
//        });
//
//        Button launchButton = new Button("Launch Similator");
//        vBoxCheckBoxList.getChildren().add(launchButton);
//
//        launchButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                for (CheckBox check: listView.getItems()) {
//                    if (check.isSelected()) {
//                        check.check();
//                        try {
//                            Button returnToConfig = new Button("Return to configuration screen");
//                            returnToConfig.setOnAction(new EventHandler<ActionEvent>() {
//                                @Override
//                                public void handle(ActionEvent event) {
//                                    ui_singleton.getBorderPane().setCenter(createMenu());
//                                    ui_singleton.getBorderPane().setBottom(null);
////                                    scene.setRoot(borderPane);
//                                }
//                            });
//
//                            Button failurePanel = new Button("Failure panel");
//                            failurePanel.setOnAction(new EventHandler<ActionEvent>() {
//                                @Override
//                                public void handle(ActionEvent event) {
//                                    ui_singleton.getBorderPane().setCenter(createFailureMenu());
//                                    //borderPane.set.Bottom(null);
//                                    ui_singleton.getScene().setRoot( ui_singleton.getBorderPane());
//                                }
//                            });
//                            HBox box = createHBox();
//                            box.getChildren().add(returnToConfig);
//                            box.getChildren().add(failurePanel);
//                            ui_singleton.getBorderPane().setBottom(box);
//                            ui_singleton.getBorderPane().setCenter(createDeckOne());
//                            //scene.setRoot(createDeckOne());
//                        } catch (FileNotFoundException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        });
//
//
//        return vBoxCheckBoxList;
//
//    }

//    private VBox createDeckOne() throws FileNotFoundException {
//        Image image = new Image(new FileInputStream("images/deck1.png"));
//
//        //Setting the image view
//        ImageView imageView = new ImageView(image);
//
//        //Setting the position of the image
//        imageView.setX(50);
//        imageView.setY(25);
//
//        //setting the fit height and width of the image view
//        imageView.setFitHeight(455);
//        imageView.setFitWidth(500);
//
//        //Setting the preserve ratio of the image view
//        imageView.setPreserveRatio(true);
//
//        //Creating a Group object
//        VBox root = new VBox();
//        HBox buttonList = new HBox();
//
//        PlayButton playButton = new PlayButton(this.sound);
//        PauseButton pauseButton = new PauseButton(this.sound);
//        buttonList.getChildren().addAll(playButton, pauseButton);
//        root.getChildren().addAll(imageView,buttonList);
//        createTimer(13193903);
//
//
//        return root;
//    }

    private VBox createFailureMenu() {
        List<String> checkBoxListNames = new ArrayList<>(Arrays.asList("Cassette holder cannot open/close","Cassette is stuck","Input radio id not working","Button counter"));
        ListView<CheckBox> listView = new ListView<>();

        VBox vBoxCheckBoxList = new VBox();
        vBoxCheckBoxList.getChildren().add(new Label("Optional feature"));

        checkBoxListNames.forEach(checkBoxName -> {
            CheckBox checkBox = new CheckBox();
            checkBox.setText(checkBoxName);
            checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (checkBox.isSelected()) {
                        checkBox.check();
                    } else {
                        checkBox.uncheck();
                    }
                }
            });


            vBoxCheckBoxList.getChildren().add(checkBox);
            listView.getItems().add(checkBox);
        });

        Button resetButton = new Button("Reset");
        vBoxCheckBoxList.getChildren().add(resetButton);

        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (CheckBox check: listView.getItems()) {
                   check.setSelected(Boolean.FALSE);
                }
            }
        });

        return vBoxCheckBoxList;
    }

    private HBox createHBox(){
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");
        return  hbox;
    }

    private void createTimer(long endTime) {
//        long endTime = endTime;

//        DateFormat timeFormat = new SimpleDateFormat( "HH:mm:ss" );
//        final Timeline timeline = new Timeline(
//                new KeyFrame(
//                        Duration.millis( 500 ),
//                        event -> {
//                            final long diff = endTime - System.currentTimeMillis();
//                            if ( diff < 0 ) {
//                                //  timeLabel.setText( "00:00:00" );
//                                timeLabel.setText( timeFormat.format( 0 ) );
//                            } else {
//                                timeLabel.setText( timeFormat.format( diff ) );
//                            }
//                        }
//                )
//        );
//        timeline.setCycleCount( Animation.INDEFINITE );
//        timeline.play();

        Label timeLabel = new Label();
        ui_singleton.getBorderPane().setRight(timeLabel);
        DateFormat timeFormat = new SimpleDateFormat( "HH:mm:ss" );

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                final long diff = endTime - System.currentTimeMillis();
                System.out.println(timeFormat.format( diff ));
//                if ( diff < 0 ) {
//                    timeLabel.setText( timeFormat.format( 0 ) );
//                } else {
//                    timeLabel.setText( timeFormat.format( diff ) );
//                }
            }
        }, 0, 1000);
    }


}
