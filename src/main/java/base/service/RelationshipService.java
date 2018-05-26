package base.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.data.RelationshipRepository;
import base.domain.NovelCharacter;
import base.domain.Relationship;
import base.domain.requests.CreateRelationshipRequest;

@Service
public class RelationshipService {
	
	@Autowired
	CharacterService characterService;
	
	@Autowired
	RelationshipRepository relationshipRepository;

	public UUID createRelationship(CreateRelationshipRequest createRelationshipRequest) {
		// make sure that the characters exist
		NovelCharacter first = characterService.getCharacter(createRelationshipRequest.first);
		NovelCharacter second = characterService.getCharacter(createRelationshipRequest.second);
		
		Relationship relationship = new Relationship(first.getId(), second.getId(), createRelationshipRequest.relationshipType);
		relationshipRepository.save(relationship);
		
		return relationship.getId();
	}

	public Relationship getRelationship(UUID relationshipId) {
		return relationshipRepository.findById(relationshipId).get();
	}

	public List<Relationship> getRelationshipsByCharacter(UUID characterId) {
		return relationshipRepository.findAllByFirstOrSecond(characterId);		
	}
	
	
	
}
