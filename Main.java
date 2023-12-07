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
        Parent root = FXMLLoader.load(getClass().getResource("FileView.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Mood Board - Unsplashed API");
        stage.setScene(scene);
        stage.show();
    }
}
