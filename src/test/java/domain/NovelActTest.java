package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

import base.domain.structure.NovelAct;
import base.domain.structure.NovelSection;

public class NovelActTest {

	@Test
	public void canInstantiateNovelAct() {
		NovelAct novelAct = new NovelAct();
		assertNotNull(novelAct);
		assertNotNull(novelAct.getChildren());
	}
	
	@Test
	public void canAddChild() {
		NovelAct parent = new NovelAct();
		NovelAct child = new NovelAct();
		parent.addChild(child);
		
		ArrayList<NovelSection> response = parent.getChildren();
		
		assertNotNull(response);
		assertEquals(response.get(0), child);
	}
	
	@Test
	public void canSetContent() {
		NovelAct novelAct = new NovelAct();
		String testContent = "test";
		novelAct.setContent(testContent);
		
		String response = novelAct.getContent();
		
		assertNotNull(response);
		assertEquals(response, testContent);
	}

	@Test
	public void canSetSummary() {
		NovelAct novelAct = new NovelAct();
		String testSummary = "test";
		novelAct.setSummary(testSummary);
		
		String response = novelAct.getSummary();
		
		assertNotNull(response);
		assertEquals(response, testSummary);
	}
	
}
