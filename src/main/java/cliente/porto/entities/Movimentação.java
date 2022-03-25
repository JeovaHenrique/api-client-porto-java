package cliente.porto.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
public class Movimentação {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;

    @ManyToOne
    @JoinColumn(name="client_id")
    private client client;

    public Movimentação() {

    }

    public Movimentação(Long id, Instant moment, cliente.porto.entities.client client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public cliente.porto.entities.client getClient() {
        return client;
    }

    public void setClient(cliente.porto.entities.client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movimentação)) return false;
        Movimentação that = (Movimentação) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
