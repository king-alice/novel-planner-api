package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

import base.data.CharacterRepository;
import base.domain.NovelCharacter;
import base.service.CharacterService;

public class CharacterServiceTest {
	@InjectMocks
	CharacterService characterService;
	
	@Mock
	CharacterRepository characterRepository;
	
	String name = "Test Name";
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void canInstantiateCharacterService() {

		CharacterService characterService = new CharacterService();
		assertNotNull(characterService);
	}
	
	@Test
	public void canCreateCharacter() {
		UUID response = characterService.createCharacter(name);
		assertNotNull(response);
		Mockito.verify(characterRepository).save(Mockito.any(NovelCharacter.class));
	}
	
	@Test
	public void canGetCharacter() {
		UUID testId = UUID.randomUUID();
		NovelCharacter testCharacter = new NovelCharacter();
		Mockito.when(characterRepository.findById(testId)).thenReturn(Optional.of(testCharacter));
		NovelCharacter response = characterService.getCharacter(testId);
		assertNotNull(response);
		assertEquals(response, testCharacter);
	}
}
