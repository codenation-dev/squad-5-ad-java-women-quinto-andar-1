package br.com.quintoandar.sakuraerrorcaptor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintoandar.sakuraerrorcaptor.model.Archive;
import br.com.quintoandar.sakuraerrorcaptor.service.ArchiveServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/archive")
public class ArchiveController {

	@Autowired
	ArchiveServiceImpl archiveService;
	
	@ApiOperation("Search for an archived log by id")
	@ApiResponses(value = {@ApiResponse(code = 200, message="Archive exists"), @ApiResponse(code = 404, message="Archive doesn't exist")})
	@GetMapping("/{id}")
	public ResponseEntity<Archive> findbyId(@PathVariable Long id) {
		Archive a = archiveService.findById(id).orElse(new Archive());
		return new ResponseEntity<Archive>(a, HttpStatus.OK);
	}
	
	@ApiOperation("Search all archived logs")
	@ApiResponses(value = {@ApiResponse(code = 200, message="Archives exists"), @ApiResponse(code = 404, message="Archives doesn't exist")})
	@GetMapping
	public ResponseEntity<List<Archive>> findAll() {
		return new ResponseEntity<List<Archive>>(archiveService.findAll(), HttpStatus.OK);
	}
	
	@ApiOperation("Create a log from an archived log")
	@ApiResponses(value = {@ApiResponse(code = 200, message="Archives exists"), @ApiResponse(code = 404, message="Archives doesn't exist")})
	@GetMapping("/{id}/log")
	public ResponseEntity<Boolean> sendArchiveToLog(@PathVariable Long id) {
		return new ResponseEntity<Boolean>(archiveService.sendArchiveToLog(id), HttpStatus.OK);
	}
	
	@ApiOperation("Delete an archive")
	@ApiResponses(value = {@ApiResponse(code = 200, message="Archives exists"), @ApiResponse(code = 404, message="Archives doesn't exist")})
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		return new ResponseEntity<Boolean>(archiveService.deleteById(id), HttpStatus.OK);
	}
}
