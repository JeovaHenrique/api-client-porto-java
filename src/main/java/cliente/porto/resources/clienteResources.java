package cliente.porto.resources;

import cliente.porto.entities.client;

import cliente.porto.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cliente.porto.entities.Categoria.IMPORTACAO;
import static cliente.porto.entities.Status.CHEIO;

@RestController
@RequestMapping("/cliente")
public class clienteResources {

    @Autowired
    private ClientServices services;

    @GetMapping
    public ResponseEntity<List<client>> findAll() {
        List<client> list =services.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<client> findById(@PathVariable Long id) {
        client obj =  services.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
