package com.example.pacman2;

import com.example.pacman2.kart.*;
import com.example.pacman2.player.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.shape.Circle;

public class Game extends HelloApplication {

    int pX = 1;
    int pActualX = 60;
    int pY = 1;
    int pActualY = 60;

    final int TILE_SIZE = 40;

    int test = 0;
    Text score = new Text("Score: "  + test);
    BorderPane screen = new BorderPane();
    KartPane kart = new KartPane();

    Food[] foodArr = {new Food(1, 3, 1),new Food(1, 4, 1), new Food(1, 5, 1),new Food(1, 6, 1),new Food(1, 7, 1), new Food(1, 2, 2)};


    public int checkFood(){
        for (Food food: foodArr
        ) {
            if (food.x == pX && food.y == pY) {
                if (food.active == true){
                    food.active = false;
                    return food.type * 100;
                }
            }
        }
        return 0;
    }


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

        for (Food food: foodArr) {
            if (food.active){
                kart.getChildren().add((new Circle(food.x * TILE_SIZE + 20, food.y * TILE_SIZE + 20, food.type *5, Color.YELLOW)));
            }
        }


        // dette var bare for å teste loopen
        // test++;
        // score.setText("Score: "  + test);

    }

    public static void main(String[] args) {
        launch(args);
    }
}