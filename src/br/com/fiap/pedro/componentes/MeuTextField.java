package br.com.fiap.pedro.componentes;
import java.awt.Dimension;

import javax.swing.JTextField;

import br.com.fiap.pedro.util.BordaFactory;

public class MeuTextField extends JTextField {

	private static final long serialVersionUID = 14850718621436240L;

	public MeuTextField() {
		super();
		init();
	}

	private void init() {
		this.setPreferredSize(new Dimension(146, 20));
		this.setBorder(BordaFactory.criar());
	}
}
