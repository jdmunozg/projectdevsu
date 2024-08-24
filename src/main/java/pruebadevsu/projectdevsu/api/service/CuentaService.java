package pruebadevsu.projectdevsu.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pruebadevsu.projectdevsu.api.model.Cuenta;
import pruebadevsu.projectdevsu.api.repository.CuentaRepository;

import java.util.List;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Cuenta> getAllCuentas() {
        return cuentaRepository.findAll();
    }

    public Cuenta saveCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public Cuenta updateCuenta(Long id, Cuenta cuentaDetails) {
        Cuenta cuenta = cuentaRepository.findById(id).orElseThrow();
        cuenta.setNumeroCuenta(cuentaDetails.getNumeroCuenta());
        cuenta.setSaldoInicial(cuentaDetails.getSaldoInicial());
        // Actualizar otros campos
        return cuentaRepository.save(cuenta);
    }

    public void deleteCuenta(Long id) {
        cuentaRepository.deleteById(id);
    }
}
