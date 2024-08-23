package pruebadevsu.projectdevsu.api.service;

import pruebadevsu.projectdevsu.api.model.Cliente;
import pruebadevsu.projectdevsu.api.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Obtener todos los clientes
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    // Obtener un cliente por ID
    public Cliente getClienteById(Long clienteId) {
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
        return cliente.orElse(null);  // Retorna null si no se encuentra el cliente
    }

    // Crear un nuevo cliente
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Actualizar un cliente existente
    public Cliente updateCliente(Long clienteId, Cliente clienteDetails) {
        Cliente cliente = getClienteById(clienteId);
        if (cliente != null) {
            cliente.setNombre(clienteDetails.getNombre());
            cliente.setGenero(clienteDetails.getGenero());
            cliente.setEdad(clienteDetails.getEdad());
            cliente.setIdentificacion(clienteDetails.getIdentificacion());
            cliente.setDireccion(clienteDetails.getDireccion());
            cliente.setTelefono(clienteDetails.getTelefono());
            cliente.setClave(clienteDetails.getClave());
            cliente.setEstado(clienteDetails.getEstado());
            return clienteRepository.save(cliente);
        }
        return null;  // Retorna null si no se encuentra el cliente
    }

    // Eliminar un cliente
    public void deleteCliente(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}