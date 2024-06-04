package udesc.pin1.AproveitaEssaJpa2.model;



import jakarta.persistence.*;

import java.util.List;

@Entity
public class Professor extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfessor;

    private double salario;

    private List<Aluno> alunos;

    @OneToMany(mappedBy = "modulos")
    private List<Modulo> modulos;

    public Professor(Long id, String nome, String cpf, String email, String senha, String telefone, Long idProfessor, double salario, List<Aluno> alunos, List<Modulo> modulos) {
        super(id, nome, cpf, email, senha, telefone);
        this.idProfessor = idProfessor;
        this.salario = salario;
        this.alunos = alunos;
        this.modulos = modulos;
    }

    public Professor() {

    }

    public Long getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Long idProfessor) {
        this.idProfessor = idProfessor;
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
