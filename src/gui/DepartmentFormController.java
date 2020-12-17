package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepartmentFormController implements Initializable {

	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtName;
	
	@FXML
	private Label labelErrorName; /*atributo criado para mostrar uma mensagem de erro caso d� algum erro no preenchimento do nome*/
	
	@FXML
	private Button btSave;
	
	@FXML
	private Button btCancel;
	
	@FXML
	public void onBtSaveAction() {
		System.out.println("onBtSaveAction");
	}
	
	@FXML
	public void onBtCancelAction() {
		System.out.println("onBtCancelAction");
	}
	

	
	@Override
	public void initialize(URL url, ResourceBundle rsb) {
		initializeNodes();
	}
	
	private void initializeNodes() { /*fun��o para criar as restri��es a serem preenchidas no formul�rio */
		Constraints.setTextFieldInteger(txtId); /*constraints que s� aceita n�mero inteiro no campo Id*/
		Constraints.setTextFieldMaxLength(txtName, 30); /*constraints criada para somente aceitar no campo name 30 caracteres*/
	}

}
