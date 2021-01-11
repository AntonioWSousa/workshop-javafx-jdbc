package model.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	//carregar os erros na exceção
	private Map<String, String> errors = new HashMap<>(); //o primeiro String indica o nome do campo, e o segundo String indica a mensagem de erro
	
	public ValidationException (String msg) {
		super(msg);
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	public void addError(String fieldName, String errorMessage) {
		errors.put(fieldName, errorMessage); //adicionando uma mensagem de erro, onde o fieldName é o nome do campo, e o errorMessage e a mensagem de erro
	}
}
