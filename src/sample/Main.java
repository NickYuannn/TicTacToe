package sample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;

import java.io.FileWriter;
import java.util.ArrayList;
import java.io.File;
import java.io.Writer;
import java.io.*;
import java.util.Scanner;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("TicTacToe");
        new pickPlayer(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
