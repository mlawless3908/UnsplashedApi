import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

//GITHUB: https://github.com/mlawless3908/UnsplashedApi
public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {


        // Load the GUI from FXML built in Scene Builder
        Parent root = FXMLLoader.load(getClass().getResource("FileView.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Mood Board - Unsplashed API");

        stage.setScene(scene);
        stage.show();
        
    }

    @Override
    public void stop(){
        System.out.println("Stop is called in Application class");
    }
}
