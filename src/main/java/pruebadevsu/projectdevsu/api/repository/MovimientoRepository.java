package pruebadevsu.projectdevsu.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pruebadevsu.projectdevsu.api.model.Movimiento;

import java.sql.Timestamp;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

    List<Movimiento> findByCuentaIdAndFechaBetween(Long cuentaId, Timestamp fechaInicio, Timestamp fechaFin);

}

