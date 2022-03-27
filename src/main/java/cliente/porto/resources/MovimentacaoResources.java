package cliente.porto.resources;

import cliente.porto.entities.Movimentacao;
import cliente.porto.services.MovimentacaoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoResources {

    @Autowired
    private MovimentacaoServices services;

    @GetMapping
    public ResponseEntity<List<Movimentacao>> findAll() {
        List<Movimentacao> list =services.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimentacao> findById(@PathVariable Long id) {
        Movimentacao obj =  services.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
