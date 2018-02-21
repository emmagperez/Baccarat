package baccarat.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by emmaperez on 4/19/17.
 */
public class RulesController implements Initializable{

    @FXML
    private ScrollPane scroll;

    @FXML
    private Button quit;

    @Override
    public void initialize (URL url, ResourceBundle rb){
        Image rules = new Image(getClass().getResourceAsStream("PuntoBancoRules.png"));
        scroll.setContent(new ImageView(rules));
    }
    @FXML
    public void goQuit(){
        Stage stage = (Stage) quit.getScene().getWindow();
        stage.close();
    }
}
