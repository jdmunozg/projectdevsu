package pruebadevsu.projectdevsu.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pruebadevsu.projectdevsu.api.model.Cuenta;
import pruebadevsu.projectdevsu.api.service.CuentaService;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public List<Cuenta> getAllCuentas() {
        return cuentaService.getAllCuentas();
    }

    @PostMapping
    public Cuenta createCuenta(@RequestBody Cuenta cuenta) {
        return cuentaService.saveCuenta(cuenta);
    }

    @PutMapping("/{id}")
    public Cuenta updateCuenta(@PathVariable Long id, @RequestBody Cuenta cuentaDetails) {
        return cuentaService.updateCuenta(id, cuentaDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable Long id) {
        cuentaService.deleteCuenta(id);
        return ResponseEntity.noContent().build();
    }
}

