package sample;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;

import java.io.FileWriter;
import java.util.ArrayList;
import java.io.File;
import java.io.Writer;
import java.io.*;
import java.util.Scanner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class pickPlayer {

    public pickPlayer(Stage yuanViewStage)
    {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 200, 200);

        VBox butBox = new VBox();
        root.setCenter(butBox);

        Button twoPlayer = new Button("Play two player");
        Label playComputer = new Label("Play against computer");
        Button playAsX = new Button("Play as X");
        Button playAsO = new Button("Play as O");
        Label signature = new Label("NY");
        Label hardModeLabel = new Label("This is hard mode");
        Button hardPlayAsX = new Button("Play as X");
        Button hardPlayAsO = new Button("Play as O");

        twoPlayer.setOnAction(event -> {
            new tttBoard(yuanViewStage);
        });

        butBox.getChildren().add(signature);
        butBox.getChildren().add(twoPlayer);
        butBox.getChildren().add(playComputer);

        HBox compOptions = new HBox();
        HBox hardCompOptions = new HBox();

        butBox.getChildren().add(compOptions);

        compOptions.getChildren().add(playAsX);
        compOptions.getChildren().add(playAsO);

        butBox.getChildren().add(hardModeLabel);
        butBox.getChildren().add(hardCompOptions);

        hardCompOptions.getChildren().add(hardPlayAsX);
        hardCompOptions.getChildren().add(hardPlayAsO);

        playAsX.setOnAction(event -> {
            new tttBoard(yuanViewStage, "X");
        });
        playAsO.setOnAction(event -> {
            new tttBoard(yuanViewStage, "O");
        });

        hardPlayAsX.setOnAction(event -> {
            new tttBoard(yuanViewStage, "X", "Hard");
        });

        hardPlayAsO.setOnAction(event -> {
            new tttBoard(yuanViewStage, "O", "Hard");
        });

        yuanViewStage.setScene(scene);
        yuanViewStage.show();
    }

}
