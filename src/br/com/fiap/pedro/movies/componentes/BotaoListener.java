package br.com.fiap.pedro.movies.componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import br.com.fiap.pedro.movies.dao.Dao;
import br.com.fiap.pedro.movies.model.Filme;
import br.com.fiap.pedro.movies.util.StarRater;

public class BotaoListener implements ActionListener, MouseListener {

	private Filme filme;
	private MeuTextField fieldTitulo;
	private MeuTextArea fieldSinopse;
	private MeuComboBox comboGeneros;
	private MeuRadioGroup radioOndeAssistir;
	private MeuCheckBox checkAssistido;
	private StarRater avaliacao;	
	private Dao dao = new Dao();	

	public BotaoListener(MeuTextField fieldTitulo, MeuTextArea fieldSinopse, MeuComboBox comboGeneros,
			MeuRadioGroup radioOndeAssistir, MeuCheckBox checkAssistido, StarRater avaliacao) {
		this.fieldTitulo = fieldTitulo;
		this.fieldSinopse = fieldSinopse;
		this.comboGeneros = comboGeneros;
		this.radioOndeAssistir = radioOndeAssistir;
		this.checkAssistido = checkAssistido;
		this.avaliacao = avaliacao;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		criarFilme();
		exibirFilmeNoConsole();
		dao.create(filme);
	}

	private void exibirFilmeNoConsole() {
		JOptionPane.showMessageDialog(null, this.filme.getTitulo() + " foi salvo com sucesso!");
		System.out.println("Título: " + this.filme.getTitulo());
		System.out.println("Sinopse: " + this.filme.getSinopse());
		System.out.println("Gênero: " + this.filme.getGenero());
		System.out.println("Onde assistir: " + this.filme.getOndeAssistir());
		String assistido = "Não";
		assistido = this.filme.isAssistido() ? "Sim" : assistido;
		System.out.println("Assistido: " + assistido);
		System.out.println("Avaliação: " + this.filme.getAvaliacao() + " estrelas");
	}

	private void criarFilme() {
		filme = new Filme();
		filme.setTitulo(fieldTitulo.getText());
		filme.setSinopse(fieldSinopse.getText());
		filme.setGenero(comboGeneros.getSelectedItem().toString());
		filme.setOndeAssistir(radioOndeAssistir.getSelectedButtonText());
		filme.setAssistido(checkAssistido.isSelected());
		filme.setAvaliacao(avaliacao.getSelection());
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

}
