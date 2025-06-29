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

    public void actualizar(long id, Cliente nuevoCliente) {
        EntityManager em = ConfigJPA.getEntityManager();
        Cliente cliente = em.find(Cliente.class, id);

        if (cliente != null) {
            em.getTransaction().begin();

            cliente.setNombre(nuevoCliente.getNombre());
            cliente.setPrimerApellido(nuevoCliente.getPrimerApellido());
            cliente.setSegundoApellido(nuevoCliente.getSegundoApellido());
            cliente.setSexo(nuevoCliente.getSexo());
            cliente.setFechaDeNacimiento(nuevoCliente.getFechaDeNacimiento());
            cliente.setCiudad(nuevoCliente.getCiudad());
            cliente.setTelefono(nuevoCliente.getTelefono());
            cliente.setEmail(nuevoCliente.getEmail());

            em.merge(cliente);
            em.getTransaction().commit();

            System.out.println("Cliente actualizado con exito.");
        } else {
            System.out.println("Cliente no encontrado con ID: " + id);
        }

        em.close();
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

    public List<Cliente> buscarCiudad(String ciudad) {
        EntityManager em = ConfigJPA.getEntityManager();
        List<Cliente> lista = em.createQuery("FROM Cliente c WHERE c.ciudad = :ciudad", Cliente.class)
                .setParameter("ciudad", ciudad)
                .getResultList();
        em.close();
        return lista;
    }




}







