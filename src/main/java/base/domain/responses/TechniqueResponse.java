package base.domain.responses;

import base.data.reference.TechniqueType;

public class TechniqueResponse {
	
	private TechniqueType technique;
	private String description;
	
	public TechniqueResponse(TechniqueType technique) {
		this.setTechnique(technique);
		this.setDescription(technique.getDesc());
	}

	public TechniqueType getTechnique() {
		return technique;
	}

	public void setTechnique(TechniqueType technique) {
		this.technique = technique;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
