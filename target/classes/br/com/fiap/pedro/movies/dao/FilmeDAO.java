package br.com.fiap.pedro.movies.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.pedro.movies.model.Filme;
import br.com.fiap.pedro.movies.util.JPAUtil;

public class FilmeDAO {
	
	EntityManager manager = JPAUtil.getManager();
	
	
	public List<Filme> buscarTodos() {
		TypedQuery<Filme> query = 
				manager.createQuery("SELECT a FROM Filme a", Filme.class);
		return query.getResultList();
		//return retornarDadosDeTeste();
	}
	
	public void apagar(Filme Filme) {
		manager.getTransaction().begin();
		manager.remove(Filme);
		manager.getTransaction().commit();
	}

	public void apagar(Long id) {
		apagar(buscarPorId(id));
	}

	public Filme buscarPorId(Long id) {
		return manager.find(Filme.class, id);
	}

	private List<Filme> retornarDadosDeTeste(){
		ArrayList<Filme> lista = new ArrayList<Filme>();
		return lista;
	}

	public void create(Filme filme) {
		
	}

}
