package cliente.porto.services;

import cliente.porto.entities.client;
import cliente.porto.repositories.ClientRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServices {

    @Autowired
    private ClientRepositories repositories;

    public List<client> findAll() {
        return repositories.findAll();
    }

    public client findById(long id) {
        Optional<client> obj = repositories.findById(id);
        return obj.get();
    }
}
