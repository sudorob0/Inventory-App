package app.prgm.controller;

import app.prgm.model.*;
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
import static app.prgm.model.Inventory.*;


public class AddProductController implements Initializable {
    public TableColumn partNameCol;
    public TextField idField;
    public TextField nameField;
    public TextField inventoryField;
    public TextField priceField;
    public TextField maxField;
    public TextField minField;
    public Button addAssocPart;
    public Button removeAssocPart;
    public Button saveButton;
    public Button cancelButton;
    public TextField partSearchBar;
    public TableView partsToAddTable;
    public TableColumn partIdCol;
    public TableColumn partInventoryCol;
    public TableColumn partPriceCol;
    private static ObservableList<Part> associatedPartsList = FXCollections.observableArrayList();
    public TableView associatedPartsTable;
    public TableColumn associatedPartIDCol;
    public TableColumn associatedPartNameCol;
    public TableColumn associatedInventoryCol;
    public TableColumn associatedPriceCol;



    /**
     * Populate the partsToAddTable with the allParts list
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        partsToAddTable.setItems(allParts);
        partIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInventoryCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        associatedPartsTable.setItems(associatedPartsList);
        associatedPartIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        associatedPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        associatedInventoryCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        associatedPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

    }

    /**
     * Method takes you back to the main screen
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

    /**
     * This method adds a part to the products list
     *
     * RUNTIME ERROR: If no part is selected a notification will pop up to
     * inform the user that they need to select a part first.
     * @param actionEvent
     */
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
            int id = generateProductId();
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            int inventory = Integer.parseInt(inventoryField.getText());
            int min = Integer.parseInt(minField.getText());
            int max = Integer.parseInt(maxField.getText());

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
            associatedPartsList.clear();
            toMainScreen(actionEvent);
        }
        catch(NumberFormatException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Invalid entry\n\n" + exception);
            alert.showAndWait();
        }
    }

    /**
     * Method takes you back to the main scene if you select the cancel button
     * @param actionEvent
     * @throws IOException
     */
    public void cancelButtonSelected(ActionEvent actionEvent) throws IOException {
        associatedPartsList.clear();
        toMainScreen(actionEvent);
    }

    /**
     * This method searches for part id and name.
     * It first checks for part id since you need to have an exact match on the id it is less greedy.
     * Then if it cant find part id it searches for a partial match on the name.
     * Exception handling is in the inventory methods being called
     * RUNTIME ERROR: If no parts are found then the else statement will create an error for the catch to hit and
     * show an error message
     * FUTURE ENHANCEMENT: Allow searching by other criteria like machineID or company name
     * FUTURE ENHANCEMENT: Allow for filtering for the price and inventory
     * @param actionEvent
     */
    public void searchParts(ActionEvent actionEvent) {
        String searchText = partSearchBar.getText();
        ObservableList<Part> partIdResult = Inventory.lookupPartId(searchText);
        ObservableList<Part> partResults = Inventory.lookupPart(searchText);
        try {
            // if search found an id
            if (partIdResult != null) {
                partsToAddTable.setItems(partIdResult);
                // if search found a partial name match
            } else if (partResults.size() != 0) {
                partsToAddTable.setItems(partResults);
                // if the search doesn't find anything
            } else {
                partIdResult.size();
            }
        }
        catch (Exception exception){
            partsToAddTable.setItems(null);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("No Parts found.");
            alert.showAndWait();
        }
    }
}
