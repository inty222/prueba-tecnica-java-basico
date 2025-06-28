package org.example.controllers;
//crear las funciones controladoras que reciben y verifican los datos

import org.example.entities.Cliente;
import org.example.persistence.ClienteJPA;

import java.util.List;

//funcion agregar cliente:
            //instanciar un cliente
            //pedir cada uno de los datos
            //llamar a la funcion que lo va a insertar en la base de datos
            //
public class ClienteControllers {
    ClienteJPA clienteJPA = new ClienteJPA();

    public void agregar(Cliente cliente) {
        clienteJPA.agregar(cliente);
    }

    public List<Cliente> listarTodos() {
        return clienteJPA.listarTodos();

    }
    public void actualizar(Cliente cliente) {
        clienteJPA.actualizar();
    }
}




