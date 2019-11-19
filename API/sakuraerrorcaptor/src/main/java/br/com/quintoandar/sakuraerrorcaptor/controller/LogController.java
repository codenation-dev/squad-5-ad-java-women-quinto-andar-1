package br.com.quintoandar.sakuraerrorcaptor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintoandar.sakuraerrorcaptor.model.Log;
import br.com.quintoandar.sakuraerrorcaptor.service.LogServiceImpl;

@RestController
@RequestMapping("/log")
public class LogController {

	@Autowired
	LogServiceImpl logService;
	
	@GetMapping("/{id}")
	public Log findById(@PathVariable Long id) {
		return logService.findById(id).orElse(new Log());
	}
	
	@GetMapping()
	public List<Log> findAll() {
		return logService.findAll();
	}
	
}
