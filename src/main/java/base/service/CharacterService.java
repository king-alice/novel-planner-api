package base.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.data.CharacterRepository;
import base.domain.NovelCharacter;
import java.util.List;

@Service
public class CharacterService {
	
	@Autowired
	CharacterRepository characterRepository;
	
	public UUID createCharacter(String name) {
		NovelCharacter character = new NovelCharacter(name);
		characterRepository.save(character);
		return character.getId();
		
	}

	public NovelCharacter getCharacter(UUID characterId) {
		return characterRepository.findById(characterId).get();
	}

	public List<NovelCharacter> getAll() {
		return (List<NovelCharacter>) characterRepository.findAll();
	}
	
}
