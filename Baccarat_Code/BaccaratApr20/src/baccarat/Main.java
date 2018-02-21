package baccarat;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class Main extends Application {

	static Stage primaryStage;
	
	@Override
    public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass()
				.getResource("controller/menu.fxml"));
        
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.initStyle(StageStyle.UNDECORATED);
		primaryStage = stage;
		stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}