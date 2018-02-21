import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menu extends Stage{
    //Menu.setTitle("Hello World");
Button playBaccarat = new Button("Play Baccarat"); //Creates a button that begins a game of Baccarat
Pane x = new Pane();

@SuppressWarnings("restriction")
Menu(){
    x.getChildren().add(playBaccarat); //Places the Baccarat button on the screen
    this.setScene(new Scene(x, 320, 480)); //Sets the window dimensions
    this.show(); // Tells the window to appear, with the above specifications 

    // The below code sets up the baccarat button to launch a new window when clicked
    // This window plays a game of baccarat, and is detailed in the BaccaratGUI class
    playBaccarat.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) { // The default event for a button is being clicked
        	new BaccaratGUI();
        }  });
   
    } // End of Menu constructor
} // End of Menu class