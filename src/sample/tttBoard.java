package sample;
import com.sun.org.apache.xpath.internal.operations.Bool;
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
import java.util.Random;
import java.util.Scanner;
public class tttBoard {
    public static int turn = 0;
    Stage yvs;
    public static int rowToChange;
    public static int colToChange;
    public static String computerPlays;
    public static String playerPlays;

    public tttBoard(Stage yuanViewStage)
    {
        //heads is 0 and tails is 1
        turn = 0;
        yvs = yuanViewStage;
        Button[][] buttons = new Button[3][3];
        for (int row = 0; row < buttons.length; row++)
        {
            for (int col = 0; col < buttons[row].length; col++)
            {
                Button boxB = new Button("-");
                boxB.setMinSize(50, 50);
                boxB.setOnAction(event -> {
                    if (boxB.getText().isEmpty() || boxB.getText().equals("-"))
                    {
                        if (turn == 0)
                        {
                            System.out.println("Turn is equal to " + turn);
                            boxB.setText("X");
                            turn++;
                            check(buttons);
                        }
                        else if (turn == 1)
                        {
                            boxB.setText("O");
                            System.out.println("Turn is equal to " + turn);
                            turn--;
                            check(buttons);
                        }
                    }
                });
                buttons[row][col] = boxB;
            }
        }

        GridPane root = new GridPane();
        Scene scene = new Scene(root, 200, 200);
        root.setHgap(25);
        root.setVgap(25);
        GridPane nickGrid = new GridPane();

        for (int row = 0; row < buttons.length; row++)
        {
            for (int col = 0; col < buttons[row].length; col++)
            {
                nickGrid.add(buttons[row][col], row, col);
            }
        }
        root.add(nickGrid, 1, 1);
        yuanViewStage.setScene(scene);
        yuanViewStage.show();
    }

    public tttBoard(Stage yuanViewStage, String thePlayer)
    {
        Random r = new Random();
        rowToChange = r.nextInt(3);
        colToChange = r.nextInt(3);
        //heads is 0 and tails is 1
        turn = 0;
        yvs = yuanViewStage;
        String player = thePlayer;
        computerPlays = "";
        if (thePlayer.equals("X"))
        {
            computerPlays = "O";
        }
        else{
            computerPlays = "X";
        }
        Button[][] buttons = new Button[3][3];
        if (thePlayer.equals("X"))
        {
            for (int row = 0; row < buttons.length; row++)
            {
                for (int col = 0; col < buttons[row].length; col++)
                {
                    Button boxB = new Button("-");
                    boxB.setMinSize(50, 50);
                    boxB.setOnAction(event -> {
                        if (boxB.getText().isEmpty() || boxB.getText().equals("-"))
                        {
                            boxB.setText(player);
                            check(buttons);

                            System.out.println(rowToChange +" "+colToChange);
                            if (buttons[rowToChange][colToChange].getText().equals("-"))
                            {
                                buttons[rowToChange][colToChange].setText(computerPlays);
                                System.out.println("1st button made");
                                check(buttons);
                                rowToChange = r.nextInt(3);
                                colToChange = r.nextInt(3);
                            }
                            else
                            {
                                while(!buttons[rowToChange][colToChange].getText().equals("-"))
                                {
                                    rowToChange = r.nextInt(3);
                                    colToChange = r.nextInt(3);
                                    if (buttons[rowToChange][colToChange].getText().equals("-"))
                                    {
                                        buttons[rowToChange][colToChange].setText(computerPlays);
                                        check(buttons);
                                        break;
                                    }
                                }
                            }

                        }
                    });
                    buttons[row][col] = boxB;
                }
            }
        }
        if (thePlayer.equals("O"))
        {

            for (int row = 0; row < buttons.length; row++)
            {
                for (int col = 0; col < buttons[row].length; col++) {
                    Button boxB = new Button("-");
                    boxB.setMinSize(50, 50);
                    boxB.setOnAction(event -> {
                        if (boxB.getText().isEmpty() || boxB.getText().equals("-"))
                        {
                            boxB.setText(player);
                            check(buttons);
                            //System.out.println(rowToChange +" "+colToChange);
                            if (buttons[rowToChange][colToChange].getText().equals("-"))
                            {
                                buttons[rowToChange][colToChange].setText(computerPlays);
                                System.out.println("1st button made");
                                check(buttons);
                                rowToChange = r.nextInt(3);
                                colToChange = r.nextInt(3);
                            }
                            else
                            {
                                while(!buttons[rowToChange][colToChange].getText().equals("-"))
                                {
                                    rowToChange = r.nextInt(3);
                                    colToChange = r.nextInt(3);
                                    if (buttons[rowToChange][colToChange].getText().equals("-"))
                                    {
                                        buttons[rowToChange][colToChange].setText(computerPlays);
                                        check(buttons);
                                        break;
                                    }
                                }
                            }

                        }
                    });
                    buttons[row][col] = boxB;
                }

            }
            System.out.println(rowToChange + " " + colToChange + " this is the first X");
            buttons[rowToChange][colToChange].setText("X");
        }

        GridPane root = new GridPane();
        Scene scene = new Scene(root, 300, 300);
        root.setHgap(25);
        root.setVgap(25);
        GridPane nickGrid = new GridPane();
        Button reset = new Button("Reset");
        root.add(reset, 5 ,5);
        reset.setOnAction(event -> {
            new tttBoard(yuanViewStage, player);
        });

        //this makes the play area
        for (int row = 0; row < buttons.length; row++)
        {
            for (int col = 0; col < buttons[row].length; col++)
            {
                nickGrid.add(buttons[row][col], row, col);
            }
        }
        root.add(nickGrid, 1, 1);
        yuanViewStage.setScene(scene);
        yuanViewStage.show();
    }

