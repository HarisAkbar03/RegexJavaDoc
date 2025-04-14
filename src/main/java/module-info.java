module org.example.regexjavadoc {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.regexjavadoc to javafx.fxml;
    exports org.example.regexjavadoc;
}