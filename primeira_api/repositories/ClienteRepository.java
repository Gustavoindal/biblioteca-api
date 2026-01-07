package primeira_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import primeira_api.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
    
}
