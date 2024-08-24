package pruebadevsu.projectdevsu.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pruebadevsu.projectdevsu.api.model.Movimiento;
import pruebadevsu.projectdevsu.api.repository.MovimientoRepository;

import java.util.List;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    public List<Movimiento> getAllMovimientos() {
        return movimientoRepository.findAll();
    }

    public Movimiento saveMovimiento(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    public Movimiento updateMovimiento(Long id, Movimiento movimientoDetails) {
        Movimiento movimiento = movimientoRepository.findById(id).orElseThrow();
        movimiento.setValor(movimientoDetails.getValor());
        movimiento.setSaldo(movimientoDetails.getSaldo());
        // Actualizar otros campos
        return movimientoRepository.save(movimiento);
    }

    public void deleteMovimiento(Long id) {
        movimientoRepository.deleteById(id);
    }
}

