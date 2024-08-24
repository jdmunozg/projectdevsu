package pruebadevsu.projectdevsu.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pruebadevsu.projectdevsu.api.model.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    // Métodos personalizados si es necesario
}