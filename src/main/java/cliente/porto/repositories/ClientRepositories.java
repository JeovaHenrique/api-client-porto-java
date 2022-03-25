package cliente.porto.repositories;

import cliente.porto.entities.client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepositories extends JpaRepository <client, Long> {
}
