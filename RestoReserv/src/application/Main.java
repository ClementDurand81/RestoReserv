package application;

import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    	try {
    		Parent rootFXML = FXMLLoader.load(getClass().getResource("Vue.fxml"));
    		Scene sceneFXML = new Scene(rootFXML);
            
    		primaryStage.setTitle("RestoReserv");
    		primaryStage.setScene(sceneFXML);
    		primaryStage.show();
        
    	}catch(Exception e) {
    		e.printStackTrace();
       }
    }

    public static void main(String[] args) {
        launch(args);
    }
}