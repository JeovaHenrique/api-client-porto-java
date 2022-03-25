package cliente.porto.testConfig;


import cliente.porto.repositories.ClientRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import cliente.porto.entities.client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

import static cliente.porto.entities.Categoria.IMPORTACAO;
import static cliente.porto.entities.Status.CHEIO;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

    @Autowired
    private ClientRepositories ClientRepositories;

    @Override
    public void run(String... args) throws Exception {
        client c1 = new client(null, "maria", "TEST1234567", 20, IMPORTACAO, CHEIO);
        client c2 = new client(null, "jorge", "TEST1234557", 20, IMPORTACAO, CHEIO);

        ClientRepositories.saveAll(Arrays.asList(c1,c2));
    }
}
