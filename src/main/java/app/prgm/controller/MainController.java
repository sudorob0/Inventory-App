package app.prgm.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

public class MainController {
    public void toAddPartScreen(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/resources/app/prgm/AddPartScreen.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 400, 500);
        stage.setTitle("Add Part");
        stage.setScene(scene);
        stage.show();
    }
    
    public void searchParts(){}

    public void toModifyPartScreen(){}

    public void deletePart(){}

    public void toAddProductScreen(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/resources/app/prgm/AddPartScreen.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 400, 500);
        stage.setTitle("Add Part");
        stage.setScene(scene);
        stage.show();
    }

    public void searchProducts(){}

    public void toModifyProductScreen(){}

    public void deleteProduct(){}

    public void exitApp(){}

}