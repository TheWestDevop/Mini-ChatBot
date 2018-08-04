/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package airhealthchatbot;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class AiRHealthCHATBOT extends Application {
    private Stage primaryStage;
    private Pane mainLayout;
            
    @Override
    public void start(Stage primaryStage) throws IOException {
       this.primaryStage = primaryStage;
       this.primaryStage.setTitle("AirHealth App");
       showMainView();
               
    }
    private void showMainView() throws IOException {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(AiRHealthCHATBOT.class.getResource("MainView.fxml"));
      mainLayout = loader.load();
      Scene scene = new Scene(mainLayout);
      primaryStage.setScene(scene);
      primaryStage.show();
      
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    
    
}
