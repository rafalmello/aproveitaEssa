package udesc.pin1.AproveitaEssaJpa2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import udesc.pin1.AproveitaEssaJpa2.model.Aluno;
import udesc.pin1.AproveitaEssaJpa2.model.Topico;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico,Long> {
    List <String> findByName (String nome);
}
