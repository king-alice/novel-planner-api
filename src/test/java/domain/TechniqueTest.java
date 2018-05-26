package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

import base.data.reference.TechniqueType;
import base.domain.Technique;
import base.domain.TechniqueStep;

public class TechniqueTest {

	@Test
	public void canInstantiateTechnique() {
		Technique technique = new Technique();
		technique.techniqueType = TechniqueType.FREESTYLE;
		TechniqueStep step1 = new TechniqueStep();
		//technique.steps = new ArrayList<TechniqueStep>();
		//technique.steps.add(step1);
		
		
		assertNotNull(technique);
		assertEquals(technique.techniqueType, TechniqueType.FREESTYLE);
		//assertNotNull(technique.steps);
		//assertEquals(technique.steps.get(0), step1);
	}
	
}
