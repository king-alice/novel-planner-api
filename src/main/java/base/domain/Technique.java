package base.domain;

import java.util.ArrayList;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import base.data.reference.TechniqueType;

@Entity
@Table(name="technique")
public class Technique {
	
	@Id
	public UUID id;

	@Enumerated(EnumType.STRING)
	public TechniqueType techniqueType;
	
	//public ArrayList<TechniqueStep> steps;
	

}
