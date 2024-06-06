package udesc.pin1.AproveitaEssaJpa2.model;


import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity

public class Aluno extends Usuario {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long idAluno;


    @OneToMany(mappedBy = "alunoDisciplina")
    private Set<Disciplina> disciplinas;


    @OneToMany(mappedBy = "idModulo")
    private Set<Modulo> modulos;

    @ManyToMany
    @JoinTable(name = "alunos_Professor",
            joinColumns = @JoinColumn(name = "idAluno"),
            inverseJoinColumns = @JoinColumn(name ="idProfessor" ))
    private Set<Professor> professores;

    private String nomeCurso;

    public Aluno(Long id, String nome, String cpf, String email, String senha, String telefone, String nomeCurso, Long idAluno, Set<Disciplina> disciplinas, Set<Modulo> modulos, Set<Professor> professores) {
        super(id, nome, cpf, email, senha, telefone);
        this.nomeCurso = nomeCurso;
//        this.idAluno = idAluno;
        this.disciplinas = disciplinas;
        this.modulos = modulos;
        this.professores = professores;
    }

    public Aluno() {

    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

//    public Long getIdAluno() {
//        return idAluno;
//    }

//    public void setIdAluno(Long idAluno) {
//        this.idAluno = idAluno;
//    }

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


