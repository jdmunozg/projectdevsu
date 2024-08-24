package pruebadevsu.projectdevsu.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import pruebadevsu.projectdevsu.api.model.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    List<Cuenta> findByClienteId(Long clienteId);
}