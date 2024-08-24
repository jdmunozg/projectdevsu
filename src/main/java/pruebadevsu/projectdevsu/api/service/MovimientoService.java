package pruebadevsu.projectdevsu.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pruebadevsu.projectdevsu.api.exception.ResourceNotFoundException;
import pruebadevsu.projectdevsu.api.exception.ValidationException;
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

    public Movimiento getMovimientoById(Long id) {
        return movimientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movimiento no encontrado con id: " + id));
    }

    public Movimiento createMovimiento(Movimiento movimiento) {
        validateMovimiento(movimiento);
        return movimientoRepository.save(movimiento);
    }

    public Movimiento updateMovimiento(Long id, Movimiento movimientoDetails) {
        Movimiento movimiento = getMovimientoById(id);
        validateMovimiento(movimientoDetails);

        movimiento.setFecha(movimientoDetails.getFecha());
        movimiento.setTipoMovimiento(movimientoDetails.getTipoMovimiento());
        movimiento.setValor(movimientoDetails.getValor());
        movimiento.setSaldo(movimientoDetails.getSaldo());

        return movimientoRepository.save(movimiento);
    }

    public void deleteMovimiento(Long id) {
        Movimiento movimiento = getMovimientoById(id);
        movimientoRepository.delete(movimiento);
    }

    private void validateMovimiento(Movimiento movimiento) {
        if (movimiento.getSaldo() < 0) {
            throw new ValidationException("El saldo no puede ser negativo");
        }
    }
}
