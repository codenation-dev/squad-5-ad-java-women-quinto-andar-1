package br.com.quintoandar.sakuraerrorcaptor.controller;

import java.util.Optional;
import java.util.List;
import javax.validation.Valid;

import br.com.quintoandar.sakuraerrorcaptor.dto.LogDetailsDTO;
import br.com.quintoandar.sakuraerrorcaptor.dto.LogOccurrenceDTO;
import br.com.quintoandar.sakuraerrorcaptor.mapper.LogOccurrenceMapper;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.quintoandar.sakuraerrorcaptor.model.LogOccurrence;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.LogOccurrenceService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/logOccurrence")
public class LogOccurrenceController {
	
	@Autowired
	private LogOccurrenceService logOccurrenceService;
	@Autowired
	private ArchiveService archiveService;
	private LogOccurrenceMapper mapper = new LogOccurrenceMapper();
	
	@GetMapping
	@ApiOperation("Search all logOccurrences")
	@ApiResponses(value = {@ApiResponse(code = 200, message="logOccurrences exists"), @ApiResponse(code = 404, message="logOccurrences doesn't exist")})
	public ResponseEntity<List<LogDetailsDTO>> findAll(){
		List<LogOccurrence> logs =  logOccurrenceService.findAll();
		List<LogDetailsDTO> logsDTO = mapper.map(logs);

		return new ResponseEntity<>(logsDTO, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@ApiOperation("Search a logOccurrence by id")
	@ApiResponses(value = {@ApiResponse(code = 200, message="logOccurrences exists"), @ApiResponse(code = 404, message="logOccurrences doesn't exist")})
	public ResponseEntity<Optional<LogOccurrence>> findById(@PathVariable Long id){
		return new ResponseEntity<>(logOccurrenceService.findById(id), HttpStatus.OK);
	}

	@GetMapping("environment/{environment}")
	@ApiOperation("Search logOccurrences by Filter")
	@ApiResponses(value = {@ApiResponse(code = 200, message="logOccurrences exists"), @ApiResponse(code = 404, message="logOccurrences doesn't exist")})
	public ResponseEntity<List<LogDetailsDTO>> findByFilter(@PathVariable String environment,
                                            @RequestParam(name="level", required = false) String level,
                                            @RequestParam(name="description", required = false) String title,
                                            @RequestParam(name="origin", required = false) String location,
                                            @RequestParam(name="orderBy", required = false) String orderBy){
		List<LogOccurrence> logs =  logOccurrenceService.findByFilter(environment, level, title, location, orderBy);
		List<LogDetailsDTO> logsDTO = mapper.map(logs);

		return new ResponseEntity<>(logsDTO, HttpStatus.OK);
	}

	@PostMapping
	@ApiOperation("Create a logOccurrence")
	@ApiResponses(value = {@ApiResponse(code = 201, message="logOccurrence created"), @ApiResponse(code = 409, message="logOccurrence already exist")})
	public ResponseEntity<LogOccurrence> save(@Valid @RequestBody LogOccurrence logOccurrence) {
		return new ResponseEntity<>(logOccurrenceService.save(logOccurrence), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation("Delete a logOccurrence")
	@ApiResponses(value = {@ApiResponse(code = 200, message="logOccurrences exists"), @ApiResponse(code = 404, message="logOccurrences doesn't exist")})
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        logOccurrenceService.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
	}	
	
	@GetMapping("/{logId}/{occurrenceId}")
	@ApiOperation("Search a logOccurrence by id")
	@ApiResponses(value = {@ApiResponse(code = 200, message="logOccurrences exists"), @ApiResponse(code = 404, message="logOccurrences doesn't exist")})
	public ResponseEntity<List<LogOccurrenceDTO>> count(@PathVariable Long logId, @PathVariable Long occurrenceId){
		return new ResponseEntity<>(logOccurrenceService.countLogOccurrence(logId, occurrenceId), HttpStatus.OK);
	}

	@ApiOperation("Send a logOccurrence to archive")
	@ApiResponses(value = {@ApiResponse(code = 200, message="Archived"), @ApiResponse(code = 404, message="Unable to complete")})
	@GetMapping("/{id}/archive")
	public ResponseEntity<Boolean> archive(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
		return new ResponseEntity<Boolean>(archiveService.sendLogOccurrenceToArchive(id), HttpStatus.OK);
	}
}
