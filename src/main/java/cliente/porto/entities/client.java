package cliente.porto.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class client implements Serializable {
    private static final long serialVersionUID = 1l;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clients;
    private String numCont;
    private Integer tip;
    private Integer categoria;
    private Integer status;


    @OneToMany(mappedBy = "client")
    private final List<Movimentacao> Mover = new ArrayList<>();

    public client() {
    }

    public client(Long id, String clients, String numCont, Integer tip, CategoriaEnum categoria, StatusEnum status) {
        this.id = id;
        this.clients = clients;
        this.numCont = numCont;
        this.tip = tip;
        setCategoria(categoria);
        setStatus(status);
    }

    public List<Movimentacao> getMover() {
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
        }
    }

    public CategoriaEnum getCategoria() {
        return CategoriaEnum.valueOf(categoria);
    }

    public void setCategoria(CategoriaEnum categoria) {
        this.categoria = categoria.getCode();
    }

    public StatusEnum getStatus() {
        return StatusEnum.valueOf(status);
    }

    public void setStatus(StatusEnum status) {
        this.status = status.getCode();
    }

    public String getNumCont() {
        return numCont;
    }

    public void setNumCont(String numCont) {
        if(numCont.length() ==  12) {
            if(numCont.substring(0,4).matches("[a-zA-Z]*")) {
                if (numCont.substring(4).matches("[0-9]*")) {
                    this.numCont = numCont;
                }
            }
        }
        throw new IllegalArgumentException("Invalid Number Container");
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
