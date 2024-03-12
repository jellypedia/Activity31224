module com.example.activity31224 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.activity31224 to javafx.fxml;
    exports com.example.activity31224;
}