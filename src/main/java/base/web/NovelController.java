package base.web;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import org.springframework.http.HttpStatus;

import base.data.NovelRepository;
import base.data.reference.TechniqueType;
import base.domain.Novel;
import base.domain.NovelCharacter;
import base.domain.Technique;
import base.domain.requests.CreateNovelRequest;
import base.domain.requests.UpdateTechniqueRequest;
import base.domain.responses.TechniqueResponse;
import base.service.CharacterService;
import base.service.NovelService;
import base.service.TechniqueService;

@RestController
@RequestMapping("/novel")
@Api(basePath = "/novel", value = "Novel", description = "Operations with novel", produces = "application/json")
@CrossOrigin
public class NovelController {
	
	@Autowired
	NovelRepository novelRepository;
	
	@Autowired
	CharacterService characterService;
	
	@Autowired
	NovelService novelService;
	
	@Autowired
	TechniqueService techniqueService;
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create novel")
    @ApiResponses(value = @ApiResponse(code = 201, message = "Created"))
	public UUID createNovel(@RequestBody CreateNovelRequest createNovelRequest) {
		return novelService.createNovel(createNovelRequest);
	}

	@RequestMapping(value="/getById", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Get novel")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Success"))
	public Novel getNovel(@RequestParam("id") UUID id) {
		return novelService.getById(id);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Gets all novel")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Success"))
	public List<Novel> getAllNovels() {
		return (List<Novel>) novelRepository.findAll();
	}
	
	@RequestMapping(value="/character/add", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Adds a character to a novel")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Success"))
	public void addCharacter(@RequestParam("novelId") UUID novelId, @RequestParam("characterId") UUID characterId) {
		NovelCharacter character = characterService.getCharacter(characterId);
		novelService.addCharacter(novelId, character);
	}
	
	@RequestMapping(value="/technique", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Sets the novel's technique")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Success"))
	public TechniqueResponse updateTechnique(@RequestBody UpdateTechniqueRequest updateTechniqueRequest) {
		novelService.setTechnique(updateTechniqueRequest.novelId, updateTechniqueRequest.technique);
		return new TechniqueResponse(updateTechniqueRequest.technique);
	}
	
	@RequestMapping(value="/technique", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Gets a detailed response for a given technique")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Success"))
	public Technique getTechnique(TechniqueType technique) {
		return techniqueService.getTechnique(technique);
	}
	
}
