package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import base.data.reference.StepType;
import base.domain.TechniqueStep;
import base.domain.structure.SectionType;

public class TechniqueStepTest {
	
	@Test
	public void canInstantiateTechniqueStep() {
		TechniqueStep techniqueStep = new TechniqueStep();
		techniqueStep.type = StepType.SUMMARY;
		techniqueStep.sectionType = SectionType.ACT;
		
		assertNotNull(techniqueStep);
		assertEquals(techniqueStep.type, StepType.SUMMARY);
		assertEquals(techniqueStep.sectionType, SectionType.ACT);
	}

}
