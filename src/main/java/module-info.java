module com.quest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.fasterxml.jackson.databind;


    opens com.quest to javafx.graphics, javafx.fxml;
    opens com.quest.scene to javafx.fxml;
    opens com.quest.model to com.fasterxml.jackson.databind;
    opens com.quest.dao to com.fasterxml.jackson.databind;

    exports com.quest;
    exports com.quest.scene;
    exports com.quest.model;
    exports com.quest.service;
    exports com.quest.dao;
}
