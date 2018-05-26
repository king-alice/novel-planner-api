package base.data;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import base.domain.Relationship;

@Component
public interface RelationshipRepository extends CrudRepository<Relationship, UUID>{
	
	@Query("from Relationship r where r.first =?1 or r.second =?1")
	List<Relationship> findAllByFirstOrSecond(UUID id);
	
}
