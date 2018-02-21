package baccarat.controller;

import baccarat.model.Player;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;



/**
 * Created by emmaperez on 4/18/17.
 */
public class ScoreController implements Initializable{

    @FXML
    private Label score;

    @FXML
    private Button logStats;

    @FXML
    private TextField userName;

    @FXML
    private Button quit;


    @FXML
    private void goQuit() throws IOException {
        Stage stage = (Stage) quit.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize (URL url, ResourceBundle rb) {
        //this doesn't work

        try {
            FileReader read = new FileReader("src/baccarat/controller/totalWins.txt");
            BufferedReader bufferedReader =
                    new BufferedReader(read);
            String line = bufferedReader.readLine();
            // while((line = bufferedReader.readLine()) != null) {
            score.textProperty().bind(new SimpleStringProperty(line));;
            //}

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void goSubmit() throws IOException {
        // doesn't do anything yet
        String input = userName.getText();
        String gamescore = score.getText();

        try {

            File userStats = new File("src/baccarat/controller/userStats.txt");
            FileWriter writer = new FileWriter(userStats,true);
            writer.write("user: " + input + "       highscore: "+ gamescore + "," + "\n");

            writer.close();


        } catch (IOException e) {

            e.printStackTrace();
        }


        Stage stage = (Stage) quit.getScene().getWindow();
        stage.close();
    }
}
