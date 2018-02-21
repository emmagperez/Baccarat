package baccarat.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;


/**
 * Created by emmaperez on 4/19/17.
 */
public class StatsController implements Initializable {

    @FXML
    private TextArea allUsers;

    @FXML
    private Button quit;


    @FXML
    public void goQuit() {
        Stage stage = (Stage) quit.getScene().getWindow();
        stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Scanner s = new Scanner(new File("src/baccarat/controller/userStats.txt")).useDelimiter(",");
            while (s.hasNext()) {
                allUsers.appendText(s.next());
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
            }
    }

}
