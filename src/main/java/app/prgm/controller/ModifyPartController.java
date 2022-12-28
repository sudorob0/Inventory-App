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
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static app.prgm.model.Inventory.allParts;
public class ModifyPartController implements Initializable {
    public Label inOrOutHouseText;
    public TextField inOrOutHouseField;
    public TextField idField;
    public TextField nameField;
    public TextField inventoryField;
    public TextField priceField;
    public TextField minField;
    public TextField maxField;
    public RadioButton outSourcedRadio;
    public Part selectedPart;
    public RadioButton inHouseRadio;
    public Button cancelButton;
    public Button saveButton;
    private int currentIndex = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * This method takes the part that was selected in the main screen and adds its attributes in the corresponding text box.
     * @param currentIndex
     * @param part
     */
    public void partToModify(int currentIndex, Part part) {
        this.selectedPart = part;
        this.currentIndex = currentIndex;
        idField.setText(Integer.toString(selectedPart.getId()));
        nameField.setText(selectedPart.getName());
        inventoryField.setText(Integer.toString(selectedPart.getStock()));
        priceField.setText(Double.toString(selectedPart.getPrice()));
        maxField.setText(Integer.toString(selectedPart.getMax()));
        minField.setText(Integer.toString(selectedPart.getMin()));
        if (part instanceof InHouse) {
            inOrOutHouseField.setText(Integer.toString(((InHouse) selectedPart).getMachineID()));
            inHouseRadio.setSelected(true);
            inOrOutHouseText.setText("Machine ID");
        }
        else {
            inOrOutHouseField.setText(((Outsourced) selectedPart).getCompanyName());
            outSourcedRadio.setSelected(true);
            inOrOutHouseText.setText("Company Name");
        }
    }

    /**
     * This method takes you back to the main scene
     * @param actionEvent
     * @throws IOException
     */
    public void toMainScreen(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/app/prgm/MainScreen.fxml"));
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
     * This method is to change the scene to the main screen when the cancel button is selected.
     * @param actionEvent
     * @throws IOException
     */
    public void cancelButtonSelected(ActionEvent actionEvent) throws IOException {
        toMainScreen(actionEvent);
    }

    /**
     * This method saves the new modified part as an object to the allParts list and delete the old object.
     * RUNTIME ERROR: If the user inputs an incorrect value then the try/catch will inform them
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
                Part modifiedPart = new InHouse(id, name, price, inventory, min, max, machineID);
                Inventory.addPart(modifiedPart);
            } else {
                String companyName = inOrOutHouseField.getText();
                Part modifiedPart = new Outsourced(id, name, price, inventory, min, max, companyName);
                Inventory.addPart(modifiedPart);
            }
            allParts.remove(selectedPart);
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