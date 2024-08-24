package pruebadevsu.projectdevsu.api.repository;
import pruebadevsu.projectdevsu.api.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
