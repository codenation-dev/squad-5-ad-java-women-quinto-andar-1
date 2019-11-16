package br.com.quintoandar.sakuraerrorcaptor.controller;


import java.util.Optional;

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

import br.com.quintoandar.sakuraerrorcaptor.model.SystemUser;
import br.com.quintoandar.sakuraerrorcaptor.service.SystemUserService;

@RestController
@RequestMapping("/systemUser")
public class SystemUserController {
	
	@Autowired
	private SystemUserService systemUserService;
	

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<SystemUser> buscar(@PathVariable Long id) {
		return systemUserService.buscar(id);
	}

	@GetMapping
	public Iterable<SystemUser> pesquisar() {
		return systemUserService.pesquisar();
	}

	@PostMapping
	public SystemUser salvar(@Valid @RequestBody SystemUser systemUser) {
		return systemUserService.salvar(systemUser);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		systemUserService.deletar(id);
		;
	}

	@PutMapping
	public void alterar(@Valid @RequestBody SystemUser systemUser) {
		systemUserService.alterar(systemUser);
	}


}
