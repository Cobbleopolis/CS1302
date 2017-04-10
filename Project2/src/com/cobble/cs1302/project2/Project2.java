//Class:      CS1301/08
//Term:       Spring 2017
//Name:       Logan Thompson
//Instructor: Monisha Verma
//Assignment: Project 2 | Option 2
package com.cobble.cs1302.project2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Random;

public class Project2 extends Application {

    static Random rand = new Random(System.currentTimeMillis());

    static final int BOARD_WIDTH = 4;

    static final int BOARD_HEIGHT = 4;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Card Game");
        BorderPane root = new BorderPane();
        root.setCenter(getGridPane());
        root.setBottom(getInfoPane(primaryStage));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private static GridPane getGridPane() {
        GridPane gridPane = new GridPane();
        Card[][] cardArray = getRandomCardArray();
        for (int y = 0; y < cardArray.length; y++)
            for (int x = 0; x < cardArray[y].length; x++) {
                Card card = cardArray[y][x];
                gridPane.add(new Label(card.getSuit() + " | " + card.getRank()), x, y);
            }
        return gridPane;
    }

    private static BorderPane getInfoPane(Stage primaryStage) {
        BorderPane infoPane = new BorderPane();
        Button closeButton = new Button("Exit");
        closeButton.setOnAction(event ->
                primaryStage.fireEvent(new WindowEvent(primaryStage, WindowEvent.WINDOW_CLOSE_REQUEST))
        );
        infoPane.setRight(closeButton);
        return infoPane;
    }

    private static Card[][] getRandomCardArray() {
        Card[][] cardArray = new Card[BOARD_HEIGHT][BOARD_WIDTH];
        Card[] deck = Card.getFullDeck(rand.nextInt(Card.DECK_SIZE) + (Card.MAX_SHUFFLE_COUNT - Card.DECK_SIZE));
        for (int i = 0; i < (BOARD_WIDTH * BOARD_WIDTH) / 2; i++) {
            for (int j = 0; j < 2; j++) {
                int xLoc;
                int yLoc;
                do {
                    xLoc = rand.nextInt(BOARD_WIDTH);
                    yLoc = rand.nextInt(BOARD_HEIGHT);
                } while (cardArray[yLoc][xLoc] != null);
                cardArray[yLoc][xLoc] = deck[i];
            }
        }
        return cardArray;
    }
}
