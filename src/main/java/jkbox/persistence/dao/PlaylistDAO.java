package jkbox.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jkbox.persistence.models.Playlist;

public class PlaylistDAO {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jkbox");
	
	public void create(Playlist p) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// Faz a persistencia do modelo
		em.persist(p);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(Long id) {
		
	}
	
	public void delete(Long id) {
		
	}
	
	public void get(Long id) {
		
	}
	
	public void getAll() {
		
	}
}
