package udesc.pin1.AproveitaEssaJpa2.model;



import jakarta.persistence.*;
import java.util.List;

@Entity

public class Aluno extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAluno;


    @ManyToMany
    private List<Disciplina> disciplinas;


    @OneToMany
    @JoinColumn(name = "idModulo")
    private List<Modulo> modulos;

    @ManyToMany
    private List<Professor> professores;

    private String nomeCurso;

    public Aluno(Long id, String nome, String cpf, String email, String senha, String telefone, String nomeCurso, Long idAluno, List<Disciplina> disciplinas, List<Modulo> modulos, List<Professor> professores) {
        super(id, nome, cpf, email, senha, telefone);
        this.nomeCurso = nomeCurso;
        this.idAluno = idAluno;
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

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }


}


