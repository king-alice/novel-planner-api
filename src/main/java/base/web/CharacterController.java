package base.web;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import base.domain.NovelCharacter;
import base.domain.Relationship;
import base.domain.requests.CreateCharacterRequest;
import base.domain.requests.CreateRelationshipRequest;
import base.service.CharacterService;
import base.service.RelationshipService;

@RestController
@RequestMapping("/character")
@Api(basePath = "/character", value = "Character", description = "Operations with character", produces = "application/json")
@CrossOrigin
public class CharacterController {
	
	@Autowired
	CharacterService characterService;
	
	@Autowired
	RelationshipService relationshipService;

	@RequestMapping(value="/create", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create character	")
    @ApiResponses(value = @ApiResponse(code = 201, message = "Created"))
	public UUID createCharacter(@RequestBody CreateCharacterRequest createCharacterRequest) {
		return characterService.createCharacter(createCharacterRequest.name);
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get character")
    @ApiResponses(value = @ApiResponse(code = 200, message = "Success"))
	public NovelCharacter getCharacter(@RequestParam("id") UUID characterId) {
		return characterService.getCharacter(characterId);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Gets all characters")
    @ApiResponses(value = @ApiResponse(code = 200, message = "Success"))
	public List<NovelCharacter> getAll() {
		return characterService.getAll();
	}
	
	@RequestMapping(value="/relationship", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Creates a relationship")
    @ApiResponses(value = @ApiResponse(code = 201, message = "Created"))
	public UUID createRelationship(@RequestBody CreateRelationshipRequest createRelationshipRequest) {
		return relationshipService.createRelationship(createRelationshipRequest);
	}
	
	@RequestMapping(value="/relationship", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Gets a relationship")
    @ApiResponses(value = @ApiResponse(code = 200, message = "Success"))
	public Relationship getRelationship(@RequestParam("id") UUID relationshipId) {
		return relationshipService.getRelationship(relationshipId);
	}
	
	@RequestMapping(value="/getRelationships", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Gets all relationships for a character")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Success"))
	public List<Relationship> getRelationshipsByCharacter(@RequestParam("id") UUID characterId) {
		return relationshipService.getRelationshipsByCharacter(characterId);
	}
	
}
