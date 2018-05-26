package web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import base.data.NovelRepository;
import base.data.reference.Genre;
import base.domain.Novel;
import base.domain.NovelCharacter;
import base.domain.requests.CreateNovelRequest;
import base.service.CharacterService;
import base.service.NovelService;
import base.web.NovelController;

public class NovelControllerTest {
	
	@InjectMocks
	NovelController novelController;
	
	@Mock
	NovelService novelService;
	
	@Mock
	NovelRepository novelRepository;
	
	@Mock
	CharacterService characterService;
	
	UUID testId = UUID.randomUUID();
	UUID testCharacterId;
	
	Novel testNovel = new Novel();
	
	NovelCharacter novelCharacter;
	
	List<Novel> testListOfNovels = new ArrayList<Novel>();
	
	CreateNovelRequest createNovelRequest;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		
		testListOfNovels.add(testNovel);
		
		novelCharacter = new NovelCharacter("Test Name");
		testCharacterId = novelCharacter.getId();
		
		createNovelRequest = new CreateNovelRequest();
		
		Mockito.when(novelService.getById(testId)).thenReturn(testNovel);
		Mockito.when(novelService.createNovel(createNovelRequest)).thenReturn(testId);
		Mockito.when(novelRepository.findAll()).thenReturn(testListOfNovels);
		Mockito.when(characterService.getCharacter(novelCharacter.getId())).thenReturn(novelCharacter);
	}

	@Test
	public void canInstantiateNovelController() {
		NovelController novelController = new NovelController();
		assertNotNull(novelController);
	}
	
	@Test
	public void canCreateNovel() {
		UUID response = novelController.createNovel(createNovelRequest);
		assertEquals(response,testId);
	}
	
	@Test
	public void canGetNovel() {
		Novel response = novelController.getNovel(testId);
		assertEquals(response, testNovel);
	}
	
	@Test
	public void canGetAllNovels() {
		List<Novel> novelList = novelController.getAllNovels();
		assertNotNull(novelList);
	}
	
	@Test
	public void canAddCharacter() {
		novelController.addCharacter(testId, testCharacterId);
		Mockito.verify(novelService, times(1)).addCharacter(testId, novelCharacter);
	}
	
}
