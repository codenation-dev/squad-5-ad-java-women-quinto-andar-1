package br.com.quintoandar.sakuraerrorcaptor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintoandar.sakuraerrorcaptor.model.Archive;
import br.com.quintoandar.sakuraerrorcaptor.service.ArchiveService;

@RestController
@RequestMapping("/archive")
public class ArchiveController {

	@Autowired
	ArchiveService archiveService;
	
	@GetMapping("/{id}")
	public Archive findAll(@PathVariable Long id) {
		return archiveService.findById(id).orElse(new Archive());
	}
	
	@GetMapping("/{id}/log")
	public boolean sendArchiveToLog(@PathVariable Long id) {
		return archiveService.sendArchiveToLog(id);
	}
	
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable Long id) {
		return archiveService.deleteById(id);
	}
}
