package jkbox.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jkbox.persistence.models.Song;
/**
 * Persistência de dados da Song.
 * @author Lincon Dias e Pedro Henrique Fernandes.
 *
 */
public class SongDAO {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jkbox");

	/**
	 * Faz a persistência de uma Song.
	 * @param s Song que será persistida.
	 * @return Song persistida.
	 */
	public void create(Song s) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// Faz a persistencia do modelo
		em.persist(s);
		
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Edita uma Song especificada pelo id.
	 * @param id Long id da Song que será editada.
	 * @param pl Song é uma entidade preenchida com novos dados.
	 * @return Song atualizada e persistida.
	 */	
	public void update(Long id) {
		try {
			
		}
		catch() {
			
		}
	}
	
	/**
	 * Exclui uma Song especificada pelo id.
	 * @param id Long id da Song que será excluída.
	 */
	public void delete(Long id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.remove(em.getReference(Song.class, id));
		
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Retorna uma Song especificada pelo id.
	 * @param id Long id da Song que será retornada.
	 * @return Song especificada.
	 */
	public void get(Long id) {
		try {
			
		}
		catch() {
			
		}
	}	
}
