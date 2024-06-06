package udesc.pin1.AproveitaEssaJpa2.model;



import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Professor extends Usuario {

    //@Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
   // private Long idProfessor;

    private double salario;

    @ManyToMany(mappedBy = "professores")
    private Set<Aluno> alunos;

    @OneToMany(mappedBy = "professorResponsavel")
    private List<Modulo> modulos;

    public Professor(Long id, String nome, String cpf, String email, String senha, String telefone, double salario, Set<Aluno> alunos, List<Modulo> modulos) {
        super(id, nome, cpf, email, senha, telefone);
        this.salario = salario;
        this.alunos = alunos;
        this.modulos = modulos;
    }

    public Professor() {

    }



    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
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
