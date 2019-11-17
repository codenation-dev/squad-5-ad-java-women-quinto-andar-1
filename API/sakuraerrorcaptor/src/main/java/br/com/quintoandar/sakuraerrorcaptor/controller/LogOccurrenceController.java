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
	private LogOccurrenceService logOccurrences;
	private LogOccurrenceMapper mapper = new LogOccurrenceMapper();
	
	@GetMapping
	public List<LogDTO> findAll(){
		List<LogOccurrence> logs =  logOccurrences.findAll();
		List<LogDTO> logsDTO = mapper.map(logs);

		return logsDTO;
	}
	
	@GetMapping("/{id}")
	public Optional<LogOccurrence> findById(@PathVariable Long id){
		return logOccurrences.findById(id);
	}

	@GetMapping
	public List<LogDTO> findByLevel(@RequestParam(name="level", required = false) Level level,
									@RequestParam(name="description", required = false) String title,
									@RequestParam(name="origin", required = false) String location){
		List<LogOccurrence> logs =  logOccurrences.findByLevel(level);
		List<LogDTO> logsDTO = mapper.map(logs);

		return logsDTO;
	}

	@GetMapping("/{environment}")
	public List<LogDTO> findByEnvironment(@PathVariable Environment environment){
		List<LogOccurrence> logs =  logOccurrences.findByEnvironment(environment);
		List<LogDTO> logsDTO = mapper.map(logs);

		return logsDTO;
	}
	
	@GetMapping("/{environment}/{level}")
	public List<LogDTO> findByEnvironmentAndLevel(@PathVariable Environment environment, @PathVariable Level level){
		List<LogOccurrence> logs =  logOccurrences.findByEnvironmentAndLevel(environment, level);
		List<LogDTO> logsDTO = mapper.map(logs);

		return logsDTO;
	}
	
	@PostMapping
	public LogOccurrence save(@Valid @RequestBody LogOccurrence logOccurrence) {
		return logOccurrences.save(logOccurrence);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		logOccurrences.delete(id);
	}
	
}
