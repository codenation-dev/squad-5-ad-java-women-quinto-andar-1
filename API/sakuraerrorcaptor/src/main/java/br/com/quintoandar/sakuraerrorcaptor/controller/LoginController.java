package br.com.quintoandar.sakuraerrorcaptor.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintoandar.sakuraerrorcaptor.dto.SignInDTO;
import br.com.quintoandar.sakuraerrorcaptor.dto.UserDTO;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.LoginService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@ApiOperation("Create a new user")
	@ApiResponses(value = {@ApiResponse(code = 201, message="User created"), @ApiResponse(code = 409, message="User already exists")})
	@PostMapping
	public ResponseEntity<SignInDTO> signIn(@Valid @RequestBody SignInDTO signInDto) {
		return new ResponseEntity<SignInDTO>(loginService.save(signInDto), HttpStatus.CREATED);
	}
	
	@ApiOperation("Search all users")
	@ApiResponses(value = {@ApiResponse(code = 201, message="User created"), @ApiResponse(code = 409, message="User already exists")})
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		return new ResponseEntity<List<UserDTO>>(loginService.findAll(), HttpStatus.OK);
	}
	
	@ApiOperation("Search an user by id")
	@ApiResponses(value = {@ApiResponse(code = 201, message="User created"), @ApiResponse(code = 409, message="User already exists")})
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
		return new ResponseEntity<UserDTO>(loginService.findById(id), HttpStatus.OK);
	}
}
