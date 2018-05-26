package base.data;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import base.domain.NovelCharacter;

@Component
public interface CharacterRepository extends CrudRepository<NovelCharacter, UUID>{
	
}
