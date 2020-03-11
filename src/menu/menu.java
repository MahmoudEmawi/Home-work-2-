/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Mahmoud Emawi
 */
public class menu extends Application {

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 500, 600, Color.ANTIQUEWHITE);

        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        root.setTop(menuBar);

        Menu fileMenu = new Menu("File");
        MenuItem openMenuItem = new MenuItem("open...");
        MenuItem closeMenuItem = new MenuItem("close...");
        MenuItem exitMenuItem = new MenuItem("Exit");

        fileMenu.getItems().addAll(openMenuItem, closeMenuItem,
                new SeparatorMenuItem(), exitMenuItem);

        Menu editMenu = new Menu("Edit");
        Menu fomtMenuItem = new Menu("Font");
        MenuItem colorMenuItem = new MenuItem("Color...");
        fomtMenuItem.getItems().addAll(
                new MenuItem("MEDIUM"),
                new MenuItem("BOLD"),
                new MenuItem("THIN"));

        editMenu.getItems().addAll(fomtMenuItem, colorMenuItem);

        TextArea text = new TextArea();
        openMenuItem.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            try (Scanner input = new Scanner(selectedFile)) {
                root.setCenter(text);
                while (input.hasNextLine()) {
                    text.appendText(input.nextLine() + "\n");
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error!!");
            }
            text.setEditable(true);
        });
        closeMenuItem.setOnAction(event -> {
            text.clear();
            text.setEditable(false);
        });
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());
        colorMenuItem.setOnAction(event -> {
            String color[] = {"Red", "Blue", "Green"};
            ChoiceDialog d = new ChoiceDialog(color[0], color);
            d.setTitle("Color Selection");
            d.setHeaderText("Select color from list");
            d.setContentText("Avilable colors");
            d.showAndWait();
        });

        menuBar.getMenus().addAll(fileMenu, editMenu);

        primaryStage.setTitle("My Menus");
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
