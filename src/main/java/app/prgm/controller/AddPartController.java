package app.prgm.controller;

import app.prgm.model.InHouse;
import app.prgm.model.Inventory;
import app.prgm.model.Outsourced;
import app.prgm.model.Part;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static app.prgm.model.Inventory.generatePartId;

/**
 * Initializes the AddPartController
 */
public class AddPartController implements Initializable {
    public Label inOrOutHouseText;
    public TextField inOrOutHouseField;
    public TextField idField;
    public TextField nameField;
    public TextField inventoryField;
    public TextField priceField;
    public TextField minField;
    public TextField maxField;
    public Button cancelButton;
    public Button saveButton;
    public RadioButton inHouseRadio;
    public RadioButton outSourcedRadio;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    /**
     * Method changes scene to the main screen
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
     * This method changes the label and prompt text to machine id when the in house radio button is selected
     * @param actionEvent
     */
    public void inHouseSelected(ActionEvent actionEvent) {
        inOrOutHouseText.setText("Machine ID");
        inOrOutHouseField.setPromptText("ID #");
    }

    /**
     * This method changes the label and prompt text to company name when the outsourced radio button is selected
     * @param actionEvent
     */
    public void outSourcedSelected(ActionEvent actionEvent) {
        inOrOutHouseText.setText("Company Name");
        inOrOutHouseField.setPromptText("Company Name");
    }

    /**
     * This method saves the part to the allParts list and changes the scene to the main screen.
     * RUNTIME ERROR: If an invalid entry is entered the catch will display an error
     * RUNTIME ERROR: If the inventory max is less than the min throw an error.
     * RUNTIME ERROR: If the current inventory is more than max or less than min throw an error.
     * FUTURE ENHANCEMENT: Type a specific error message for each text box's invalid entry error window.
     * @param actionEvent
     * @throws IOException
     */
    public void saveButtonSelected(ActionEvent actionEvent) throws IOException {
        try {
            int id = generatePartId();
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
            if (inHouseRadio.isSelected()) {
                int machineID = Integer.parseInt(inOrOutHouseField.getText());
                Part modifiedPart = new InHouse(id,name, price, inventory, min, max, machineID);
                Inventory.addPart(modifiedPart);
            } else {
                String companyName = inOrOutHouseField.getText();
                Part modifiedPart = new Outsourced(id, name, price, inventory, min, max, companyName);
                Inventory.addPart(modifiedPart);
            }
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
     * This method is to change the scene to the main screen when the cancel button is selected.
     * @param actionEvent
     * @throws IOException
     */
    public void cancelButtonSelected(ActionEvent actionEvent) throws IOException {
        toMainScreen(actionEvent);
    }
}