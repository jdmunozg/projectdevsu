package pruebadevsu.projectdevsu.api.service;

import pruebadevsu.projectdevsu.api.model.Cliente;
import pruebadevsu.projectdevsu.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Long id, Cliente clienteDetails) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        cliente.setNombre(clienteDetails.getNombre());
        cliente.setContrasena(clienteDetails.getContrasena());
        // Actualizar otros campos
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}