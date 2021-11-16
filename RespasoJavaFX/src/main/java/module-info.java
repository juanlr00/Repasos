module com.mycompany.respasojavafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.respasojavafx to javafx.fxml;
    exports com.mycompany.respasojavafx;
}
