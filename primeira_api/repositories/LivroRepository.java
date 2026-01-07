package primeira_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import primeira_api.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, String> {
    
}
