/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperatureConversion;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Mahmoud Emawi
 */
public class TemperatureConvert extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        

        Text text = new Text("Enter Celsius temperature :");
        TextField textField = new TextField("");
        ToggleGroup group = new ToggleGroup();
        RadioButton rb1 = new RadioButton("Fahrenheit");
        rb1.setToggleGroup(group);
        rb1.setSelected(true);
        RadioButton rb2 = new RadioButton("Kelvin");
        rb2.setToggleGroup(group);
        rb1.setPadding(new Insets(5, 5, 5, 5));
        rb2.setPadding(new Insets(5, 5, 5, 5));
        Label response = new Label("Select type to convert");
        rb1.setOnAction(event -> {
            double temp = Double.parseDouble(textField.getText());
            response.setText("New Temperature in is :"+((temp*9/5) + 32));
            
            
        });
        rb2.setOnAction(event -> {
            double temp = Double.parseDouble(textField.getText());
            response.setText("New Temperature in is :"+(temp+273.15));
            
        });
        root.add(text, 1, 0);
        root.add(textField, 1, 1);
        root.add(rb1, 1, 2);
        root.add(rb2, 2, 2);
        root.add(response,1,3);
        
        Scene scene = new Scene(root, 500, 300);
        primaryStage.setTitle("Temperature Conversion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
