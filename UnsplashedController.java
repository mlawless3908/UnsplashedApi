import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import java.io.FileReader;
import java.io.Reader;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UnsplashedController implements Initializable{

    //All of the variables referenced from the FXML file
    @FXML
    private ImageView imageOne;

    @FXML
    private ImageView imageTwo;
    

    @FXML
    private Button searchButton;

    @FXML
    private TextArea userQuery;
    
    //added Moodboard 
    private Moodboard moodboard;
    
    private String query;
    
    //Variables used internally, not linked to FXML Document

    //Used to retrieve data from the API
    private HttpClient client;
    private final String APIKEY = "g7nMae5ks7o2O1w9TIvHIkmdA5jArZ1S8fHlfutLaZo";
    
    private String imageURL = "";
    private String imageURL1 = "";

    //added initialize controller for unsplashAPI & observer


   protected void updateMoodboard(){
        if (this.client == null)
            this.client = HttpClient.newHttpClient();

       HttpRequest request = HttpRequest.newBuilder()
               .uri(URI.create("https://api.unsplash.com/search/photos?page=1&query=" + query + "&client_id=" + APIKEY))
               .GET()
               .build();


       client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
               .thenApply(HttpResponse::body)
               .thenAccept(this::processMoodData);

   }

   protected void processMoodData(String data) {


        //use GSON to convert JSON to a POJO
       Gson gson = new Gson();
       this.moodboard = gson.fromJson(data, Moodboard.class);
       System.out.println(moodboard);

       //Schedule UI updates on the GUI thread
       //This is important because the data download happens in the background
       Platform.runLater(new Runnable() {
           @Override
           public void run() {
               updateUI();
           }
       });

   }

   //Update the GUI to reflect changes
    //Simple app, update anything and everything all the time
    protected void updateUI(){
    imageURL = moodboard.results[0].urls.small;
    Image image1 = new Image(imageURL);
    imageOne.setImage(image1);

    imageURL1 = moodboard.results[1].urls.small;
    Image image2 = new Image(imageURL1);
    imageTwo.setImage(image2);


    }
    @FXML
    void searchClick(ActionEvent event) {
            query = userQuery.getText();
            System.out.println(query);
            updateMoodboard();

    }



    @Override
    public void initialize(URL location, ResourceBundle resources){
       Preferences p = Preferences.userNodeForPackage(UnsplashedController.class);
    }

}
