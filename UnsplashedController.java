import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class UnsplashedController {

    @FXML
    private ImageView imageOne;

    @FXML
    private Button refreshButton;

    @FXML
    private Button searchButton;

    @FXML
    private TextArea userQuery;
    private String query;

    @FXML
    void searchClick(ActionEvent event) {
            query = userQuery.getText();
            System.out.println(query);
    }

}
