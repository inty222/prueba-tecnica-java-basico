package org.example.persistence;

import jakarta.persistence.EntityManager;
import org.example.entities.Cliente;

import java.util.List;

public class ClienteJPA {

    public void agregar(Cliente cliente) {
        EntityManager em = ConfigJPA.getEntityManager();
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public List<Cliente> listarTodos() {
        EntityManager em = ConfigJPA.getEntityManager();
        List<Cliente> lista = em.createQuery("FROM Cliente", Cliente.class).getResultList();
        em.close();
        return lista;
    }

    public void actualizar(long id, Cliente nuevosDatos) {
        EntityManager em = ConfigJPA.getEntityManager();
        Cliente clienteExistente = em.find(Cliente.class, id);

        if (clienteExistente != null) {
            em.getTransaction().begin();

            clienteExistente.setNombre(nuevosDatos.getNombre());
            clienteExistente.setPrimerApellido(nuevosDatos.getPrimerApellido());
            clienteExistente.setSegundoApellido(nuevosDatos.getSegundoApellido());
            clienteExistente.setSexo(nuevosDatos.getSexo());
            clienteExistente.setFechaDeNacimiento(nuevosDatos.getFechaDeNacimiento());
            clienteExistente.setCiudad(nuevosDatos.getCiudad());
            clienteExistente.setTelefono(nuevosDatos.getTelefono());
            clienteExistente.setEmail(nuevosDatos.getEmail());

            em.merge(clienteExistente);
            em.getTransaction().commit();

            System.out.println("Cliente actualizado con éxito.");
        } else {
            System.out.println("Cliente no encontrado con ID: " + id);
        }

        em.close();
    }

    public Cliente buscarPorId(long id) {
        EntityManager em = ConfigJPA.getEntityManager();
        Cliente cliente = em.find(Cliente.class, id);
        em.close();
        return cliente;
    }

    public void eliminar(long id) {
        EntityManager em = ConfigJPA.getEntityManager();
        Cliente cliente = em.find(Cliente.class, id);
        if (cliente != null) {
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();
            System.out.println("Cliente eliminado.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
        em.close();
    }

    public List<Cliente> buscarPorCiudad(String ciudad) {
        EntityManager em = ConfigJPA.getEntityManager();
        List<Cliente> lista = em.createQuery("FROM Cliente c WHERE c.ciudad = :ciudad", Cliente.class)
                .setParameter("ciudad", ciudad)
                .getResultList();
        em.close();
        return lista;
    }
}


//los metodos que tocan la base de datos

    //funcion que inserta en cliente en base de datos
    //agregar cliente

    // tiene que recibir un objeto cliente
    // tiene que crear un entity manager usando ConfigJPA.getEntityManager
    // hacer el begin
    // hacer la accion correspondente
    // hacer el commit
    //close







