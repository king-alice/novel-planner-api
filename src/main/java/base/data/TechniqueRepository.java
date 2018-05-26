package base.data;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import base.data.reference.TechniqueType;
import base.domain.Technique;

@Component
public interface TechniqueRepository extends CrudRepository<Technique, UUID>{

	//Technique findByTechniqueType(TechniqueType type);
	
	public Technique findByTechniqueType(TechniqueType type);
	
}
