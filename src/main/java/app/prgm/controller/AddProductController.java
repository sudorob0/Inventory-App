package app.prgm.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddProductController implements Initializable {
    public TableView partToAdd;
    public TableColumn partIDCol;
    public TableColumn partNameCol;
    public TableColumn stockCol;
    public TableColumn priceCol;
    public TableView addedPartsList;
    public TableColumn addedPartIDCol;
    public TableColumn addedPartNameCol;
    public TableColumn addedStockCol;
    public TableColumn addedPriceCol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
    public void addButtonSelected(){}

    public void removeButtonSelected(){}

    public void saveButtonSelected(){}

    /**
     * Method takes you back to the main scene if you select the cancel button
     * @param actionEvent
     * @throws IOException
     */
    public void cancelButtonSelected(ActionEvent actionEvent) throws IOException {
        toMainScreen(actionEvent);
    }
    public void searchParts(){}
}
