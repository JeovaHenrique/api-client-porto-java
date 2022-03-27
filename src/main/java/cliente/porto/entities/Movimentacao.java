package cliente.porto.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
public class Movimentacao implements Serializable {
    private static  final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    private Integer Move;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="client_id")
    private client client;

    public Movimentacao() {

    }

    public Movimentacao(Long id, Instant moment, StatusMoviEnum Move, cliente.porto.entities.client client) {
        this.id = id;
        this.moment = moment;
        setMove(Move);
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

    public StatusMoviEnum getMove() {
        return StatusMoviEnum.valueOf(Move);
    }

    public void setMove(StatusMoviEnum move) {
        if(move != null) {
            this.Move = move.getCode();
        }
    }

    public client getClient() {
        return client;
    }

    public void setClient(client client ) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movimentacao)) return false;
        Movimentacao that = (Movimentacao) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
