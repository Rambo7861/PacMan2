package com.example.pacman2;

import com.example.pacman2.kart.*;
import com.example.pacman2.player.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.shape.Circle;

public class Game extends HelloApplication {

    int matrix [][] = {
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,0,0,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
        {0,1,0,0,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
        {0,1,0,0,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0},
        {0,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0},
        {0,1,1,1,1,1,1,0,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,1,0},
        {0,0,0,0,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0},
        {1,1,1,1,1,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,1,1,1,1,1},
        {1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,1,0,1,1,1,1,1},
        {1,1,1,1,1,0,1,0,1,0,0,0,1,1,0,0,0,1,0,0,1,0,1,1,1,1,1},
        {0,0,0,0,0,0,1,0,1,0,1,1,1,1,1,1,0,1,0,0,1,0,0,0,0,0,0},
        {1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1},
        {0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0},
        {1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,1,0,1,1,1,1,1},
        {1,1,1,1,1,0,1,0,1,0,1,0,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1},
        {1,1,1,1,1,0,1,0,1,0,1,0,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1},
        {0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,0},
        {0,1,1,1,1,1,1,1,1,0,1,0,0,0,0,1,0,1,1,1,1,1,1,1,1,1,0},
        {0,1,0,0,1,0,1,0,1,0,1,0,0,0,0,1,0,1,0,0,1,0,0,0,0,1,0},
        {0,1,0,0,1,0,1,0,1,0,1,1,0,0,1,1,0,1,0,0,1,0,0,0,0,1,0},
        {0,1,0,0,1,0,1,0,1,1,1,1,0,0,1,1,1,1,0,0,1,0,0,0,0,1,0},
        {0,1,0,0,1,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };

    enum Directions {LEFT, RIGHT, UP, DOWN, IDLE}
    final int TILE_SIZE = 40;
    final int velo = 2;
    final int enemyVelo = 4;

    int pX = 1;
    int pActualX = 60;
    int pY = 1;
    int pActualY = 60;

    int ghostX = 4;
    int ghostActualX = 4 * TILE_SIZE + 20;
    int ghostActualY = 1 * TILE_SIZE + 20;
    Directions ghostDirection = Directions.RIGHT;
    int ghostY = 1;

    int score = 0;

    int test = 0;
    Text poeng = new Text("Score: "  + test);
    BorderPane screen = new BorderPane();
    KartPane kart = new KartPane();

    Food[] foodArr = {new Food(1, 3, 1),new Food(1, 4, 1), new Food(1, 5, 1),new Food(1, 6, 1),new Food(1, 7, 1), new Food(1, 2, 2)};


    public int checkFood(){
        for (Food food: foodArr) {
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

        // legger til metode for vegg kollisjon
        scene.setOnKeyPressed( event-> pacman.handleKeyPressed(event));

        //

        // velger hvor fort eller sakte loopen oppdaterer
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(20), e-> Update()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        // legger til bilde av av de forskjellige objektene i spillet.
        kart.getChildren().addAll(new Ghost());
        kart.getChildren().addAll(new Ghost2());
        kart.getChildren().addAll(new Ghost3());
        kart.getChildren().addAll(new Ghost4());
        kart.getChildren().addAll(pacman);
        // kart.getChildren().addAll(new Bigdot());
        kart.getChildren().addAll(new Bigdot2());
        kart.getChildren().addAll(new Bigdot3());
        kart.getChildren().addAll(new Bigdot4());


        stage.setTitle("pacman");
        stage.show();
    }

    // game loop
    public void Update() {

        screen.setCenter(kart);
        screen.setTop(poeng);

        for (Food food : foodArr) {
            if (food.active) {
                kart.getChildren().add((new Circle(food.x * TILE_SIZE + 20, food.y * TILE_SIZE + 20, food.type * 5, Color.YELLOW)));
            }
        }
        score += checkFood();
        kart.getChildren().add(new Circle(pActualX, pActualY, TILE_SIZE / 5 - 2, Color.PINK));

        // dette var bare for å teste loopen
        // test++;
        // score.setText("Score: "  + test);

        if (ghostDirection == Directions.LEFT && ghostActualX != (ghostX * TILE_SIZE) + 20) {
            ghostActualX -= enemyVelo;
        } else if (ghostDirection == Directions.RIGHT && ghostActualX != (ghostX * TILE_SIZE) + 20) {
            ghostActualX += enemyVelo;
        } else if (ghostDirection == Directions.UP && ghostActualY != (ghostY * TILE_SIZE) + 20) {
            ghostActualY -= enemyVelo;
        } else if (ghostDirection == Directions.DOWN && ghostActualY != (ghostY * TILE_SIZE) + 20) {
            ghostActualY += enemyVelo;
        }
        //else {
        //    moveGhost();
        //}
    }

    public static void main(String[] args) {
        launch(args);
    }
}