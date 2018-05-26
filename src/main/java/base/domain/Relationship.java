package base.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import base.data.reference.RelationshipType;

@Entity
@Table(name="character_relationships")
public class Relationship {
	
	@Id
	private UUID id;
	
	private UUID first;
	private UUID second;

	@Enumerated(EnumType.STRING)
	@Column(name="relationship_type",length=100)
	private RelationshipType relationshipType;

	public Relationship() {
		
	}
	
	public Relationship(UUID first, UUID second, RelationshipType relationshipType) {
		this.id = UUID.randomUUID();
		this.first = first;
		this.second = second;
		this.relationshipType = relationshipType;
	}

	public UUID getId() {
		return this.id;
	}
	
	public UUID getFirst() {
		return this.first;
	}
	
	public UUID getSecond() {
		return this.second;
	}
	
	public RelationshipType getRelationshipType() {
		return this.relationshipType;
	}
}
