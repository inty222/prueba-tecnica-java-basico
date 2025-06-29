package org.example.controllers;
import org.example.entities.Cliente;
import org.example.persistence.ClienteJPA;
import java.util.List;

public class ClienteControllers {
    ClienteJPA clienteJPA = new ClienteJPA();

    public void agregar(Cliente cliente) {
        clienteJPA.agregar(cliente);
    }

    public List<Cliente> listarTodos() {
        return clienteJPA.listarTodos();

    }
    public void actualizar(long id, Cliente nuevoCliente) {
        clienteJPA.actualizar(id, nuevoCliente);
    }
    public void eliminar(long id){
        clienteJPA.eliminar(id);
    }
    public List<Cliente> buscarCiudad(String ciudad) {
        ClienteJPA clienteJPA = new ClienteJPA();
        return clienteJPA.buscarCiudad(ciudad);
    }


}




