package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	private static Scene mainScene; /*atributo criado para guardar a referência dentro do atributo mainScene*/
	
	@Override
	public void start(Stage primaryStage) { 
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));         
			ScrollPane scrollPane = loader.load();         
			
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);
			
			mainScene = new Scene(scrollPane); /*expondo uma referência para a cena*/
			primaryStage.setScene(mainScene); 
			primaryStage.setTitle("Sample JavaFX application"); 
			primaryStage.show();     
			} catch (IOException e) { 
				e.printStackTrace();     
			} 
	}
	
	public static Scene getMainScene() { /*método criado para retornar o objeto mainScene*/
		return mainScene;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
