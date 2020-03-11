/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listView;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Mahmoud Emawi
 */
public class Listview extends Application {

    @Override
    public void start(Stage primaryStage) {

        ListView<String> listNames1;
        ListView<String> listNames2;

        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 350, 200);

        ObservableList<String> colorName
                = FXCollections.observableArrayList("Black", "Blue",
                        "Cyan", "Dark Gray", "Gray", "Green",
                        "Red", "White");
        ObservableList<String> colorName2
                = FXCollections.observableArrayList();

        listNames1 = new ListView<String>(colorName);
        listNames2 = new ListView<String>(colorName2);
        listNames1.setPrefSize(200, 150);
        listNames2.setPrefSize(200, 150);
        listNames1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        GridPane.setConstraints(listNames1, 0, 0);
        GridPane.setConstraints(listNames2, 2, 0);
        Button btn = new Button("Copy =>");
        btn.setPrefSize(200, 30);
        btn.setOnAction(event -> {
            colorName2.addAll(listNames1.getSelectionModel().getSelectedItems());
            colorName.removeAll(listNames2.getSelectionModel().getSelectedItems());
        });
        GridPane.setConstraints(btn, 1, 0);
        gridPane.getChildren().addAll(listNames1, listNames2, btn);
        primaryStage.setTitle("Multiple Selection lists");
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
