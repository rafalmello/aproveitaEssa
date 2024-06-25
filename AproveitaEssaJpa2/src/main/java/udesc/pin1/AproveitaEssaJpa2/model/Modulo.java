package udesc.pin1.AproveitaEssaJpa2.model;

import jakarta.persistence.*;

import java.util.Optional;
import java.util.Set;

@Entity
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModulo;

    private int quantTopicos = 0;
    private int topicosFeitos = 0;

    private double porcentagemFeita = (topicosFeitos / quantTopicos);


    private String nomeModulo;

    @Transient
    private int cargaHoraria;

    @ManyToMany
    @JoinTable(name = "topicos_modulos",
            joinColumns = @JoinColumn(name = "idModulo"),
            inverseJoinColumns = @JoinColumn(name = "idTopico"))
    private Set<Topico> topicos;

    @ManyToOne
    @JoinColumn(name = "idProfessor")
    private Professor professorResponsavel;

    @ManyToOne
    @JoinColumn(name = "idAluno")
    private Aluno alunoModulo;

    public Modulo(Long idModulo, String nomeModulo, int cargaHoraria, Set<Topico> topicos, int quantTopicos,
                  int topicosFeitos, double porcentagemFeita, Professor professorResponsavel, Aluno alunoModulo) {
        this.idModulo = idModulo;
        this.nomeModulo = nomeModulo;
        this.cargaHoraria = cargaHoraria;
        this.topicos = topicos;
        this.professorResponsavel = professorResponsavel;
        this.alunoModulo = alunoModulo;
        this.topicosFeitos = 0;
        this.quantTopicos = 0;
        this.porcentagemFeita = 0;
    }

    public void setAlunoModulo(Aluno alunoModulo) {
        this.alunoModulo = alunoModulo;
    }

    public Modulo() {

    }

    public Long getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Long idModulo) {
        this.idModulo = idModulo;
    }

    public String getNomeModulo() {
        return nomeModulo;
    }

    public void setNomeModulo(String nomeModulo) {
        this.nomeModulo = nomeModulo;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Set<Topico> getTopicos() {
        return topicos;
    }

    public void setTopicos(Set<Topico> topicos) {
        this.topicos = topicos;
    }

    public Professor getProfessorResponsavel() {
        return professorResponsavel;
    }

    public void setProfessorResponsavel(Professor professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }

    public Aluno getAlunoModulo() {
        return alunoModulo;
    }




    public int getCargaHoraria() {
        return topicos.stream().mapToInt(Topico::getCargaHoraria).sum();
    }
}
