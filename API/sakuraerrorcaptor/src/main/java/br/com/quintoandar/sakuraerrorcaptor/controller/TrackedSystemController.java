package br.com.quintoandar.sakuraerrorcaptor.controller;

import br.com.quintoandar.sakuraerrorcaptor.model.TrackedSystem;
import br.com.quintoandar.sakuraerrorcaptor.service.interfaces.TrackedSystemService;
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
    private TrackedSystemService _trackedSystemService;

    @GetMapping
    public Iterable<TrackedSystem> getAll(){
        return  _trackedSystemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackedSystem> getById(@PathVariable Long id){

        //return new ResponseEntity<TrackedSystem>(_trackedSystemService.findById(id)
                //.orElseThrow(() -> new NotFoundException("Notfound TrackedSystem with id: " + id)), HttpStatus.OK);

        Optional<TrackedSystem> trackedSystem = _trackedSystemService.findById(id);
        return trackedSystem.isPresent() ? ResponseEntity.ok(trackedSystem.get()) : ResponseEntity.notFound().build();
    }

    @GetMapping("/name/{name}")
    public List<TrackedSystem> getByName(@PathVariable String name) {
        return _trackedSystemService.findByName(name);
    }

    @GetMapping("/token/{token}")
    public ResponseEntity<TrackedSystem> getByToken(@PathVariable String token)  throws NotFoundException {
        return new ResponseEntity<TrackedSystem>(_trackedSystemService.findByToken(token)
                .orElseThrow(() -> new NotFoundException("Notfound TrackedSystem with token: " + token)), HttpStatus.OK);
    }

    @GetMapping("/tenant/{tenantId}")
    public List<TrackedSystem> getByTenantId(@PathVariable Long tenantId) {
        return _trackedSystemService.findByTenantId(tenantId);
    }

    @PostMapping
    public ResponseEntity<TrackedSystem> post(@Valid @RequestBody TrackedSystem trackedSystem){
        return new ResponseEntity<TrackedSystem>(_trackedSystemService.save(trackedSystem), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TrackedSystem> put(@Valid @RequestBody TrackedSystem trackedSystem){
        return new ResponseEntity<TrackedSystem>(_trackedSystemService.put(trackedSystem), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        _trackedSystemService.delete(id);
    }

    @DeleteMapping
    public void delete(@Valid @RequestBody TrackedSystem trackedSystem){
        _trackedSystemService.delete(trackedSystem);
    }

}
