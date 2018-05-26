package base.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="characters")
public class NovelCharacter {
	
	@Id
	private UUID id;
	
	private String name;
	
	public NovelCharacter() {
		
	}
	
	public NovelCharacter(String name) {
		this.id = UUID.randomUUID();
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public UUID getId() {
		return this.id;
	}
	

}
