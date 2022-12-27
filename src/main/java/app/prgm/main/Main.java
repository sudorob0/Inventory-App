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
    /**
     * This method is to initialize the stage for the application
     * @param primaryStage
     * @throws Exception
     */
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
        Inventory.addPart(new InHouse(111,"C-260", 200, 10, 5, 20, 260));
        Inventory.addPart(new InHouse(112,"C-360", 300, 10, 5, 20, 360));
        Inventory.addPart(new InHouse(113,"118", 100, 10, 5, 20, 118));
        Inventory.addPart(new Outsourced(114,"Catalyst 9100", 400, 2, 1, 5, "Cisco"));
        Inventory.addPart(new Outsourced(115,"Catalyst 9166", 400, 2, 1, 5, "Cisco"));
        Inventory.addPart(new Outsourced(116,"Catalyst 9105w", 400, 2, 1, 5, "Cisco"));
        Inventory.addProduct(new Product(1100,"720XP 48P", 1000, 2, 1, 3));
        Inventory.addProduct(new Product(1101,"7050X3 48P", 3000, 1, 0, 2));
        Inventory.addProduct(new Product(1102,"7130B-32QD", 4000, 1, 0, 2));
    }

    /**
     * Launches application
     * @param args
     */
    public static void main(String[] args) {
        // this is used to add test data
        addTestData();

        launch(args);
    }
}