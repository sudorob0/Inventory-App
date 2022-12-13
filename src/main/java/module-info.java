module app.prgm {
    requires javafx.controls;
    requires javafx.fxml;


    opens app.prgm.main to javafx.fxml;
    exports app.prgm.main;
    opens app.prgm.controller to javafx.fxml;
    exports app.prgm.controller;
}