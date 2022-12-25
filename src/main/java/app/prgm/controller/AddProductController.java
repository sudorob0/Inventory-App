package app.prgm.controller;

import app.prgm.model.Inventory;
import app.prgm.model.Part;
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



public class AddProductController implements Initializable {
    public TableColumn partNameCol;
    public TableView addedPartsList;
    public TextField idField;
    public TextField nameField;
    public TextField stockField;
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
    public TableColumn partStockCol;
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
        partStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
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

    public void saveButtonSelected(){}

    /**
     * Method takes you back to the main scene if you select the cancel button
     * @param actionEvent
     * @throws IOException
     */
    public void cancelButtonSelected(ActionEvent actionEvent) throws IOException {
        toMainScreen(actionEvent);
    }

    /**
     * This method allows the user to search by part ID or partial search by name.
     * @param actionEvent
     */
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
}
