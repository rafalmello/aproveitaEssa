package udesc.pin1.AproveitaEssaJpa2.model;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "alunos")
    private List<Aluno> alunos = new ArrayList<Aluno>();

    private int ano;
    private int semestre;
    private String nomeDisciplina;
    private String ementa;
    private String instituicao;

    @ElementCollection
    private List<String> conteudos;

    public Disciplina(Long id,List <Aluno> alunos, int ano, int semestre, String nomeDisciplina, String ementa, String instituicao, List<String> conteudos) {
        this.id = id;
        this.alunos = alunos;
        this.ano = ano;
        this.semestre = semestre;
        this.nomeDisciplina = nomeDisciplina;
        this.ementa = ementa;
        this.instituicao = instituicao;
        this.conteudos = conteudos;
    }

    public Disciplina() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List <Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
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
