package br.com.quintoandar.sakuraerrorcaptor.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintoandar.sakuraerrorcaptor.dto.SignInDTO;
import br.com.quintoandar.sakuraerrorcaptor.dto.UserDTO;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@PostMapping
	public SignInDTO signIn(@Valid @RequestBody SignInDTO signInDto) {
		return loginService.save(signInDto);
	}
	
	@GetMapping
	public List<UserDTO> findAll() {
		return loginService.findAll();
	}
	
	@GetMapping("/{id}")
	public UserDTO findById(@PathVariable Long id) {
		return loginService.findById(id);
	}
}
