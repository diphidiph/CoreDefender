module be.iiw.coredefender {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens be.iiw.coredefender to javafx.fxml;
    exports be.iiw.coredefender;
}
