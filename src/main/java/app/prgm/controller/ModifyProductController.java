package app.prgm.controller;

import app.prgm.model.Inventory;
import app.prgm.model.Part;
import app.prgm.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static app.prgm.model.Inventory.allParts;
import static app.prgm.model.Inventory.allProducts;

public class ModifyProductController implements Initializable {
    public TextField nameField;
    public TextField inventoryField;
    public TextField priceField;
    public TextField minField;
    public TextField maxField;
    public Button addAssocPart;
    public Button removeAssocPart;
    public Button saveButton;
    public Button cancelButton;
    public TextField partSearchBar;
    public TableColumn partIdCol;
    public TableColumn partNameCol;
    public TableColumn partInventoryCol;
    public TableColumn partPriceCol;
    public TableView associatedPartsTable;
    public TableColumn associatedPartIdCol;
    public TableColumn associatedPartNameCol;
    public TableColumn associatedInventoryCol;
    public TableColumn associatedPriceCol;
    public TableView partsToAddTable;
    private static ObservableList<Part> associatedPartsList = FXCollections.observableArrayList();
    public TextField idField;
    private Product selectedProduct;
    private int currentIndex;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        partsToAddTable.setItems(allParts);
        partIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInventoryCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        associatedPartsTable.setItems(associatedPartsList);
        associatedPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        associatedPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        associatedInventoryCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        associatedPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    public void productToModify(int currentIndex, Product product) {
        this.selectedProduct = product;
        this.currentIndex = currentIndex;

        idField.setText(Integer.toString(selectedProduct.getProductID()));
        nameField.setText(selectedProduct.getProductName());
        inventoryField.setText(Integer.toString(selectedProduct.getProductStock()));
        priceField.setText(Double.toString((selectedProduct.getProductPrice())));
        maxField.setText(Integer.toString(selectedProduct.getMax()));
        minField.setText(Integer.toString(selectedProduct.getMin()));

        associatedPartsList.clear();

        for (Part part : product.getAllAssociatedParts()) {
    if (!associatedPartsList.contains(part)) {
        associatedPartsList.addAll(product.getAllAssociatedParts());
    }
        }
    }

    /**
     * This method sets the scene back to the main screen
     * @param actionEvent
     * @throws IOException
     */
    public void toMainScreen(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/main/resources/app/prgm/MainScreen.fxml"));
        Stage stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1040, 500);
        stage.setTitle("Inventory Management System");
        stage.setScene(scene);
        stage.show();
    }
    public void addButtonSelected(ActionEvent actionEvent){
        Part selectedPart = (Part) partsToAddTable.getSelectionModel().getSelectedItem();

        if (selectedPart == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("First select a part to add");
            alert.showAndWait();
        }
        else {
            associatedPartsList.add(selectedPart);
            associatedPartsTable.setItems(associatedPartsList);
        }
    }

    /**
     * Remove an associated part from the product.
     *
     * RUNTIME ERROR: If no part is selected a notification will pop up to
     * inform the user that they need to select a part first.
     * @param actionEvent
     */
    public void removeButtonSelected(ActionEvent actionEvent){
        Part selectedPartToRemove = (Part) associatedPartsTable.getSelectionModel().getSelectedItem();

        if (selectedPartToRemove == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("First select a part to remove");
            alert.showAndWait();
        }
        else {
            associatedPartsList.remove(selectedPartToRemove);
            associatedPartsTable.setItems(associatedPartsList);
        }
    }

    /**
     * This method is to chang ethe scene to the main screen when the cancel button is selected.
     * @param actionEvent
     * @throws IOException
     */
    public void cancelButtonSelected(ActionEvent actionEvent) throws IOException {
        associatedPartsList.clear();
        toMainScreen(actionEvent);
    }

    public void searchParts(ActionEvent actionEvent) {
        String searchText = partSearchBar.getText();
        ObservableList<Part> partIdResult = Inventory.lookupPartId(searchText);
        if (partIdResult == null) {
            ObservableList<Part> partResults = Inventory.lookupPart(searchText);
            partsToAddTable.setItems(partResults);
        } else {
            partsToAddTable.setItems(partIdResult);
        }
    }

    /**
     * This method saves the product as an object to the allProducts list
     * RUNTIME ERROR: If the user inputs an incorrect value then the try catch will inform them
     * a value is incorrect and show them the error message.
     * RUNTIME ERROR: If min is grater than max user will get an error message
     * RUNTIME ERROR: If the current inventory is not within the min and max then the user will get an error.
     * @param actionEvent
     * @throws IOException
     */
    public void saveButtonSelected(ActionEvent actionEvent) throws IOException {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            int inventory = Integer.parseInt(inventoryField.getText());
            int min = Integer.parseInt(minField.getText());
            int max = Integer.parseInt(maxField.getText());
            allProducts.remove(selectedProduct);

            if(max < min) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Max must be greater than Min");
                alert.showAndWait();
                return;
            }
            else if (min > inventory) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Stock must be greater than them minimum.");
                alert.showAndWait();
                return;
            }
            else if (max < inventory) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Stock must be less than them maximum.");
                alert.showAndWait();
                return;
            }
            Product newProduct = new Product(id, name, price, inventory, min, max);
            for (Part currentParts : associatedPartsList) {
                newProduct.addAssociatedPart(currentParts);
            }
            Inventory.addProduct(newProduct);
            toMainScreen(actionEvent);
        }
        catch(NumberFormatException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Invalid entry\n\n" + exception);
            alert.showAndWait();
        }
    }
}

