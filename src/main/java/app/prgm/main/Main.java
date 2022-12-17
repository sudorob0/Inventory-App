package app.prgm.main;

import app.prgm.model.InHouse;
import app.prgm.model.Inventory;
import app.prgm.model.Outsourced;
import app.prgm.model.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/app/prgm/MainScreen.fxml"));
        primaryStage.setTitle("Main Scene");
        primaryStage.setScene(new Scene(root, 1040, 500));
        primaryStage.show();
    }

    /**
     * Add test data to the tables
     */
    private static void addTestData() {
        Inventory.addPart(new InHouse(1,"C-260", 200, 10, 5, 20, 260));
        Inventory.addPart(new InHouse(2,"C-360", 300, 10, 5, 20, 360));
        Inventory.addPart(new InHouse(3,"118", 100, 10, 5, 20, 118));
        Inventory.addPart(new Outsourced(4,"Catalyst 9100", 400, 2, 1, 5, "Cisco"));
        Inventory.addPart(new Outsourced(5,"Catalyst 9166", 400, 2, 1, 5, "Cisco"));
        Inventory.addPart(new Outsourced(6,"Catalyst 9105w", 400, 2, 1, 5, "Cisco"));
        Inventory.addProduct(new Product(1,"720XP 48P", 1000, 2, 1, 3));
        Inventory.addProduct(new Product(2,"7050X3 48P", 3000, 1, 0, 2));
        Inventory.addProduct(new Product(3,"7130B-32QD", 4000, 1, 0, 2));
    }

    public static void main(String[] args) {

        addTestData();

        launch(args);
    }
}