package lk.dakshithahasindra.projects.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;


public class ViewFactory {
    private AnchorPane dashboardView;

    public void ViewFactory() throws IOException {
        try {
            dashboardView = new FXMLLoader(getClass().getResource("/Fxml/Client/Dashboard.fxml")).load();
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
    public AnchorPane getDashboardView(){
        return (dashboardView==null)? (dashboardView= new ViewFactory().dashboardView):dashboardView;
    }

    public void showLoggingWindow(){

    }
}
