module com.example.stickhero {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires javafx.media;
    requires org.testng;
    requires org.junit.platform.commons;
    requires junit;
    requires java.sql;

    opens com.example.stickhero to javafx.fxml;
    exports com.example.stickhero;
}