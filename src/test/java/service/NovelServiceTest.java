package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;

import java.util.Optional;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import base.data.NovelRepository;
import base.data.reference.TechniqueType;
import base.domain.Novel;
import base.service.NovelService;

public class NovelServiceTest {

	@InjectMocks
	NovelService novelService;
	
	@Mock
	NovelRepository novelRepository;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void canInstantiateNovelService() {
		NovelService novelService = new NovelService();
		assertNotNull(novelService);
	}
	
	@Test
	public void canSetandGetNovelTechnique() {
		TechniqueType technique = TechniqueType.SNOWFLAKE;
		UUID testId;
		Novel testNovel = new Novel("test");
		testId = testNovel.getId();

		doReturn(Optional.of(testNovel)).when(novelRepository).findById(testId);
		
		novelService.setTechnique(testId, technique);
		
		assertEquals(testNovel.getTechnique(), technique);
	}
	
}
