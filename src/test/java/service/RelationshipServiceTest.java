package service;

import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import base.data.RelationshipRepository;
import base.data.reference.RelationshipType;
import base.domain.NovelCharacter;
import base.domain.requests.CreateRelationshipRequest;
import base.service.CharacterService;
import base.service.RelationshipService;

public class RelationshipServiceTest {

	RelationshipService relationshipService;
	
	@InjectMocks
	RelationshipService mockService;
	
	@Mock
	CharacterService characterService;
	
	@Mock
	RelationshipRepository relationshipRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		relationshipService = new RelationshipService();
	}
	
	@Test
	public void canInstantiateRelationshipService() {
		assertNotNull(relationshipService);
	}
	
	@Test
	public void canCreateRelationship() {
		NovelCharacter testCharacter1 = new NovelCharacter("test 1");
		NovelCharacter testCharacter2 = new NovelCharacter("test 2");
		CreateRelationshipRequest testReq = new CreateRelationshipRequest();
		testReq.first = testCharacter1.getId();
		testReq.second = testCharacter2.getId();
		testReq.relationshipType = RelationshipType.ENEMY;
		

		Mockito.when(characterService.getCharacter(testCharacter1.getId())).thenReturn(testCharacter1);
		Mockito.when(characterService.getCharacter(testCharacter2.getId())).thenReturn(testCharacter2);
		
		UUID response = mockService.createRelationship(testReq);
		
		assertNotNull(response);
		Mockito.verify(relationshipRepository).save(Mockito.any());
		
	}

}
