package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import base.data.reference.Genre;
import base.domain.Novel;

public class NovelTest {
	Novel novel;
	ArrayList<Genre> genres;

	@Test
	public void canInstantiateEmptyConstructor() {
		Novel novel = new Novel();
		assertNotNull(novel);
	}
	
	@Before
	public void initTest() {
		genres = new ArrayList<Genre>();
		genres.add(Genre.ACTION);
		novel = new Novel("test");
		novel.setGenres(genres);
	}
	
	@Test
	public void canInstantiateFullConstructor() {
		assertNotNull(novel);
	}
	
	@Test
	public void canGetTitle() {
		String title = novel.getTitle();
		assertEquals(title, "test");
	}
	
	@Test
	public void canSetTitle() {
		novel.setTitle("new title");
		assertEquals("new title", novel.getTitle());
	}
	
	@Test
	public void canGetGenres() {
		List<Genre> response = novel.getGenres();
		assertEquals(genres, response);
	}
	
	@Test
	public void canSetGenres() {
		genres.add(Genre.HORROR);
		novel.setGenres(genres);
		assertEquals(genres, novel.getGenres());
	}
	
	@Test
	public void canGetId() {
		assertNotNull(novel.getId());
	}
}
