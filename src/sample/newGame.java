package sample;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.w3c.dom.html.HTMLObjectElement;

import javax.swing.*;
import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;

import java.io.FileWriter;
import java.util.ArrayList;
import java.io.File;
import java.io.Writer;
import java.io.*;
import java.util.Scanner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class newGame {

    public newGame(Stage yuanViewStage, String o, Button[][] box)
    {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 250, 200);

        VBox winBox = new VBox();
        root.setCenter(winBox);

        Label congrats = new Label("Winner is " + o);
        Button again = new Button("Play Again");
        Label game = new Label();
        String prevGame = "";

        for (int row = 0; row < box.length; row++)
        {
            prevGame += (box[0][row].getText() + box[1][row].getText() + box[2][row].getText()) + "\n";
        }
        game.setText(prevGame);


        winBox.getChildren().add(congrats);
        winBox.getChildren().add(again);
        winBox.getChildren().add(game);

        again.setOnAction(event -> {
            new pickPlayer(yuanViewStage);
        });


        yuanViewStage.setScene(scene);
        yuanViewStage.show();

    }
}