    //harder difficulty will try to win and try to block
    public tttBoard(Stage yuanViewStage, String thePlayer, String difficulty)
    {
        turn = 1;
        yvs = yuanViewStage;
        playerPlays = thePlayer;
        if (thePlayer.equals("X"))
        {
            computerPlays = "O";
        }
        else
            computerPlays = "X";
        Button[][] buttons = new Button[3][3];
        for (int row = 0; row < buttons.length; row++)
        {
            for (int col = 0; col < buttons[row].length; col++)
            {
                Button boxB = new Button("-");
                boxB.setMinSize(50, 50);
                boxB.setOnAction(event -> {
                    boxB.setText(playerPlays);
                    check(buttons);

                    compMoveHard(buttons);
                    buttons[rowToChange][colToChange].setText(computerPlays);
                    check(buttons);
                });
                buttons[row][col] = boxB;
            }
        }

        GridPane root = new GridPane();
        Scene scene = new Scene(root, 200, 200);
        root.setHgap(25);
        root.setVgap(25);
        GridPane nickGrid = new GridPane();

        for (int row = 0; row < buttons.length; row++)
        {
            for (int col = 0; col < buttons[row].length; col++)
            {
                nickGrid.add(buttons[row][col], row, col);
            }
        }
        root.add(nickGrid, 1, 1);
        yuanViewStage.setScene(scene);
        yuanViewStage.show();
    }

