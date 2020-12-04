package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;

public class DepartmentListController implements Initializable {
	
	@FXML
	private TableView<Department> tableViewDepartment;
	
	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	
	@FXML
	private TableColumn<Department, String> tableColumnName;
	
	@FXML
	private Button btNew;
	
	@FXML
	public void onBtNewAction() {
		System.out.println("onBtNewAction");
	}
	

	@Override
	public void initialize(URL url, ResourceBundle rsb) {
		initializeNodes(); /*método auxiliar criado para iniciar algum componente na tela*/
	}


	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name")); /*comando padrão do JavaFX para iniciar o comportamento das colunas*/
		
		/*comando para fazer com que a tableview acompanhe a altura e a largura da janela*/
		/*a classe Stage controla propriedades básicas da janela*/
		Stage stage = (Stage) Main.getMainScene().getWindow();
		/*neste caso, foi criada uma referência para a Stage*/
		/*getWindow é uma superclasse da classe Stage*/
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty()); /*comando que faz o tableview acompanhar a altura da janela*/
	}
	
	

}
