module novo.crud {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens novo.crud to javafx.fxml;
    exports novo.crud;
}
