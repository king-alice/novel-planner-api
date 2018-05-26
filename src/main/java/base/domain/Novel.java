package base.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import base.data.reference.Genre;
import base.data.reference.TechniqueType;
import base.domain.structure.NovelSection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="novel")
public class Novel extends NovelSection {

	@Id
	private UUID id;
	
	private String title;
	
	@ElementCollection(targetClass = Genre.class)
	@Enumerated(EnumType.STRING)
	private List<Genre> genres;
	
	@ManyToMany
	@JoinTable(
	      name="novel_characters",
	      joinColumns=@JoinColumn(name="novel_id", referencedColumnName="id"),
	      inverseJoinColumns=@JoinColumn(name="character_id", referencedColumnName="id"))
	private List<NovelCharacter> characters;

	@Enumerated(EnumType.STRING)
	private TechniqueType technique;
	
	public Novel() {
		
	}
	
	public Novel(String title) {
		this.title = title;	
		this.characters = new ArrayList<NovelCharacter>();
		this.id = UUID.randomUUID();
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public UUID getId() {
		return this.id;
	}
	
	public List<Genre> getGenres() {
		return this.genres;
	}
	
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	
	public List<NovelCharacter> getCharacters() {
		return this.characters;
	}
	
	public void addCharacter(NovelCharacter novelCharacter) {
		this.characters.add(novelCharacter);
	}
	
	public TechniqueType getTechnique() {
		return this.technique;
	}
	
	public void setTechnique(TechniqueType technique) {
		this.technique = technique;
	}
}
