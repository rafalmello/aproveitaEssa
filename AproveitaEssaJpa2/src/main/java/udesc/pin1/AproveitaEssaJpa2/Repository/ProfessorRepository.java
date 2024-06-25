package udesc.pin1.AproveitaEssaJpa2.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import udesc.pin1.AproveitaEssaJpa2.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    //@Query("Select * FROM PROFESSOR WHERE email = '' ")
    Professor findByEmail(String email);
}
