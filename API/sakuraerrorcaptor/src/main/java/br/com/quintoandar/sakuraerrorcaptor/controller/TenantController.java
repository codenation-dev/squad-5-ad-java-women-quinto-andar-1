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

import br.com.quintoandar.sakuraerrorcaptor.model.Tenant;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.TenantService;

@RestController
@RequestMapping("/tenant")
public class TenantController {

	@Autowired
	TenantService tenantService;
	
	@PostMapping
    public ResponseEntity<Tenant> save(@Valid @RequestBody Tenant tenant){
		return new ResponseEntity<Tenant>(tenantService.save(tenant), HttpStatus.CREATED);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Tenant> findById(@PathVariable Long id){
		return new ResponseEntity<Tenant>(tenantService.findById(id), HttpStatus.CREATED);
    }
	
	@GetMapping
    public ResponseEntity<List<Tenant>> findAll(){
		return new ResponseEntity<List<Tenant>>(tenantService.findAll(), HttpStatus.CREATED);
    }
}
