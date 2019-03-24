package Class_Diagram_CassetteDeck.UI;

import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.CassetteDeck_Basic;
import Class_Diagram_CassetteDeck.CassetteDeck_BasicComp.basic_button.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class UI_Singleton {

	private static UI_Singleton ui_singleton = null;
	private Scene scene;
	private BorderPane borderPane;
	private VBox root;
	private PowerButton powerButton;

	Label currentState = new Label();
	private CassetteDeck_Basic cassetteDeck_basic = new CassetteDeck_Basic(currentState);
	private OptionalFeatures optionalFeatures;

//    private Label timeLabel;

	private UI_Singleton() {
		optionalFeatures = new OptionalFeatures();
		borderPane = new BorderPane();
		borderPane.setTop(createHBox("Cassette"));
		powerButton = new PowerButton(cassetteDeck_basic);

       	scene = new Scene(borderPane, 650, 650);
        //borderPane.setBottom(cassetteDeck_basic.getMediaView());
       borderPane.setCenter(optionalFeatures.getOptionalFeaturesVBox());

        optionalFeatures.getLaunchButton().setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
				 root = new VBox();
				try {

					HBox lcd = new HBox();
					lcd.setMaxWidth(400);
					lcd.setPadding(new Insets(10,30,10,30));
					lcd.setSpacing(10);
					Label state = new Label("Status:");
					Label currentDirection =new Label("Direction:");
//					count =new Duration(cassetteDeck_basic.getMediaPlayer().getCurrentTime().toSeconds()) ;
					Label count = new Label("time: " + cassetteDeck_basic.getCurrentTime());
//					System.out.println("COUNTER:"+counter);


//					cassetteDeck_basic.getCurrentTime().toMillis()

					lcd.getChildren().addAll(state,cassetteDeck_basic.getCurrentLabelState(),count);
					lcd.setStyle("-fx-border-color: C0C0C0");
					lcd.setStyle("-fx-background-color: #40E0D0;");
					root.getChildren().addAll(powerButton,lcd,reset());
					//****

//                    Label st = new Label("status");
//					root.getChildren().addAll(currentState,st);
//                    root.getChildren().add(cassetteDeck_basic.lcdDisplay());
					root.getChildren().add(createDeckImage());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

				root.getChildren().add(createButtons(optionalFeatures.getCheckBoxList()));
				root.getChildren().add(cassetteDeck_basic.createMediaBar());
//				root.getChildren().addAll(configScreen(),failurePanel());
				HBox hBox = createHBox("");
				hBox.getChildren().addAll(configScreen(),failurePanel());
				borderPane.setBottom(hBox);
				borderPane.setCenter(root);
			}
		});

	}
	//faire appel au constructeur Singleton
	public static UI_Singleton getInstance() {
		if (ui_singleton == null) ui_singleton = new UI_Singleton();
		return ui_singleton;
	}
	/**
	 * 
	 * @param OptionsSelect
	 */
	public void addOption(int OptionsSelect) {
		// TODO - implement UI_Singleton.addOption
		throw new UnsupportedOperationException();
	}

	public void select() {
		// TODO - implement UI_Singleton.select
		throw new UnsupportedOperationException();
	}


	private HBox createHBox(String title){
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);
		hbox.setStyle("-fx-background-color: #87CEFA;");
//		hbox.setStyle("-fx-background-color: #336699;");
		if (!title.isEmpty()){
			Label label = new Label(title);
			hbox.getChildren().add(label);
		}
		return  hbox;
	}

    private Button reset(){
        Button resetBtn = new Button("Reset Counter");
        resetBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//           reset counter
            }
        });
        return resetBtn;
    }

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public BorderPane getBorderPane() {
		return borderPane;
	}

	public void setBorderPane(BorderPane borderPane) {
		this.borderPane = borderPane;
	}


	private ImageView createDeckImage() throws FileNotFoundException {
		Image image = new Image(new FileInputStream("images/front_cassette.png"));
		//Setting the image view
		ImageView imageView = new ImageView(image);
		//Setting the position of the image
//		imageView.setX(50);
//		imageView.setY(25);
		//setting the fit height and width of the image view
//		imageView.setFitHeight(455);
//		imageView.setFitWidth(500);
		//Setting the preserve ratio of the image view
		imageView.setPreserveRatio(true);
		return imageView;
	}

	private HBox createButtons(List<CheckBox> checkBoxList) {
		HBox buttons = new HBox();
//
		PlayButton playButton = new PlayButton(cassetteDeck_basic);
		PauseButton pauseButton = new PauseButton(cassetteDeck_basic);
		StopButton stopButton = new StopButton(cassetteDeck_basic);
		ForwardButton forwardButton = new ForwardButton(cassetteDeck_basic);
		RewindButton rewindButton = new RewindButton(cassetteDeck_basic);
		EjectButton ejectButton = new EjectButton(cassetteDeck_basic);
//
		buttons.getChildren().addAll(playButton, pauseButton, ejectButton, stopButton, forwardButton,rewindButton);

		if (checkBoxList.size() > 0) {
			checkBoxList.stream().forEach(item -> {
				if (item.getText().equals("Built-in stereo speakers")) {
					NextButton nextButton = new NextButton(cassetteDeck_basic);
					BackButton backButton = new BackButton(cassetteDeck_basic);
					buttons.getChildren().addAll(nextButton,backButton);
				}

//				if (item.getText().equals("Built-in microphone")) {
////					ImageView mic = new ImageView(new Image("mic"));
//					MicroButton mic = new MicroButton(cassetteDeck_basic);
//					root.getChildren().addAll(mic,reset());
//					borderPane.setRight(mic);
//
//				}

				if (item.getText().equals("Auto-Reverse ")) {

				}
//				if (item.getText().equals("Double-Deck")) {
//
//				}
				if (item.getText().equals("Song Detection")) {
					NextButton nextButton = new NextButton(cassetteDeck_basic);
					BackButton backButton = new BackButton(cassetteDeck_basic);
					buttons.getChildren().addAll(nextButton,backButton);

				}
				if (item.getText().equals("Recording functionalty")) {

					RecordButton recordButton = new RecordButton(cassetteDeck_basic);
					MicroButton mic = new MicroButton(cassetteDeck_basic);
//					mic.setPadding(new Insets(5,5,5,5));
					root.getChildren().clear();
					try {
						root.getChildren().addAll(powerButton,reset(),mic,createDeckImage());
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
//					root.getChildren().add(createDeckImage());
//					root.getChildren().add(mic);
					buttons.getChildren().addAll(recordButton);
//					borderPane.getChildren().add(mic);

				}
			});
		}
		return buttons;
	}

	//nizAdd
	private Button configScreen(){
		Button simScreen = new Button("Return to configuration screen");
		simScreen.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!cassetteDeck_basic.isOn()) {
					borderPane.setCenter(optionalFeatures.getOptionalFeaturesVBox());
//					borderPane.setBottom(null);
//				scene.setRoot(borderPane);
				}
			}
		});
		return simScreen;
	}
	//nizAdd
	private Button failurePanel(){
		Button failurePanel = new Button("Failure panel");

		failurePanel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				borderPane.setCenter(createFailureMenu());
				//borderPane.set.Bottom(null);
				scene.setRoot(borderPane);
			}
		});
		return failurePanel;
	}

//nizAdd
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
		vBoxCheckBoxList.getChildren().addAll(resetButton,configScreen());

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


}