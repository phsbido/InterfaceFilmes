package br.com.fiap.pedro.movies.componentes;
import java.awt.Font;

import javax.swing.JLabel;

import br.com.fiap.pedro.movies.util.Paleta;

public class MeuLabel extends JLabel{

	private static final long serialVersionUID = -917420374860084066L;
	
	private int tamanhoFonte = 12;
	
	public MeuLabel(String texto) {
		super(texto);
		init();
	}
	
	private void init() {
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setFont(new Font(null, Font.BOLD, tamanhoFonte));
		this.setForeground(Paleta.LARANJA);
	}	
	
	public int getTamanhoFonte() {
		return tamanhoFonte;
	}

	public void setTamanhoFonte(int tamanhoFonte) {
		this.tamanhoFonte = tamanhoFonte;
	}

}
