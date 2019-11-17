package br.com.quintoandar.sakuraerrorcaptor.controller;

import java.util.Optional;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintoandar.sakuraerrorcaptor.model.Environment;
import br.com.quintoandar.sakuraerrorcaptor.model.Level;
import br.com.quintoandar.sakuraerrorcaptor.model.LogOccurrence;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.LogOccurrenceService;


@RestController
@RequestMapping("/logOccurrence")
public class LogOccurrenceController {
	
	@Autowired
	private LogOccurrenceService logOccurrences;
	
	@GetMapping
	public List<LogOccurrence> findAll(){
		return logOccurrences.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<LogOccurrence> findById(@PathVariable Long id){
		return logOccurrences.findById(id);
	}
	
	@GetMapping("/level/{level}")
	public List<LogOccurrence> findByLevel(@PathVariable Level level){
		return logOccurrences.findByLevel(level);
	}
	
	@GetMapping("/environment/{environment}")
	public List<LogOccurrence> findByEnvironment(@PathVariable Environment environment){
		return logOccurrences.findByEnvironment(environment);
	}
	
	@GetMapping("/{environment}/{level}")
	public List<LogOccurrence> findByEnvironmentAndLevel(@PathVariable Environment environment, @PathVariable Level level){
		return logOccurrences.findByEnvironmentAndLevel(environment, level);
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
