package app.prgm.controller;

import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
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

    public void toModifyPartScreen(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/prgm/ModifyPartScreen.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 400, 500);
        stage.setTitle("Modify Part");
        stage.setScene(scene);
        stage.show();
    }

    public void deletePart(){}

    public void toAddProductScreen(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/resources/app/prgm/AddProductScreen.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Add Product");
        stage.setScene(scene);
        stage.show();
    }

    public void searchProducts(){}

    public void toModifyProductScreen(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/resources/app/prgm/ModifyProductScreen.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Modify Product");
        stage.setScene(scene);
        stage.show();
    }

    public void deleteProduct(){}

    public void exitApp(){}

}