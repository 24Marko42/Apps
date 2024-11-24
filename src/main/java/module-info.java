module org.example.work_work {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.work_work to javafx.fxml;
    exports org.example.work_work;
}