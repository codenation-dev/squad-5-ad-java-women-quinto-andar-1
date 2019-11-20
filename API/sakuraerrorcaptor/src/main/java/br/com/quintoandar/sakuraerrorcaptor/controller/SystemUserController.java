package br.com.quintoandar.sakuraerrorcaptor.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintoandar.sakuraerrorcaptor.model.SystemUser;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.SystemUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/systemUser")
public class SystemUserController {

	@Autowired
	private SystemUserService systemUserServices;

	/*
	@GetMapping("/{id}")
	@ApiOperation("Search an user by id")
	@ApiResponses(value = {@ApiResponse(code = 200, message="User exists"), @ApiResponse(code = 404, message="User doesn't exist")})
	public ResponseEntity<SystemUser> findById(@PathVariable Long id){
		return new ResponseEntity<SystemUser>(systemUserServices.findById(id).orElseThrow(() -> new SystemUserNotFound(id)), HttpStatus.OK);
	}
	*/

	@GetMapping("/{email}")
	@ApiOperation("Search an user by email")
	@ApiResponses(value = {@ApiResponse(code = 200, message="User exists"), @ApiResponse(code = 404, message="User doesn't exist")})
	public ResponseEntity<SystemUser> findByEmail(@PathVariable String email){
		return new ResponseEntity<SystemUser>(HttpStatus.OK);
	}

	/*
	@PostMapping
	@ApiOperation("Create an user")
	@ApiResponses(value = {@ApiResponse(code = 200, message="User exists"), @ApiResponse(code = 404, message="User doesn't exist")})
	public ResponseEntity<SystemUser> save(@Valid @RequestBody SystemUser systemUser){
		return new ResponseEntity<SystemUser>(systemUserServices.save(systemUser), HttpStatus.CREATED);
	}
	*/

	@GetMapping("/token/{token}")
	@ApiOperation("Search an user by token")
	@ApiResponses(value = {@ApiResponse(code = 200, message="User exists"), @ApiResponse(code = 404, message="User doesn't exist")})
	public ResponseEntity<SystemUser> findByToken(@PathVariable String token){
		return new ResponseEntity<SystemUser>(HttpStatus.OK);
	}

	@GetMapping
	@ApiOperation("Search all users")
	@ApiResponses(value = {@ApiResponse(code = 200, message="User exists"), @ApiResponse(code = 404, message="User doesn't exist")})
	public ResponseEntity<Iterable<SystemUser>> pesquisar() {
		return new ResponseEntity<>(systemUserServices.pesquisar(),HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@ApiOperation("Delete an user by id")
	@ApiResponses(value = {@ApiResponse(code = 200, message="User removed"), @ApiResponse(code = 404, message="User doesn't exist")})
	public ResponseEntity<Boolean> deletar(@PathVariable Long id) {
		systemUserServices.deletar(id);
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}

	@PutMapping
	@ApiOperation("Delete an user")
	@ApiResponses(value = {@ApiResponse(code = 200, message="User removed"), @ApiResponse(code = 404, message="User doesn't exist")})
	public ResponseEntity<Boolean> alterar(@Valid @RequestBody SystemUser systemUser) {
		systemUserServices.alterar(systemUser);
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}
}
