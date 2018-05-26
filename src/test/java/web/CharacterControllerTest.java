package web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import base.data.reference.RelationshipType;
import base.domain.NovelCharacter;
import base.domain.Relationship;
import base.domain.requests.CreateCharacterRequest;
import base.domain.requests.CreateRelationshipRequest;
import base.service.CharacterService;
import base.service.RelationshipService;
import base.web.CharacterController;

public class CharacterControllerTest {
	
	@InjectMocks
	CharacterController characterController;
	
	@Mock
	CharacterService characterService;
	
	@Mock
	RelationshipService relationshipService;
	
	CreateCharacterRequest createCharacterRequest;
	CreateRelationshipRequest createRelationshipRequest;
	String name = "Test Name";
	String name2 = "Test Character 2";
	UUID testId;
	UUID second;
	UUID testId2;
	NovelCharacter testCharacter;
	NovelCharacter testCharacter2;
	Relationship testRelationship;
	List<NovelCharacter> testList = new ArrayList<NovelCharacter>();
	List<Relationship> testList2 = new ArrayList<Relationship>();
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		createCharacterRequest = new CreateCharacterRequest();
		testCharacter = new NovelCharacter(name);
		testCharacter2 = new NovelCharacter(name2);
		testId = testCharacter.getId();
		second = testCharacter2.getId();
		testList.add(testCharacter);
		testRelationship = new Relationship(testId, second, RelationshipType.FRIEND);
		testId2 = testRelationship.getId();
		testList2.add(testRelationship);
		
		createCharacterRequest.name = name;
		
		Mockito.when(characterService.createCharacter(name)).thenReturn(testId);
		Mockito.when(characterService.getCharacter(testId)).thenReturn(testCharacter);
		Mockito.when(characterService.getCharacter(testId2)).thenReturn(testCharacter2);
		Mockito.when(characterService.getAll()).thenReturn(testList);
		Mockito.when(relationshipService.createRelationship(createRelationshipRequest)).thenReturn(testId);
		Mockito.when(relationshipService.getRelationship(testId2)).thenReturn(testRelationship);
		Mockito.when(relationshipService.getRelationshipsByCharacter(testId)).thenReturn(testList2);
	}

	@Test
	public void canInstantiateCharacterController()	{
		CharacterController characterController = new CharacterController();
		assertNotNull(characterController);
	}
	
	@Test
	public void canCreateCharacter() {
		UUID response = characterController.createCharacter(createCharacterRequest);
		assertNotNull(response);
		assertEquals(response, testId);
	}
	
	@Test
	public void canGetCharacter() {
		NovelCharacter response = characterController.getCharacter(testId);
		assertNotNull(response);
		assertEquals(response, testCharacter);
	}
	
	@Test
	public void canGetAll() {
		List<NovelCharacter> response = characterController.getAll();
		assertNotNull(response);
		assertEquals(response, testList);
	}
	
	@Test
	public void canCreateRelationship() {
		UUID response = characterController.createRelationship(createRelationshipRequest);
		assertNotNull(response);
		assertEquals(response, testId);
	}
	
	@Test
	public void canGetRelationship() {
		Relationship response = characterController.getRelationship(testId2);
		assertNotNull(response);
		assertEquals(response, testRelationship);
	}
	
	@Test
	public void canGetRelationshipsByCharacter() {
		List<Relationship> response = characterController.getRelationshipsByCharacter(testId);
		assertNotNull(response);
		assertEquals(response, testList2);
	}
}
