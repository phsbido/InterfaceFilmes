package br.com.fiap.pedro.util;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public abstract class BordaFactory {
	
	public static Border criar() {
		return new LineBorder(Paleta.AZUL);
	}
	
}
