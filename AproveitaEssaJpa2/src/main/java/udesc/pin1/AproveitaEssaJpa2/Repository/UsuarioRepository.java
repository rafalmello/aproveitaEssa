package udesc.pin1.AproveitaEssaJpa2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import udesc.pin1.AproveitaEssaJpa2.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
