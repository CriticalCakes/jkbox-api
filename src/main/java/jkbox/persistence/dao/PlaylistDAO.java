package jkbox.persistence.dao;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

import jkbox.exceptions.PlaylistAlreadyExists;
import jkbox.exceptions.PlaylistNotFoundException;
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
	public Playlist create(Playlist p) throws PlaylistAlreadyExists {
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			
			// Faz a persistencia do modelo			
			em.persist(p);
			
			em.getTransaction().commit();
			em.close();
			
		}
		catch(EntityExistsException e) {
			throw new PlaylistAlreadyExists("Playlist já existe");
		}
		return p;
	}
	
	/**
	 * Edita uma Playlist especificada pelo id.
	 * @param id Long id da Playlist que será editada.
	 * @param pl Playlist é uma entidade preenchida com novos dados.
	 * @return Playlist atualizada e persistida.
	 */
	public Playlist update(Long id, Playlist pl) throws PlaylistNotFoundException {
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			
			pl.setId(id);
			em.merge(pl);
			
			em.getTransaction().commit();
			em.close();			
		}
		catch(EntityNotFoundException e) {
			throw new PlaylistNotFoundException("Playlist não encontrada");
		}
		return pl;
	}
	
	/**
	 * Exclui uma Playlist especificada pelo id.
	 * @param id Long id da Playlist que será excluída.
	 */
	public void delete(Long id) throws PlaylistNotFoundException {
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			
			em.remove(em.getReference(Playlist.class, id));
			
			em.getTransaction().commit();
			em.close();
		}
		catch(EntityNotFoundException e) {
			throw new PlaylistNotFoundException("Playlist não encontrada");
		}
	}
	
	/**
	 * Retorna uma Playlist especificada pelo id.
	 * @param id Long id da Playlist que será retornada.
	 * @return Playlist especificada.
	 * @throws PlaylistNotFoundException
	 */
	public Playlist get(Long id) throws PlaylistNotFoundException {		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// Consulta o objeto
		Playlist pl = em.find(Playlist.class, id);
		
		em.close();			
		
		if(pl == null) 
			throw new PlaylistNotFoundException("Playlist não encontrada");
		
		return pl;
	}
}
