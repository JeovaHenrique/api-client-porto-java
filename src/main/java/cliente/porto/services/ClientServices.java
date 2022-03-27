package cliente.porto.services;

import cliente.porto.entities.Movimentacao;
import cliente.porto.entities.client;
import cliente.porto.repositories.ClientRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServices {

    @Autowired
    private ClientRepositories repository;

    public List<client> findAll() {
        return repository.findAll();
    }

    public client findById(long id) {
        Optional<client> obj = repository.findById(id);
        return obj.get();
    }

    public client insert(client obj) {
        return repository.save(obj);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
    public client update(long id, client obj) {
        client entity = repository.getById(id);
        updateData(entity,obj);
        return repository.save(entity);
    }

    private void updateData(client entity, client obj) {
        entity.setClients(obj.getClients());
        entity.setStatus(obj.getStatus());
        entity.setCategoria(obj.getCategoria());
        entity.setNumCont(obj.getNumCont());
    }
}
