module ABC.Bank {
    requires javafx.controls;
    requires javafx.fxml;
    requires  de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires mysql.connector.j;

    opens lk.dakshithahasindra.projects to javafx.fxml;
    exports lk.dakshithahasindra.projects;
    exports lk.dakshithahasindra.projects.Controllers;
    exports lk.dakshithahasindra.projects.Controllers.Admin;
    exports lk.dakshithahasindra.projects.Controllers.Client;
    exports lk.dakshithahasindra.projects.Models;
    exports lk.dakshithahasindra.projects.Views;


}