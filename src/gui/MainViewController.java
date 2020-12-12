package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

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
import model.services.DepartmentService;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemSeller;

	@FXML	
	private MenuItem menuItemDepartment;
	
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("onMenuItemSellerAction");
	}
	
	@FXML
	public void onMenuItemDepartmentAction() { /*no momento da chamada, incluir um segundo parâmetro, pois o loadviw2 feito anteriormente não existe mais*/
		loadView("/gui/DepartmentList.fxml", (DepartmentListController controller) -> { /*criada uma função de inicialização através de uma expressão lambda*/
			controller.setDepertmentService(new DepartmentService()); /*esta é a ação de inicialização do DepartmentListController*/
			controller.updateTableView();
		} ); 
	}
	
	@FXML
	public void onMenuItemAboutAction() { 
		loadView("/gui/About.fxml", x -> {}); /*foi criada uma ação para carregar o About, mas num primeiro, não carrega nada*/
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rsb) {
		
	}
	
	private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) { /*ao realizar este comando, a função loadview se tornou uma função genérica, uma função do tipo T, uma função parametrizada com um tipo qualquer*/
		try { 
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			T controller = loader.getController(); /*a função getController() está retornando o controlador do tipo que está chamando o DepartmentListController*/
			initializingAction.accept(controller); /*comando para executar a ação do Consumer*/
		}
		catch (IOException e){
			Alerts.showAlert("IO Exception", "Erro ao carregar a página...", e.getMessage(), AlertType.ERROR);
		}

	}
	
	

}
