package cliente.porto.repositories;

import cliente.porto.entities.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovimentacaoRepositories extends JpaRepository <Movimentacao, Long> {
}
