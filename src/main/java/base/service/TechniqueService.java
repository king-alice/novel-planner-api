package base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.data.TechniqueRepository;
import base.data.reference.TechniqueType;
import base.domain.Technique;

@Service
public class TechniqueService {
	
	@Autowired
	TechniqueRepository techniqueRepository;

	public Technique getTechnique(TechniqueType type) {
		return techniqueRepository.findByTechniqueType(type);
	}
	
}
