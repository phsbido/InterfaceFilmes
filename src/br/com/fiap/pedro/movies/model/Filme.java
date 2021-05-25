package br.com.fiap.pedro.movies.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Filme {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo = "";
	
	private String sinopse = "";
	
	private String genero = "";
	
	private String ondeAssistir = "";
	
	private boolean assistido = false;
	
	private int avaliacao = 0;

	public Filme() {

	}

	public Filme(String titulo, String sinopse, String genero, String ondeAssistir, boolean assistido,
			int avaliacao) {
		super();
		this.titulo = titulo;
		this.sinopse = sinopse;
		this.genero = genero;
		this.ondeAssistir = ondeAssistir;
		this.assistido = assistido;
		this.avaliacao = avaliacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getOndeAssistir() {
		return ondeAssistir;
	}

	public void setOndeAssistir(String ondeAssistir) {
		this.ondeAssistir = ondeAssistir;
	}

	public boolean isAssistido() {
		return assistido;
	}
	
	public String getAssistido() {
		return this.isAssistido() ? "Sim" : "Não";
	}

	public void setAssistido(boolean assistido) {
		this.assistido = assistido;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
