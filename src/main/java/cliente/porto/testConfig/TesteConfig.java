package cliente.porto.testConfig;


import cliente.porto.entities.Movimentacao;
import cliente.porto.entities.StatusMoviEnum;
import cliente.porto.repositories.ClientRepositories;
import cliente.porto.repositories.MovimentacaoRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import cliente.porto.entities.client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

import static cliente.porto.entities.CategoriaEnum.IMPORTACAO;
import static cliente.porto.entities.StatusEnum.CHEIO;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

    @Autowired
    private ClientRepositories ClientRepositories;

    @Autowired
    private MovimentacaoRepositories MovimentacaoRepositories;

    @Override
    public void run(String... args) throws Exception {
        client c1 = new client(null, "maria", "TEST1234567", 20, IMPORTACAO, CHEIO);
        client c2 = new client(null, "jorge", "TEST1234557", 20, IMPORTACAO, CHEIO);
        client c3 = new client(null, "jorge2", "TEST1234657", 20, IMPORTACAO, CHEIO);

        Movimentacao m1 = new Movimentacao(null, Instant.parse("2022-03-25T19:00:00Z"), StatusMoviEnum.EMBARQUE, c1);
        Movimentacao m2 = new Movimentacao(null, Instant.parse("2022-03-25T19:00:00Z"), StatusMoviEnum.DESCARGA, c2);
        Movimentacao m3 = new Movimentacao(null, Instant.parse("2022-03-25T19:00:00Z"), StatusMoviEnum.GATE_IN, c1);

        ClientRepositories.saveAll(Arrays.asList(c1,c2,c3));
        MovimentacaoRepositories.saveAll(Arrays.asList(m1,m2,m3));
    }
}
