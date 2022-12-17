package app.prgm.controller;

import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static app.prgm.model.Inventory.allParts;
import static app.prgm.model.Inventory.allProducts;


public class MainController implements Initializable {
    public TableView partsTable;
    public TableColumn partIdCol;
    public TableColumn partNameCol;
    public TableColumn partStockCol;
    public TableColumn partPriceCol;
    public TextField partSearchBar;
    public Button partDeleteButton;
    public Button partModifyButton;
    public Button partAddButton;
    public Button exit;
    public TableView productsTable;
    public TableColumn prodIdCol;
    public TableColumn prodNameCol;
    public TableColumn prodStockCol;
    public TableColumn prodPriceCol;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        partsTable.setItems(allParts);
        partIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        partStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        productsTable.setItems(allProducts);
        prodIdCol.setCellValueFactory(new PropertyValueFactory<>("productID"));
        prodNameCol.setCellValueFactory(new PropertyValueFactory<>("productName"));
        prodStockCol.setCellValueFactory(new PropertyValueFactory<>("productStock"));
        prodPriceCol.setCellValueFactory(new PropertyValueFactory<>("productPrice"));
    }

    /**
     * This method is to help reduce the boiler plate code that is needed to change a scene
     * @param actionEvent
     * @param fxmlFile
     * @param width
     * @param height
     * @param screenTitle
     * @throws IOException
     */
     public void changeScene(ActionEvent actionEvent, String fxmlFile, int width, int height, String screenTitle) throws IOException {
        String path = "/main/resources/app/prgm/";
        path = path.concat(fxmlFile);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, width, height);
        stage.setTitle(screenTitle);
        stage.setScene(scene);
        stage.show();
     }


    /**
     * A method that changes the scene to the add parts screen
     * @param actionEvent
     * @throws IOException
     */
    public void toAddPartScreen(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "AddPartScreen.fxml", 400, 500, "Add Part");
    }

    public void searchParts() {
    }

    /**
     * This method changes the scene to the modify parts screen
     * @param actionEvent
     * @throws IOException
     */
    public void toModifyPartScreen(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "AddPartScreen.fxml", 400, 500, "Modify Part");
    }


     public void deletePart() {
     //Part selectedPart = (Part) partsTable.getSelectionModel().getSelectedItem();
     //if (selectedPart == null)
     //return;
     //allParts.remove(selectedPart);
     }

    /**
     * A method that changes the scene to the add product screen
     * @param actionEvent
     * @throws IOException
     */
    public void toAddProductScreen(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "AddProductScreen.fxml", 800, 600, "Add Product");
    }

    public void searchProducts() {
    }

    /**
     * Method that changes the scene to the modify product scene
     * @param actionEvent
     * @throws IOException
     */
    public void toModifyProductScreen(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "ModifyProductScreen.fxml", 800, 600, "Modify Product");
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