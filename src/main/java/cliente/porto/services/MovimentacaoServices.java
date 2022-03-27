package cliente.porto.services;

import cliente.porto.entities.Movimentacao;
import cliente.porto.entities.client;
import cliente.porto.repositories.MovimentacaoRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoServices {

    @Autowired
    private MovimentacaoRepositories repository;

    public List<Movimentacao> findAll() {
        return repository.findAll();
    }

    public Movimentacao findById(long id) {
        Optional<Movimentacao> obj = repository.findById(id);
        return obj.get();
    }

    public Movimentacao insert(Movimentacao obj) {
        return repository.save(obj);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public Movimentacao update(long id, Movimentacao obj) {
        Movimentacao entity = repository.getById(id);
        updateData(entity,obj);
        return repository.save(entity);
    }

    private void updateData(Movimentacao entity, Movimentacao obj) {
        entity.setMove(obj.getMove());
        entity.setMoment(obj.getMoment());
    }
}
