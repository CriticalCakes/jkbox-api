package jkbox.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jkbox.persistence.models.Song;

public class SongDAO {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jkbox");
	
	public void create(Song s) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// Faz a persistencia do modelo
		em.persist(s);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void update(Long id) {
		
	}
	
	public void delete(Long id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.remove(em.getReference(Song.class, id));
		
		em.getTransaction().commit();
		em.close();
	}
	
	public void get(Long id) {
		
	}
	
}
