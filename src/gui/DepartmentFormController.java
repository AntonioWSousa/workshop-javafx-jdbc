package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;

public class DepartmentFormController implements Initializable {
	
	private Department entity; /*dependência para o departamento*/

	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtName;
	
	@FXML
	private Label labelErrorName;
	
	@FXML
	private Button btSave;
	
	@FXML
	private Button btCancel;
	
	public void setDepartment(Department entity) {
		this.entity = entity;
	}
	
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
	
	private void initializeNodes() { 
		Constraints.setTextFieldInteger(txtId); 
		Constraints.setTextFieldMaxLength(txtName, 30); 
	}
	
	public void updateFormData() {
		if (entity == null) { /*programação defensiva para testar se o departamento está vazio*/
			throw new IllegalStateException("Entity was null");
		}
		txtId.setText(String.valueOf(entity.getId())); /*o porquê foi inserido String.valueOf é porque a caixa de texto trabalha com string, então teria de converter o valor "entity.getId, que é um valor inteiro, para string*/
		txtName.setText(entity.getName());
	}

}
