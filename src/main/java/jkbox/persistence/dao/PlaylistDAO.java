package jkbox.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jkbox.persistence.models.Playlist;

public class PlaylistDAO {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jkbox");
	
	public Playlist create(Playlist p) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// Faz a persistencia do modelo
		// TODO tratar exceções na criação
		em.persist(p);
		
		em.getTransaction().commit();
		em.close();
		return p;
	}
	
	public Playlist update(Long id, Playlist pl) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		pl.setId(id);
		em.merge(pl);
		
		em.getTransaction().commit();
		em.close();
		return pl;
	}
	
	public void delete(Long id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.remove(em.getReference(Playlist.class, id));
		
		em.getTransaction().commit();
		em.close();
	}
	
	public Playlist get(Long id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// Consulta o objeto
		// TODO tratar exceções na busca
		Playlist pl = em.find(Playlist.class, id);
		
		em.close();
		return pl;
	}
}
