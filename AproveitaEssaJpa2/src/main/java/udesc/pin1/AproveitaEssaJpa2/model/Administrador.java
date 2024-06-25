package udesc.pin1.AproveitaEssaJpa2.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Administrador  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdministrador;

    @OneToMany(mappedBy = "administradorAluno")
    List<Aluno>alunos = new ArrayList<Aluno>();

    @OneToMany(mappedBy = "administradorProfessor")
    List<Professor>professores = new ArrayList<Professor>();
    @OneToMany(mappedBy = "administradorModulo")
    List<Modulo>modulos = new ArrayList<Modulo>();
    @OneToMany(mappedBy = "administradorTopico")
    List<Topico>topico = new ArrayList<Topico>();
    @OneToMany(mappedBy = "administradorDisciplina")
    List<Disciplina> disciplinas = new ArrayList<Disciplina>();

    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String telefone;


    public Administrador(List<Aluno> alunos, List<Professor> professores, List<Modulo> modulos, List<Disciplina> disciplinas, String nome, String cpf, String email, String senha, String telefone) {
        this.alunos = alunos;
        this.professores = professores;
        this.modulos = modulos;
        this.disciplinas = disciplinas;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }

    public Administrador() {

    }

    public Long getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Long idAdministrador) {
        this.idAdministrador = idAdministrador;
    }



    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    public List<Disciplina> getDiciplinas() {
        return disciplinas;
    }

    public void setDiciplinas(List<Disciplina> diciplinas) {
        this.disciplinas = diciplinas;
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


}
