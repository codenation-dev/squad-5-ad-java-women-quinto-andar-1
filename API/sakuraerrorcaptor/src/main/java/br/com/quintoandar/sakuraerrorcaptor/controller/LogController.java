package br.com.quintoandar.sakuraerrorcaptor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintoandar.sakuraerrorcaptor.model.Log;
import br.com.quintoandar.sakuraerrorcaptor.service.LogServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/log")
public class LogController {

	@Autowired
	LogServiceImpl logService;
	
	@ApiOperation("Search a log by id")
	@ApiResponses(value = {@ApiResponse(code = 200, message="Log exists"), @ApiResponse(code = 404, message="Log doesn't exist")})
	@GetMapping("/{id}")
	public ResponseEntity<Log> findById(@PathVariable Long id) {
		return new ResponseEntity<Log>(logService.findById(id).orElse(new Log()), HttpStatus.OK);
	}
	
	@ApiOperation("Search all logs")
	@ApiResponses(value = {@ApiResponse(code = 200, message="Logs exists"), @ApiResponse(code = 404, message="Logs doesn't exist")})
	@GetMapping()
	public ResponseEntity<List<Log>> findAll() {
		return new ResponseEntity<List<Log>>(logService.findAll(), HttpStatus.OK);
	}
	
}
