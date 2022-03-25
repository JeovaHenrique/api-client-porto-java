package cliente.porto.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clients;
    private String numCont;
    private Integer tip;
    private Categoria categoria;
    private Status status;

    @OneToMany(mappedBy = "client")
    private final List<Movimentação> Mover = new ArrayList<>();

    public client() {
    }

    public client(Long id, String clients, String numCont, Integer tip, Categoria categoria, Status status) {
        this.id = id;
        this.clients = clients;
        this.numCont = numCont;
        this.tip = tip;
        this.categoria = categoria;
        this.status = status;
    }

    public List<Movimentação> getMover() {
        return Mover;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClients() {
        return clients;
    }

    public void setClients(String clients) {
        this.clients = clients;
    }

    public Integer getTip() {
        return tip;
    }

    public void setTip(Integer tip) {
        if(tip == 20 || tip == 40) {
            this.tip = tip;
        } else {
            System.out.println(-1);
        }
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getNumCont() {
        return numCont;
    }

    public void setNumCont(String numCont) {
        if(numCont.length() ==  12) {
            if(!numCont.substring(0,4).matches("[a-zA-Z]*")) {
                this.numCont = "";
            }else if (!numCont.substring(4).matches("[0-9]*")) {
                this.numCont  = "";
            }else {
                this.numCont = numCont;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof client)) return false;
        client client = (client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
