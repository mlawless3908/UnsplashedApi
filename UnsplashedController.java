import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javax.swing.*;
import java.awt.event.MouseEvent;

public class UnsplashedController {

    @FXML
    private ImageView imageOne;

    @FXML
    private ImageView imageTwo;

    @FXML
    private Button refreshButton;

    @FXML
    private Button searchButton;

    @FXML
    private TextArea userQuery;
    private String query;
    private String imageURL = "https://images.unsplash.com/photo-1682686580950-960d1d513532?q=80&w=1287&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D";


    @FXML
    void searchClick(ActionEvent event) {
            query = userQuery.getText();
            System.out.println(query);
            Image image1 = new Image(imageURL);
            imageOne.setImage(image1);
            imageTwo.setImage(image1);
            userQuery.clear();
    }



}
