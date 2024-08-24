package pruebadevsu.projectdevsu.api.service;

import pruebadevsu.projectdevsu.api.exception.ResourceNotFoundException;
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

    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + id));
    }

    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Long id, Cliente clienteDetails) {
        Cliente cliente = getClienteById(id);

        if(clienteDetails.getNombre() != null) {
            cliente.setNombre(clienteDetails.getNombre());
        }
        if(clienteDetails.getGenero() != null) {
            cliente.setGenero(clienteDetails.getGenero());
        }
        if(clienteDetails.getEdad() != null) {
            cliente.setEdad(clienteDetails.getEdad());
        }
        if(clienteDetails.getContrasena() != null) {
            cliente.setContrasena(clienteDetails.getContrasena());
        }
        if(clienteDetails.getEstado() != null) {
            cliente.setEstado(clienteDetails.getEstado());
        }
        if(clienteDetails.getDireccion() != null) {
            cliente.setDireccion(clienteDetails.getDireccion());
        }
        if(clienteDetails.getTelefono() != null) {
            cliente.setTelefono(clienteDetails.getTelefono());
        }

        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Long id) {
        Cliente cliente = getClienteById(id);
        clienteRepository.delete(cliente);
    }
}