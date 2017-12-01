package jkbox.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jkbox.persistence.models.Playlist;

/**
 * Persistência de dados da Playlist.
 * @author Lincon Dias e Pedro Henrique Fernandes.
 *
 */
public class PlaylistDAO {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jkbox");
	
	/**
	 * Faz a persistência de uma Playlist.
	 * @param p Playlist que será persistida.
	 * @return Playlist persistida.
	 */
	public Playlist create(Playlist p) {
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			
			// Faz a persistencia do modelo
			// TODO tratar exceções na criação
			em.persist(p);
			
			em.getTransaction().commit();
			em.close();
			return p;
		}
		catch() {
			
		}
	}
	
	/**
	 * Edita uma Playlist especificada pelo id.
	 * @param id Long id da Playlist que será editada.
	 * @param pl Playlist é uma entidade preenchida com novos dados.
	 * @return Playlist atualizada e persistida.
	 */
	public Playlist update(Long id, Playlist pl) {
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			
			pl.setId(id);
			em.merge(pl);
			
			em.getTransaction().commit();
			em.close();
			return pl;
		}
		catch() {
			
		}
	}
	
	/**
	 * Exclui uma Playlist especificada pelo id.
	 * @param id Long id da Playlist que será excluída.
	 */
	public void delete(Long id) {
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			
			em.remove(em.getReference(Playlist.class, id));
			
			em.getTransaction().commit();
			em.close();
		}
		catch() {
			
		}
	}
	
	/**
	 * Retorna uma Playlist especificada pelo id.
	 * @param id Long id da Playlist que será retornada.
	 * @return Playlist especificada.
	 */
	public Playlist get(Long id) {
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			
			// Consulta o objeto
			// TODO tratar exceções na busca
			Playlist pl = em.find(Playlist.class, id);
			
			em.close();
			return pl;
		}
		catch() {
			
		}
	}
}
