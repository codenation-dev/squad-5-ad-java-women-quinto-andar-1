package br.com.quintoandar.sakuraerrorcaptor.controller;

import java.util.Optional;
import java.util.List;

import javax.validation.Valid;

import br.com.quintoandar.sakuraerrorcaptor.dto.LogDTO;
import br.com.quintoandar.sakuraerrorcaptor.mapper.LogOccurrenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.quintoandar.sakuraerrorcaptor.model.Environment;
import br.com.quintoandar.sakuraerrorcaptor.model.Level;
import br.com.quintoandar.sakuraerrorcaptor.model.LogOccurrence;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.LogOccurrenceService;


@RestController
@RequestMapping("/logOccurrence")
public class LogOccurrenceController {
	
	@Autowired
	private LogOccurrenceService logOccurrenceService;
	private LogOccurrenceMapper mapper = new LogOccurrenceMapper();
	
	@GetMapping
	public List<LogDTO> findAll(){
		List<LogOccurrence> logs =  logOccurrenceService.findAll();
		List<LogDTO> logsDTO = mapper.map(logs);

		return logsDTO;
	}
	
	@GetMapping("/{id}")
	public Optional<LogOccurrence> findById(@PathVariable Long id){
		return logOccurrenceService.findById(id);
	}

	@GetMapping("/findByFilter")
	public List<LogDTO> findByFilter(@RequestParam(name="environment", required = false) String environment,
	                                 @RequestParam(name="level", required = false) String level,
									 @RequestParam(name="description", required = false) String title,
                                     @RequestParam(name="origin", required = false) String location,
                                     @RequestParam(name="orderBy", required = false) String orderBy){
		List<LogOccurrence> logs =  logOccurrenceService.findByFilter(environment, level, title, location, orderBy);
		List<LogDTO> logsDTO = mapper.map(logs);

		return logsDTO;
	}

	@GetMapping("findByEnvironment/{environment}")
	public List<LogDTO> findByEnvironment(@PathVariable String environment){
		List<LogOccurrence> logs =  logOccurrenceService.findByEnvironment(Environment.valueOf(environment));
		List<LogDTO> logsDTO = mapper.map(logs);

		return logsDTO;
	}

	@PostMapping
	public LogOccurrence save(@Valid @RequestBody LogOccurrence logOccurrence) {
		return logOccurrenceService.save(logOccurrence);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
        logOccurrenceService.delete(id);
	}
	
}
