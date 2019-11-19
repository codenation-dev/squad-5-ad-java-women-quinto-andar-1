package br.com.quintoandar.sakuraerrorcaptor.controller;

import br.com.quintoandar.sakuraerrorcaptor.error.OccurrenceNotFound;
import br.com.quintoandar.sakuraerrorcaptor.model.Occurrence;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.OccurrenceService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/occurrence")
public class OccurrenceController {

    @Autowired
    private OccurrenceService occurrences;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation("Search an occurrence by id")
	@ApiResponses(value = {@ApiResponse(code = 200, message="Occurrence exists"), @ApiResponse(code = 404, message="Occurrence doesn't exist")})
	public ResponseEntity<Occurrence> findById(@PathVariable Long id){
        return new ResponseEntity<Occurrence>(occurrences.findById(id).orElseThrow(() -> new OccurrenceNotFound(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/title/{title}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation("Search occurrence by title")
	@ApiResponses(value = {@ApiResponse(code = 200, message="Occurrence exists"), @ApiResponse(code = 404, message="Occurrence doesn't exist")})
	public ResponseEntity<Occurrence> findByTitle(@PathVariable String title){
        return new ResponseEntity<Occurrence>(occurrences.findByTitle(title), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ApiOperation("Create an occurrence")
	@ApiResponses(value = {@ApiResponse(code = 201, message="Occurrence created"), @ApiResponse(code = 409, message="Occurrence already exist")})
	public ResponseEntity<Occurrence> save(@Valid @RequestBody Occurrence occurrence){
        return new ResponseEntity<Occurrence>(occurrences.save(occurrence), HttpStatus.CREATED);
    }

}
