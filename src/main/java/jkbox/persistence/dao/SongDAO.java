package jkbox.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jkbox.exceptions.PlaylistNotFoundException;
import jkbox.persistence.models.Playlist;
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
		
	}
	
	/**
	 * Exclui uma Song especificada pelo id.
	 * @param id Long id da Song que será excluída.
	 * @return s Song para ser removido da playlist
	 */
	public Song delete(Long id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Song s = em.getReference(Song.class, id);
		em.remove(s);
		
		em.getTransaction().commit();
		em.close();
		return s;
	}
	
	/**
	 * Retorna uma Song especificada pelo id.
	 * @param id Long id da Song que será retornada.
	 * @return Song especificada.
	 */
	public Song get(Long id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// Consulta o objeto
		Song s = em.find(Song.class, id);
		
		em.close();			
		
		return s;
	}	
}
