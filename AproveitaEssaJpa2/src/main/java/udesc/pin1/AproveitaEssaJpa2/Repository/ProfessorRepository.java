package udesc.pin1.AproveitaEssaJpa2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import udesc.pin1.AproveitaEssaJpa2.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Professor findyByEmail(String email);
}
