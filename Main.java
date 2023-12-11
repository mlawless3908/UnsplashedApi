import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;




public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {

//        //added access Key //
//        String accessKey = "g7nMae5ks7o2O1w9TIvHIkmdA5jArZ1S8fHlfutLaZo";
//
//        //Morgaine added UnsplashAPI with access key & Create Moodboard instance using the initialized UnsplashAPI //
//        UnsplashAPI unsplashAPI = new UnsplashAPI(accessKey);
//        Moodboard moodboard = new Moodboard(unsplashAPI);


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
