package pruebadevsu.projectdevsu.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pruebadevsu.projectdevsu.api.model.Movimiento;
import pruebadevsu.projectdevsu.api.service.MovimientoService;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public List<Movimiento> getAllMovimientos() {
        return movimientoService.getAllMovimientos();
    }

    @PostMapping
    public Movimiento createMovimiento(@RequestBody Movimiento movimiento) {
        return movimientoService.saveMovimiento(movimiento);
    }

    @PutMapping("/{id}")
    public Movimiento updateMovimiento(@PathVariable Long id, @RequestBody Movimiento movimientoDetails) {
        return movimientoService.updateMovimiento(id, movimientoDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimiento(@PathVariable Long id) {
        movimientoService.deleteMovimiento(id);
        return ResponseEntity.noContent().build();
    }
}

