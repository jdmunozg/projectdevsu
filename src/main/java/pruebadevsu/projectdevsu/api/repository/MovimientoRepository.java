package pruebadevsu.projectdevsu.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pruebadevsu.projectdevsu.api.model.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    // Métodos personalizados si es necesario
}

