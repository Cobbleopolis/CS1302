package com.cobble.cs.test;
/*****************testing Mouse and Key events******/

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Test2Final extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        BorderPane pane1 = new BorderPane();
        pane1.setPrefSize(300, 250);
        Pane pane = new Pane();
        HBox h = new HBox();
        h.setSpacing(10);
        h.setAlignment(Pos.CENTER);

        CheckBox ch1 = new CheckBox("Check1");
        CheckBox ch2 = new CheckBox("Check2");
        h.getChildren().addAll(ch1, ch2);
        pane1.setBottom(h);

        //pane.setPrefSize(300, 250);
        Text t = new Text("CS1302");
        t.setX(50);
        t.setY(50);

        pane.setStyle("-fx-background-color:Aqua");
        pane1.setCenter(pane);
        //Mouse Dragged event for text t
        t.setOnMouseDragged(e -> {
            t.setX(e.getX());
            t.setY(e.getY());

        });
        //KeyPressed event on text t
        t.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case DOWN:
                    t.setY(t.getY() + 10);
                    break;
                case UP:
                    t.setY(t.getY() - 10);
                    break;
                case LEFT:
                    t.setX(t.getX() - 10);
                    break;
                case RIGHT:
                    t.setX(t.getX() + 10);
                    break;
                case BACK_SPACE:
                    if (!t.getText().isEmpty())
                        t.setText(t.getText().substring(0, Math.max(t.getText().length() - 2, 0)));
                    break;
                default:
                    String text = e.getText();
                    if (!text.isEmpty()) {
                        if (e.getCode().isDigitKey() && e.isShiftDown())
                            switch (e.getCode()) {
                                case DIGIT1:
                                    text = "!";
                                    break;
                                case DIGIT2:
                                    text = "@";
                                    break;
                                case DIGIT3:
                                    text = "#";
                                    break;
                                case DIGIT4:
                                    text = "$";
                                    break;
                                case DIGIT5:
                                    text = "%";
                                    break;
                                case DIGIT6:
                                    text = "^";
                                    break;
                                case DIGIT7:
                                    text = "&";
                                    break;
                                case DIGIT8:
                                    text = "*";
                                    break;
                                case DIGIT9:
                                    text = "(";
                                    break;
                                case DIGIT0:
                                    text = ")";
                            }
                        t.setText(t.getText() + (e.isShiftDown() ? text.toUpperCase() : text));
                    }
            }
        });
        //Mouse Clicked event on pane to set the text visible or invisible
        pane.setOnMouseClicked(e -> t.setVisible(!t.isVisible()));

/************		Alternate Mouse Clicked event on pane to add new text every time
 mouse is clicked at a point on the Pane *********************/
/*		pane.setOnMouseClicked(e->{
            Text t1 = new Text();
			t1.setText(t.getText());
			t1.setX(e.getX());
			t1.setY(e.getY());
			pane.getChildren().add(t1);
		});*/

        pane.getChildren().add(t);
        Scene scene = new Scene(pane1);
        primaryStage.setScene(scene);
        primaryStage.show();


        t.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
