package udesc.pin1.AproveitaEssaJpa2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udesc.pin1.AproveitaEssaJpa2.model.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador,Long> {


}
