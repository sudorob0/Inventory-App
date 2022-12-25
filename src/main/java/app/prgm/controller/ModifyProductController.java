package app.prgm.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static app.prgm.model.Inventory.allParts;

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
    public TableView partToAdd;
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        partsToAddTable.setItems(allParts);
        partIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInventoryCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        //associatedPartsTable.setItems();
        associatedPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        associatedPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        associatedInventoryCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        associatedPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
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
    public void addButtonSelected(){}

    public void removeButtonSelected(){}

    public void saveButtonSelected(){}

    /**
     * This method is to chang ethe scene to the main screeen when the cancel button is selected.
     * @param actionEvent
     * @throws IOException
     */
    public void cancelButtonSelected(ActionEvent actionEvent) throws IOException {
        toMainScreen(actionEvent);
    }

    public void searchParts(){}
}

