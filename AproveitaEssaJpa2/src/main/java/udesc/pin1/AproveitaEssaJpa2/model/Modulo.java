package udesc.pin1.AproveitaEssaJpa2.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModulo;

    private String nomeModulo;

    @Transient
    private int cargaHoraria;




    @ManyToMany
    private List<Topico> topicos;

    @ManyToOne
    private Professor professorResponsavel;

    @ManyToOne
    @JoinColumn(name = "idAluno")
    private Aluno aluno;

    public Modulo(Long idModulo, String nomeModulo, int cargaHoraria, List<Topico> topicos, Professor professorResponsavel, Aluno aluno) {
        this.idModulo = idModulo;
        this.nomeModulo = nomeModulo;
        this.cargaHoraria = cargaHoraria;
        this.topicos = topicos;
        this.professorResponsavel = professorResponsavel;
        this.aluno = aluno;
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

    public List<Topico> getTopicos() {
        return topicos;
    }

    public void setTopicos(List<Topico> topicos) {
        this.topicos = topicos;
    }

    public Professor getProfessorResponsavel() {
        return professorResponsavel;
    }

    public void setProfessorResponsavel(Professor professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public int getCargaHoraria() {
        return topicos.stream().mapToInt(Topico::getCargaHoraria).sum();
    }
}