    public void compMoveHard(Button[][] d) {
        int amountForPlayerToWin = 0;
        int amountForCompToWin = 0;
        boolean foundASpot = false;
        //this works for rows
        for (int row = 0; row < d.length; row++) {
            if ((d[row][0].getText().equals(computerPlays)) && d[row][1].getText().equals(computerPlays) && d[row][2].getText().equals("-"))
            {
                System.out.println("Computer is about to win 00- row");
                rowToChange = row;
                colToChange =2;
                foundASpot = true;
            }
            else if ((d[row][0].getText().equals(computerPlays)) && d[row][1].getText().equals("-") && d[row][2].getText().equals(computerPlays))
            {
                System.out.println("Computer is about to win 0-0 row");
                rowToChange = row;
                colToChange =1;
                foundASpot = true;
            }
            else if ((d[row][0].getText().equals("-")) && d[row][1].getText().equals(computerPlays) && d[row][2].getText().equals(computerPlays))
            {
                System.out.println("Computer is about to win -00 row");
                rowToChange = row;
                colToChange =1;
                foundASpot = true;
            }
            else if ((d[row][0].getText().equals(playerPlays)) && d[row][1].getText().equals(playerPlays) && d[row][2].getText().equals("-"))
            {
                System.out.println("Player is about to win 295 xx- row");
                rowToChange = row;
                colToChange =2;
                foundASpot = true;
            }
            else if ((d[row][0].getText().equals(playerPlays)) && d[row][1].getText().equals("-") && d[row][2].getText().equals(playerPlays))
            {
                System.out.println("Player is about to win 301 x-x row");
                rowToChange = row;
                colToChange =1;
                foundASpot = true;
            }
            else if ((d[row][0].getText().equals("-")) && d[row][1].getText().equals(playerPlays) && d[row][2].getText().equals(playerPlays))
            {
                System.out.println("Player is about to win 307 -xx row");
                rowToChange = row;
                colToChange =1;
                foundASpot = true;
            }
        }

        //this works for columns
        for (int row = 0; row < d.length; row++) {
            if ((d[0][row].getText().equals(computerPlays)) && d[1][row].getText().equals(computerPlays) && d[2][row].getText().equals("-"))
            {
                System.out.println("Computer is about to win 276 00-");
                rowToChange = row;
                colToChange =2;
                foundASpot = true;
            }
            else if ((d[0][row].getText().equals(computerPlays)) && d[1][row].getText().equals("-") && d[2][row].getText().equals(computerPlays))
            {
                System.out.println("Computer is about to win 282 0-0");
                rowToChange = row;
                colToChange =1;
                foundASpot = true;
            }
            else if ((d[0][row].getText().equals("-")) && d[1][row].getText().equals(computerPlays) && d[2][row].getText().equals(computerPlays))
            {
                System.out.println("Computer is about to win 288 -00");
                rowToChange = row;
                colToChange =1;
                foundASpot = true;
            }
            else if ((d[row][0].getText().equals(playerPlays)) && d[row][1].getText().equals(playerPlays) && d[row][2].getText().equals("-"))
            {
                System.out.println("Player is about to win 295 xx-");
                rowToChange = row;
                colToChange =2;
                foundASpot = true;
            }
            else if ((d[row][0].getText().equals(playerPlays)) && d[row][1].getText().equals("-") && d[row][2].getText().equals(playerPlays))
            {
                System.out.println("Player is about to win 301 x-x");
                rowToChange = row;
                colToChange =1;
                foundASpot = true;
            }
            else if ((d[row][0].getText().equals("-")) && d[row][1].getText().equals(playerPlays) && d[row][2].getText().equals(playerPlays))
            {
                System.out.println("Player is about to win 307 -xx");
                rowToChange = row;
                colToChange =1;
                foundASpot = true;
            }
        }
        //if no where to block
        Random r = new Random();
        if (!foundASpot){
            System.out.println("Computer will randomly move");
            rowToChange = r.nextInt(3);
            colToChange = r.nextInt(3);
            while (!d[rowToChange][colToChange].getText().equals("-"))
            {
                rowToChange = r.nextInt(3);
                colToChange = r.nextInt(3);
            }
        }

    }

    public void check(Button[][] d)
    {
        //check for the rows
        boolean win = false;
        String playerWin = "";
        for (int row = 0; row < d.length; row++)
        {
            //System.out.println(d[0][row].getText() + d[1][row].getText() + d[2][row].getText());
            if (d[0][row].getText().equals("X") && d[1][row].getText().equals("X") && d[2][row].getText().equals("X"))
            {
                //System.out.println("One of the rows work");
                win = true;
                playerWin = "player X";
            }
            if (d[0][row].getText().equals("O") && d[1][row].getText().equals("O") && d[2][row].getText().equals("O"))
            {
                //System.out.println("One of the rows work");
                win = true;
                playerWin = "player O";
            }


        }
        //check for the cols
        for (int row = 0; row < d.length; row++)
        {
            if (d[row][0].getText().equals("X") && d[row][1].getText().equals("X") && d[row][2].getText().equals("X"))
            {
                //System.out.println("This column works");
                win = true;
                playerWin = "player X";
            }
            if (d[row][0].getText().equals("O") && d[row][1].getText().equals("O") && d[row][2].getText().equals("O"))
            {
                //System.out.println("This column works");
                win = true;
                playerWin = "player O";
            }
        }

        //check for diag
        if (d[0][0].getText().equals("X") && d[1][1].getText().equals("X") && d[2][2].getText().equals("X"))
        {
            win = true;
            playerWin = "player X";
        }
        if (d[0][0].getText().equals("O") && d[1][1].getText().equals("O") && d[2][2].getText().equals("O"))
        {
            win = true;
            playerWin = "player O";
        }
        if (d[0][2].getText().equals("X") && d[1][1].getText().equals("X") && d[2][0].getText().equals("X"))
        {
            win = true;
            playerWin = "player X";
        }
        if (d[0][2].getText().equals("O") && d[1][1].getText().equals("O") && d[2][0].getText().equals("O"))
        {
            win = true;
            playerWin = "player O";
        }

        if (win)
        {
            new newGame(yvs, playerWin, d);
        }
        else
        {
            int amountOfSpace = 9;
            for (int row = 0; row < d.length; row++)
            {
                for (int col = 0; col < d[row].length; col++)
                {
                    if (!d[row][col].getText().equals("-"))
                    {
                        amountOfSpace--;
                        if (amountOfSpace == 0)
                        {
                            new newGame(yvs, "no one, it was a draw", d);
                        }
                    }
                }
            }
        }

    }
}
