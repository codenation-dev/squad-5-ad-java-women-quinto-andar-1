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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/tenant")
public class TenantController {

	@Autowired
	TenantService tenantService;
	
	@PostMapping
	@ApiOperation("Create a tenant")
	@ApiResponses(value = {@ApiResponse(code = 201, message="Tenant created"), @ApiResponse(code = 409, message="Tenant already exist")})
	public ResponseEntity<Tenant> save(@Valid @RequestBody Tenant tenant){
		return new ResponseEntity<Tenant>(tenantService.save(tenant), HttpStatus.CREATED);
    }
	
	@GetMapping("/{id}")
	@ApiOperation("Search tenant by id")
	@ApiResponses(value = {@ApiResponse(code = 200, message="Tenant exists"), @ApiResponse(code = 404, message="Tenant doesn't exist")})
	public ResponseEntity<Tenant> findById(@PathVariable Long id){
		return new ResponseEntity<Tenant>(tenantService.findById(id), HttpStatus.OK);
    }
	
	@GetMapping
	@ApiOperation("Search all tenants")
	@ApiResponses(value = {@ApiResponse(code = 200, message="Tenant exists"), @ApiResponse(code = 404, message="Tenant doesn't exist")})
	public ResponseEntity<List<Tenant>> findAll(){
		return new ResponseEntity<List<Tenant>>(tenantService.findAll(), HttpStatus.OK);
    }
}
