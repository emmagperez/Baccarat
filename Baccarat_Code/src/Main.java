import javafx.application.Application;
import javafx.stage.Stage;

// This entire class is very simple.
// It houses the short main method,
// Which calls start
// Which calls Menu, to open the main menu.
// Yes, it really has to be this way. 

public class Main extends Application {
    
public void start(Stage stage){
    new Menu();
}

public static void main(String[] args)
{
   Application.launch(args);
}

}
