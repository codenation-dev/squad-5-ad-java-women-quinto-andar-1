package br.com.quintoandar.sakuraerrorcaptor.controller;


import br.com.quintoandar.sakuraerrorcaptor.error.SystemUserNotFound;
import br.com.quintoandar.sakuraerrorcaptor.model.SystemUser;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/systemUser")
public class SystemUserController {
	
	@Autowired
	private SystemUserService systemUserServices;
	

	
	 @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	    public ResponseEntity<SystemUser> findById(@PathVariable Long id){
	        return new ResponseEntity<SystemUser>(systemUserServices.findById(id).orElseThrow(() -> new SystemUserNotFound(id)), HttpStatus.OK);
	    }

	 @RequestMapping(method = RequestMethod.POST, produces = "application/json")
	    public ResponseEntity<SystemUser> save(@Valid @RequestBody SystemUser systemUser){
		 return new ResponseEntity<SystemUser>(systemUserServices.save(systemUser), HttpStatus.CREATED);
	    }

}
