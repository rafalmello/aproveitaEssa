package udesc.pin1.AproveitaEssaJpa2.model;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@Entity
public class Aluno {




    @ManyToOne
    @JoinColumn(name = "idAdministrador")
    private Administrador administradorAluno;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAluno; // o id aluno vai ser igual ao id usuario, quando colocar o
    // idUsuario o id aluno
    // recebera o mesmo valor idAluno
    @OneToMany(mappedBy = "alunoDisciplina", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Disciplina> disciplinas;




    @OneToMany(mappedBy = "alunoModulo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Modulo> modulos;


    @ManyToMany
    @JoinTable(name = "alunos_Professor",
            joinColumns = {@JoinColumn(name = "idAluno", referencedColumnName = "idAluno")},// deveria ser idAluno
            inverseJoinColumns = {@JoinColumn(name ="idProfessor" ,referencedColumnName = "idProfessor")})// deveria ser idProfessor
    private Set<Professor> professores;

    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String telefone;

    private String nomeCurso;



    public Aluno(Long idAluno, Set<Disciplina> disciplinas, Set<Modulo> modulos, Set<Professor> professores, String nome, String cpf, String email, String senha, String telefone, String nomeCurso) {
        this.disciplinas = disciplinas;
        this.modulos = modulos;
        this.professores = professores;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.nomeCurso = nomeCurso;
    }




    public Aluno() {

    }

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
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

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }


    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Set<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Set<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }

    public Set<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(Set<Professor> professores) {
        this.professores = professores;
    }


}


