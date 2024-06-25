package udesc.pin1.AproveitaEssaJpa2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import udesc.pin1.AproveitaEssaJpa2.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

     Aluno findByEmail (String email);


}
