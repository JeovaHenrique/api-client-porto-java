package cliente.porto.resources;

import cliente.porto.entities.client;

import cliente.porto.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class clienteResources {

    @Autowired
    private ClientServices service;

    @GetMapping
    public ResponseEntity<List<client>> findAll() {
        List<client> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<client> findById(@PathVariable Long id) {
        client obj =  service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<client> insert(@RequestBody client newObj) {
         client obj = service.insert(newObj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<client> update(@PathVariable Long id, @RequestBody client obj) {
        obj = service.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }



}
