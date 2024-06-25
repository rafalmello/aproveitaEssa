package udesc.pin1.AproveitaEssaJpa2.model;



import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity

public class Professor{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfessor;

    @ManyToMany(mappedBy = "professores")
    private List<Aluno> alunos;

    @OneToMany(mappedBy = "professorResponsavel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Modulo> modulos;

    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String telefone;

    private double salario;



    public Professor(Long idProfessor, List<Aluno> alunos, List<Modulo> modulos, String nome, String cpf, String email, String senha, String telefone, double salario) {
        this.idProfessor = idProfessor;
        this.alunos = alunos;
        this.modulos = modulos;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.salario = salario;
    }

    public Professor() {

    }



    public Long getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Long idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    // Getters e Setters
}
