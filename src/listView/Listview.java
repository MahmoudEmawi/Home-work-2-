/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listView;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;



public class Listview extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 500, 200, Color.WHITE);
        primaryStage.setTitle("Multiple Selection Lists");
        Alert a = new Alert(AlertType.NONE);
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        ColumnConstraints column1 = new ColumnConstraints(150, 150,
                Double.MAX_VALUE);
        ColumnConstraints column2 = new ColumnConstraints(80);
        ColumnConstraints column3 = new ColumnConstraints(150, 150,
                Double.MAX_VALUE);
        column1.setHgrow(Priority.ALWAYS);
        column3.setHgrow(Priority.ALWAYS);
        gridpane.getColumnConstraints().addAll(column1, column2, column3);

        final ObservableList<String> candidates = FXCollections
                .observableArrayList("Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Red");
        final ListView<String> candidatesListView = new ListView<>(candidates);
        gridpane.add(candidatesListView, 0, 1);

        candidatesListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        final ObservableList<String> selected = FXCollections.observableArrayList();
        final ListView<String> heroListView = new ListView<>(selected);
        gridpane.add(heroListView, 2, 1);

        Button sendRightButton = new Button("Copy >>> ");
        sendRightButton.setMinSize(80, 30);
        sendRightButton.setOnAction((ActionEvent event) -> {
            String potential = candidatesListView.getSelectionModel()
                    .getSelectedItem();
            if (potential != null) {
                ObservableList<String> selectedItems = candidatesListView.getSelectionModel().getSelectedItems();

                for (String s : selectedItems) {
                    selected.add(s);
                }
                candidatesListView.getSelectionModel().clearSelection();

            } else {
                a.setAlertType(AlertType.INFORMATION);
                a.setHeaderText(null);
                a.setContentText("No item selections");
                a.show();
            }
        });

        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(sendRightButton);

        gridpane.add(vbox, 1, 1);
        root.setCenter(gridpane);

        GridPane.setVgrow(root, Priority.ALWAYS);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
