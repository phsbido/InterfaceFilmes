package br.com.fiap.pedro.movies.componentes;
import javax.swing.JTextArea;

import br.com.fiap.pedro.movies.util.BordaFactory;

public class MeuTextArea extends JTextArea {

	private static final long serialVersionUID = -5858445682109117932L;

	private int linhas = 3;
	
	private int colunas = 18;
	
	public MeuTextArea() {
		super();
		init();
	}

	private void init() {
		this.setRows(linhas);
		this.setColumns(colunas);
		this.setBorder(BordaFactory.criar());
	}
}
