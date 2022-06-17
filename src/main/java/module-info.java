module novo.crud {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens novo.crud to javafx.fxml;
    exports novo.crud;

    
}
