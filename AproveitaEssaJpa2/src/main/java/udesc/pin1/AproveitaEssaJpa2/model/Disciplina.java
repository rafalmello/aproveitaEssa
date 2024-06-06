package udesc.pin1.AproveitaEssaJpa2.model;

import jakarta.persistence.*;


import java.util.List;

@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDisciplina;

    @ManyToOne
    @JoinColumn(name = "disciplinas")
    private Aluno alunoDisciplina;

    private int ano;
    private int semestre;
    private String nomeDisciplina;
    private String ementa;
    private String instituicao;

    @ElementCollection
    private List<String> conteudos;

    public Disciplina(Long idDisciplina, Aluno alunoDisciplina, int ano, int semestre, String nomeDisciplina, String ementa, String instituicao, List<String> conteudos) {
        this.idDisciplina = idDisciplina;
        this.alunoDisciplina = alunoDisciplina;
        this.ano = ano;
        this.semestre = semestre;
        this.nomeDisciplina = nomeDisciplina;
        this.ementa = ementa;
        this.instituicao = instituicao;
        this.conteudos = conteudos;
    }

    public Disciplina() {

    }

    public Long getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Long idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Aluno getAlunos() {
        return alunoDisciplina;
    }

    public void setAlunos(Aluno aluno) {
        this.alunoDisciplina = aluno;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public List<String> getConteudos() {
        return conteudos;
    }

    public void setConteudos(List<String> conteudos) {
        this.conteudos = conteudos;
    }

    // Getters e Setters
}
