package cliente.porto.resources;

import entities.Status;
import entities.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static entities.Categoria.IMPORTACAO;
import static entities.Status.CHEIO;

@RestController
@RequestMapping("/cliente")
public class clienteResources {

    @GetMapping
    public ResponseEntity<client> findAll() {
        client c1 = new client(1l, "maria", "TEST1234567", 20, IMPORTACAO, CHEIO);
        return ResponseEntity.ok().body(c1);
    }

}
