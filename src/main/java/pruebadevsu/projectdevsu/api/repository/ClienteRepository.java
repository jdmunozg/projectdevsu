package pruebadevsu.projectdevsu.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pruebadevsu.projectdevsu.api.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}