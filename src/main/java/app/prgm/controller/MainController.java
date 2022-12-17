package app.prgm.controller;

import app.prgm.model.Inventory;
import app.prgm.model.Product;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import app.prgm.model.Part;

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
    public TextField productSearchBar;


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
     * @param sceneWidth
     * @param sceneHeight
     * @param screenTitle
     * @throws IOException
     */
     public void changeScene(ActionEvent actionEvent, String fxmlFile, int sceneWidth, int sceneHeight, String screenTitle) throws IOException {
        String path = "/main/resources/app/prgm/" + fxmlFile;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, sceneWidth, sceneHeight);
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

    /**
     * This method searches for part id and name.
     * It first checks for part id since you need to have an exact match on the id it is less greedy.
     * Then if it cant find part id it searches for a partial match on the name.
     * Exception handling is in the inventory methods being called
     * @param actionEvent
     */
    public void searchParts(ActionEvent actionEvent) {
        String searchText = partSearchBar.getText();
        ObservableList<Part> partIdResult = Inventory.lookupPartId(searchText);
        if (partIdResult == null) {
            ObservableList<Part> partResults = Inventory.lookupPart(searchText);
            partsTable.setItems(partResults);
        } else {
            partsTable.setItems(partIdResult);
        }

    }

    /**
     * This method changes the scene to the modify parts screen
     * @param actionEvent
     * @throws IOException
     */
    public void toModifyPartScreen(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "AddPartScreen.fxml", 400, 500, "Modify Part");
    }

    /**
     * Method deletes part from all parts list
     * A warning will pop up if no part is selected
     * A confirmation window will pop up asking you to confirm if you want to delete a part
     */
     public void deletePart() {
     Part selectedPart = (Part) partsTable.getSelectionModel().getSelectedItem();
     if (selectedPart == null) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setContentText("No part selected to delete.");
         alert.showAndWait();
         return;
     }
     Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this part?");
     Optional<ButtonType> result = alert.showAndWait();
     if (result.isPresent() && result.get() == ButtonType.OK) {
             allParts.remove(selectedPart);
         }
     }

    /**
     * A method that changes the scene to the add product screen
     * @param actionEvent
     * @throws IOException
     */
    public void toAddProductScreen(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "AddProductScreen.fxml", 800, 600, "Add Product");
    }

    /**
     * This method searches for product id and name.
     * It first checks for product id since you need to have an exact match on the id it is less greedy.
     * Then if it cant find product id it searches for a partial match on the name.
     * Exception handling is in the inventory methods being called
     * @param actionEvent
     */
    public void searchProducts(ActionEvent actionEvent) {
        String searchText = productSearchBar.getText();
        ObservableList<Product> productIdResult = Inventory.lookupProductId(searchText);
        if (productIdResult == null) {
            ObservableList<Product> productResults = Inventory.lookupProduct(searchText);
            productsTable.setItems(productResults);
        } else {
            productsTable.setItems(productIdResult);
        }

    }

    /**
     * Method that changes the scene to the modify product scene
     * @param actionEvent
     * @throws IOException
     */
    public void toModifyProductScreen(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "ModifyProductScreen.fxml", 800, 600, "Modify Product");
    }

    /**
     * Method deletes product from all product list
     * A warning will pop up if no product is selected
     * A confirmation window will pop up asking you to confirm if you want to delete a product
     */
    public void deleteProduct() {
        Product selectedProduct = (Product) productsTable.getSelectionModel().getSelectedItem();
        if (selectedProduct == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("No product selected to delete.");
            alert.showAndWait();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this product?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            allProducts.remove(selectedProduct);
        }
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