package br.com.fiap.pedro.componentes;

import java.awt.Dimension;

import javax.swing.JComboBox;

import br.com.fiap.pedro.util.BordaFactory;

public class MeuComboBox extends JComboBox<String> {

	private static final long serialVersionUID = -73642545873453690L;

	private String[] generos;

	public MeuComboBox(String[] generos) {
		super();
		this.generos = generos;
		init();
	}

	private void init() {
		for (String genero : generos) {
			this.addItem(genero);
		}
		this.setPreferredSize(new Dimension(146, 20));
		this.setBorder(BordaFactory.criar());
	}

}
