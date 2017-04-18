//Class:      CS1302/08
//Term:       Spring 2017
//Name:       Logan Thompson
//Instructor: Monisha Verma
//Assignment: Lab6

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PalindromeSwing extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        // Create a pane
        Pane pane = new Pane();

        /*  Create a circle with center at 0, 0 and radius 10
            set the color of the circle to be Orange
        */
        Circle circle = new Circle(0, 0, 10);
        circle.setFill(Color.ORANGE);

         /* Create an Arc with center at 125, 100 and appropriate x and y
            radii, starting angle and length
            Set the color of this arc as White and its outline as Black
        */
        Arc arc = new Arc(125.0, 100.0, 125.0, 75.0, 225.0, 90.0);
        arc.setFill(Color.WHITE);
        arc.setStroke(Color.BLACK);


        // Add Arc and then circle to the pane
        pane.getChildren().addAll(arc, circle);

        /*  Create a path transition and set its Duration, path, node,
            Orientation, CycleCount and AutoReverse properties
        */

        PathTransition pathTransition = new PathTransition(new Duration(1000), arc, circle);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(true);
        // Start animation
        pathTransition.play();

        // create event handlers for Mouse Pressed and MouseReleased events
        //Hint: use Lambda expressions
        pane.setOnMousePressed(e -> pathTransition.pause());
        pane.setOnMouseReleased(e -> pathTransition.play());

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setTitle("Palindrome Swing"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

}