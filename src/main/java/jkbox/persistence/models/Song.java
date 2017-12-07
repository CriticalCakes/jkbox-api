package jkbox.persistence.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
/**
 * Entidade que representa a Song.
 * @author Lincon Dias e Pedro Henrique Fernandes.
 *
 */
public class Song {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String url;
	private int playing;
	/*@ManyToOne
	@JoinColumn(name="playlist")
	Playlist playlist;*/
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public boolean isPlaying() {
		if ( this.playing == 0 )
			return false;
		return true;
	}
	public void setPlaying(boolean playing) {
		if ( playing )
			this.playing = 1;
		else
			this.playing = 0;
	}
	/*public Playlist getPlaylist() {
		return playlist;
	}
	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}*/
}
