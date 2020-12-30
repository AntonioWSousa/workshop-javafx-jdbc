package gui.util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Utils {
	
	public static Stage currenStage(ActionEvent event) {
		return (Stage) ((Node) event.getSource()).getScene().getWindow();
	}
	
	public static Integer tryParseToInt(String str) {
		try { /*neste caso, um try-catch � criado n�o para lan�ar uma exce��o, e sim para, quando houver um conte�do inv�lido (ex:letras ou conte�do vazio), lan�ar um valor nulo*/
			return Integer.parseInt(str);/*neste caso, ou vai retornar um valor inteiro ou um valor nulo*/
		}/*serve tamb�m para facilitar o processo e evitar de repetir o comando toda vez que ler os dados de uma caixinha de um n�mero inteiro*/
		catch (NumberFormatException nfe) {
			return null;
		}

	}

}
