//Class:      CS1302/08
//Term:       Spring 2017
//Name:       Logan Thompson
//Instructor: Monisha Verma
//Assignment: HW4-DisplayRandom01

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

public class DisplayRandom01 extends Application {

    private static Random rand = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("DisplayRandom01");
        GridPane pane = new GridPane();
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++) {
                TextField textField = new TextField(Integer.toString(rand.nextInt(2)));
                textField.setPrefWidth(50);
                textField.setAlignment(Pos.CENTER);
                pane.add(textField, i, j);
            }
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }
}