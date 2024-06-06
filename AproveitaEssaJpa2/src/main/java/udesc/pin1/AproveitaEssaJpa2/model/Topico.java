package udesc.pin1.AproveitaEssaJpa2.model;



import jakarta.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTopico;

    @ManyToMany(mappedBy = "topicos")
    private Set<Modulo> modulos;

    private int cargaHoraria;

    @Enumerated(EnumType.STRING)
    private TipoTopico tipoTopico;

    public enum TipoTopico {
        EXERCICIO, LINKS, AULA, TEXTO, PROVA
    }

    public Topico(Set<Modulo> modulos, int cargaHoraria, TipoTopico tipoTopico) {
        this.idTopico = idTopico;
        this.modulos = modulos;
        this.cargaHoraria = cargaHoraria;
        this.tipoTopico = tipoTopico;
    }

    public Topico() {

    }

    public Long getIdTopico() {
        return idTopico;
    }

    public void setIdTopico(Long id){
        this.idTopico = id;
    }

    public Set<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public TipoTopico getTipoTopico() {
        return tipoTopico;
    }

    public void setTipoTopico(TipoTopico tipoTopico) {
        this.tipoTopico = tipoTopico;
    }

    // Getters e Setters
}

