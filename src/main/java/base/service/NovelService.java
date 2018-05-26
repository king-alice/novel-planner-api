package base.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.data.NovelRepository;
import base.data.reference.TechniqueType;
import base.domain.Novel;
import base.domain.NovelCharacter;
import base.domain.requests.CreateNovelRequest;

@Service
public class NovelService {
	
	@Autowired
	NovelRepository novelRepository;
	
	public UUID createNovel(CreateNovelRequest createNovelRequest) {
		Novel novel = new Novel(createNovelRequest.title);
		novelRepository.save(novel);
		return novel.getId();
	}
	
	public Novel getById(UUID id) {
		Optional<Novel> novel = novelRepository.findById(id);
		return novel.get();
	}
	
	public void addCharacter(UUID novelId, NovelCharacter character) {
		Novel novel = this.getById(novelId);
		novel.addCharacter(character);
		novelRepository.save(novel);
	}

	public void setTechnique(UUID novelId, TechniqueType technique) {
		Novel novel = this.getById(novelId);
		novel.setTechnique(technique);
		novelRepository.save(novel);
	}
	
}
