package br.com.quintoandar.sakuraerrorcaptor.controller;

import br.com.quintoandar.sakuraerrorcaptor.model.TrackedSystem;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.TrackedSystemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trackedSystem")
public class TrackedSystemController {

    @Autowired
    private TrackedSystemService trackedSystemService;

    @GetMapping
    @ApiOperation("Search all tracked systems")
	@ApiResponses(value = {@ApiResponse(code = 200, message="Tracked system exists"), @ApiResponse(code = 404, message="Tracked system doesn't exist")})
	public ResponseEntity<Iterable<TrackedSystem>> getAll(){
        return new ResponseEntity<>(trackedSystemService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a tracked system by id")
	@ApiResponses(value = {@ApiResponse(code = 200, message="Tracked system exists"), @ApiResponse(code = 404, message="Tracked system doesn't exist")})
	public ResponseEntity<ResponseEntity<TrackedSystem>> getById(@PathVariable Long id){

        //return new ResponseEntity<TrackedSystem>(_trackedSystemService.findById(id)
                //.orElseThrow(() -> new NotFoundException("Notfound TrackedSystem with id: " + id)), HttpStatus.OK);

        Optional<TrackedSystem> trackedSystem = trackedSystemService.findById(id);
        return new ResponseEntity<>(trackedSystem.isPresent() ? ResponseEntity.ok(trackedSystem.get()) : ResponseEntity.notFound().build(), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    @ApiOperation("Search a tracked system by name")
	@ApiResponses(value = {@ApiResponse(code = 200, message="Tracked system exists"), @ApiResponse(code = 404, message="Tracked system doesn't exist")})
	public ResponseEntity<List<TrackedSystem>> getByName(@PathVariable String name) {
        return new ResponseEntity<>(trackedSystemService.findByName(name), HttpStatus.OK);
    }

    @GetMapping("/token/{token}")
    @ApiOperation("Search a tracked system by token")
	@ApiResponses(value = {@ApiResponse(code = 200, message="Tracked system exists"), @ApiResponse(code = 404, message="Tracked system doesn't exist")})
	public ResponseEntity<TrackedSystem> getByToken(@PathVariable String token)  throws NotFoundException {
        return new ResponseEntity<TrackedSystem>(trackedSystemService.findByToken(token)
                .orElseThrow(() -> new NotFoundException("Notfound TrackedSystem with token: " + token)), HttpStatus.OK);
    }

    @GetMapping("/tenant/{tenantId}")
    @ApiOperation("Search a tracked system by tenant id")
	@ApiResponses(value = {@ApiResponse(code = 200, message="Tracked system exists"), @ApiResponse(code = 404, message="Tracked system doesn't exist")})
	public ResponseEntity<List<TrackedSystem>> getByTenantId(@PathVariable Long tenantId) {
        return new ResponseEntity<>(trackedSystemService.findByTenantId(tenantId), HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation("Create a tracked system")
	@ApiResponses(value = {@ApiResponse(code = 201, message="Tracked system created"), @ApiResponse(code = 409, message="Tracked system already exist")})
	public ResponseEntity<TrackedSystem> post(@Valid @RequestBody TrackedSystem trackedSystem){
        return new ResponseEntity<TrackedSystem>(trackedSystemService.save(trackedSystem), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Update a tracked system")
	@ApiResponses(value = {@ApiResponse(code = 200, message="Tracked system updated"), @ApiResponse(code = 404, message="Tracked system doesn't exist")})
	public ResponseEntity<TrackedSystem> put(@Valid @RequestBody TrackedSystem trackedSystem){
        return new ResponseEntity<TrackedSystem>(trackedSystemService.put(trackedSystem), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a tracked system by id")
	@ApiResponses(value = {@ApiResponse(code = 200, message="Tracked system exists"), @ApiResponse(code = 404, message="Tracked system doesn't exist")})
	public ResponseEntity<Boolean> delete(@PathVariable Long id){
        trackedSystemService.delete(id);
        return new ResponseEntity<Boolean>(true,HttpStatus.OK);
    }

    @DeleteMapping
    @ApiOperation("Delete a tracked system")
	@ApiResponses(value = {@ApiResponse(code = 200, message="Tracked system exists"), @ApiResponse(code = 404, message="Tracked system doesn't exist")})
	public ResponseEntity<Boolean> delete(@Valid @RequestBody TrackedSystem trackedSystem){
        trackedSystemService.delete(trackedSystem);
        return new ResponseEntity<Boolean>(true,HttpStatus.OK);
    }

}
