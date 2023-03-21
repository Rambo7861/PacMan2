package com.example.pacman2;

import com.example.pacman2.kart.*;
import com.example.pacman2.player.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Game extends HelloApplication {

    int test = 0;
    Text score = new Text("Score: "  + test);
    BorderPane screen = new BorderPane();
    KartPane kart = new KartPane();


    public Game() throws FileNotFoundException {
    }

    @Override
    public void start(Stage stage) throws IOException {
        Pacman pacman = new Pacman();

        Scene scene = new Scene(screen, 972, 972);
        stage.setScene(scene);
        stage.setResizable(false);

        // legger til knapper som gjør at du kan bevege pacman
        scene.setOnKeyPressed(e->pacman.pressHandler(e));


        // velger hvor fort eller sakte loopen oppdaterer
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), e-> Update()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        // legger til bilde av av de forskjellige objektene i spillet.
        kart.getChildren().addAll(new Ghost());
        kart.getChildren().addAll(new Ghost2());
        kart.getChildren().addAll(new Ghost3());
        kart.getChildren().addAll(new Ghost4());
        kart.getChildren().addAll(pacman);
        kart.getChildren().addAll(new Bigdot());
        kart.getChildren().addAll(new Bigdot2());
        kart.getChildren().addAll(new Bigdot3());
        kart.getChildren().addAll(new Bigdot4());

        stage.setTitle("pacman");
        stage.show();
    }

    // game loop
    public void Update() {
        screen.setCenter(kart);
        screen.setTop(score);

        // dette var bare for å teste loopen
        // test++;
        // score.setText("Score: "  + test);

    }

    public static void main(String[] args) {
        launch(args);
    }
}