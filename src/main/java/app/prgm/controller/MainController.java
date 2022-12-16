package app.prgm.controller;

import app.prgm.model.Part;
import app.prgm.model.Product;
import javafx.beans.Observable;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

public class MainController {
    public TableView partsTable;
    public TableColumn partID;
    public TableColumn partName;
    public TableColumn stock;
    public TableColumn price;
    public TextField partSearchBar;
    public Button partDelete;
    public Button partModForm;
    public Button partAdd;
    public Button exit;
    public TableView productsTable;
    public TableColumn prodIDCol;
    public TableColumn prodNameCol;
    public TableColumn prodStock;
    public TableColumn prodPrice;

    /**
     * A method that changes the scene to the add parts screen
     * @param actionEvent
     * @throws IOException
     */
    public void toAddPartScreen(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/resources/app/prgm/AddPartScreen.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 400, 500);
        stage.setTitle("Add Part");
        stage.setScene(scene);
        stage.show();
    }

    public void searchParts() {
    }

    /**
     * This method changes the scene to the modify parts screen
     * @param actionEvent
     * @throws IOException
     */
    public void toModifyPartScreen(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/prgm/ModifyPartScreen.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 400, 500);
        stage.setTitle("Modify Part");
        stage.setScene(scene);
        stage.show();
    }

    public void deletePart() {
    }

    /**
     * A method that changes the scene to the add product screen
     * @param actionEvent
     * @throws IOException
     */
    public void toAddProductScreen(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/resources/app/prgm/AddProductScreen.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Add Product");
        stage.setScene(scene);
        stage.show();
    }

    public void searchProducts() {
    }

    /**
     * Method that changes the scene to the modify product scene
     * @param actionEvent
     * @throws IOException
     */
    public void toModifyProductScreen(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/resources/app/prgm/ModifyProductScreen.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Modify Product");
        stage.setScene(scene);
        stage.show();
    }

    public void deleteProduct() {
    }

    /**
     * Method that exits the stage when the exit button is clicked
     * @param Exit
     */
    public void exitApp(ActionEvent Exit) {
        Stage stage = (Stage) ((Node) Exit.getSource()).getScene().getWindow();
        stage.close();
    }
}