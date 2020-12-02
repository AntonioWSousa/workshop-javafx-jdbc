package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemSeller;

	@FXML	
	private MenuItem menuItemDepartment;
	
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemSellerAction() { //métodos para tratarem os eventos do menu
		System.out.println("onMenuItemSellerAction");
	}
	
	@FXML
	public void onMenuItemDepartmentAction() { 
		System.out.println("onMenuItemDepartmentAction");
	}
	
	@FXML
	public void onMenuItemAboutAction() { 
		loadView("/gui/About.fxml");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rsb) {
		
	}
	
	private synchronized void loadView(String absoluteName) { /*uso o syncronized é opcional, servindo para que o processamento todo não seja interrompido, evitando de acontecer algum comportamento inesperado, pelo fato de interface g´rafica trabalhar com multithreads*/
		try { /*criada exceção necessária para tratar o alert*/
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName)); /*instanciando o fxmlloader*/
			VBox newVBox = loader.load(); /*criando um objeto VBox fazendo ele receber um loader.load()*/			
			
			/*mostrando a view dentro da janela principal*/
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent(); /*referência para pegar o conteúdo do VBox no MainView*/
			
			Node mainMenu = mainVBox.getChildren().get(0); /*referência para o menu, onde o get(0) está n posição 0, pegando o primeiro filho do VBox da janela principal(mainMenu)*/
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
		}
		catch (IOException e){
			Alerts.showAlert("IO Exception", "Erro ao carregar a página...", e.getMessage(), AlertType.ERROR); /*carregando a View*/
		}

	}

}
