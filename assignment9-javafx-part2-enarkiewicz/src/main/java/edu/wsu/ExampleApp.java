package edu.wsu;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ExampleApp extends Application {
  private BorderPane borderPane;

  @Override
  public void start(Stage stage) {
    AnalogClockPane clock = new AnalogClockPane();
    DigitalClockPane clock2 = new DigitalClockPane();
    Button button = new Button("Switch to Digital");
    Button button2 = new Button("Switch to Analog");

    //analog to Digital
    button.setOnAction(event ->{
      borderPane.setTop(new StackPane(button2));
      borderPane.setCenter(clock2);
    });

    //digital to analog
    button2.setOnAction(event ->{
      borderPane.setTop(new StackPane(button));
      borderPane.setCenter(clock);
    });

    //Update both clocks
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e->{
      clock.setCurrentTime();
      clock2.setCurrentTime();
    }));
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();

    Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(1), e->{
      clock2.resizeText();
    }));
    timeline2.setCycleCount(Timeline.INDEFINITE);
    timeline2.play();

    borderPane = new BorderPane();
    borderPane.setCenter(clock2);
    borderPane.setTop(new StackPane(button2));
    Scene scene = new Scene(borderPane, 600, 400);
    stage.setScene(scene);
    stage.show();
  }
}
