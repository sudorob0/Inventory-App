package app.prgm.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyPartController implements Initializable {
    public Label inOrOutHouseText;
    public TextField inOrOutHouseField;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void toMain(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/app/prgm/MainScreen.fxml"));
        Stage stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 999, 500);
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

    public void saveButtonSelected(){}

    /**
     * This method is to chang ethe scene to the main screeen when the cancel button is selected.
     * @param actionEvent
     * @throws IOException
     */
    public void cancelButtonSelected(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/main/resources/app/prgm/MainScreen.fxml"));
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 999, 500);
        stage.setTitle("Inventory Management System");
        stage.setScene(scene);
        stage.show();
    }
}