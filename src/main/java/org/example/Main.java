package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.controllers.ClienteControllers;
import org.example.entities.Cliente;
import org.example.persistence.ClienteJPA;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static List<Cliente> clientes = new ArrayList<>();
    private static Scanner s = new Scanner(System.in);
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidad");
    public static void main(String[] args) {
        ClienteControllers clienteControllers = new ClienteControllers();

    int opcion = 0;
        while (true) {
            System.out.println("1. Agregar un nuevo cliente:");
            System.out.println("2. Listar todos los clientes:");
            System.out.println("3. Actualizar información de un cliente");
            System.out.println("4. Eliminar un cliente:");
            System.out.println("5. Buscar cliente por ciudad");
            System.out.println("6. Salir: ");
            System.out.print("Opcion: ");

            opcion = s.nextInt();
            s.nextLine();

            switch (opcion) {
                case 1:

                    String nombre;
                    while (true) {
                        System.out.print("Ingrese su nombre: ");
                        nombre = s.nextLine();
                        if (!nombre.isEmpty()) {
                            break;
                        }
                        System.out.println("Este campo es obligatorio. Intente de nuevo.");
                    }
                    String primerApellido;
                    while (true) {
                        System.out.print("Ingrese su Primer Apellido: ");
                        primerApellido = s.nextLine();
                        if (!primerApellido.isEmpty()) {
                            break;
                        }
                        System.out.println("Este campo es obligatorio. Intente de nuevo.");
                    }
                    String segundoApellido;
                    while (true) {
                        System.out.print("Ingrese su Segundo Apellido: ");
                        segundoApellido = s.nextLine();
                        if (!segundoApellido.isEmpty()) {
                            break;
                        }
                        System.out.println("Este campo es obligatorio. Intente de nuevo.");
                    }
                    String sexo = null;
                    while (sexo == null) {
                        System.out.println("Elige el sexo:");
                        System.out.println("1. Masculino");
                        System.out.println("2. Femenino");
                        System.out.println("3. Otro");
                        System.out.print("Opción: ");

                        String elige = s.nextLine();

                        switch (elige) {
                            case "1":
                                sexo = "Masculino";
                                break;
                            case "2":
                                sexo = "Femenino";
                                break;
                            case "3":
                                sexo = "Otro";
                                break;
                            default:
                                System.out.println("Opción inválida. Inténtalo de nuevo.");
                        }
                    }

                    LocalDate fechaDeNacimiento = null;

                    while (true) {
                        System.out.print("Ingrese su fecha de nacimiento (YYYY-MM-DD): ");
                        String fechaIngresada = s.nextLine();

                        try {
                            fechaDeNacimiento = LocalDate.parse(fechaIngresada);
                            break;
                        } catch (Exception e) {
                            System.out.println("Formato inválido. Intente de nuevo (formato correcto: YYYY-MM-DD).");
                        }
                    }

                    String ciudad;
                    while (true) {
                        System.out.print("Ingrese su ciudad: ");
                        ciudad = s.nextLine();
                        if (!ciudad.isEmpty()) {
                            break;
                        }
                        System.out.println("Este campo es obligatorio. Intente de nuevo.");
                    }
                    String telefono;
                    while (true) {
                        System.out.print("Ingrese su telefono: ");
                        telefono = s.nextLine();
                        if (!telefono.isEmpty()) {
                            break;
                        }
                        System.out.println("Este campo es obligatorio. Intente de nuevo.");
                    }
                    String email;
                    while (true) {
                        System.out.print("Ingrese su email ");
                        email = s.nextLine();
                        if (!email.isEmpty()) {
                            break;
                        }
                        System.out.println("Este campo es obligatorio. Intente de nuevo.");
                    }

                    Cliente cliente = new Cliente(nombre, primerApellido, segundoApellido, sexo, ciudad, fechaDeNacimiento, telefono, email);
                    clienteControllers.agregar(cliente);
                    System.out.println("Cliente guardado.");


                    break;
                case 2:

                    clientes = clienteControllers.listarTodos();
                    if (clientes.isEmpty()) {
                        System.out.println("No hay clientes registrados.");
                    } else {
                        System.out.println("Lista de todos los clientes registrados:");
                        for (Cliente c : clientes) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 3:

                    System.out.print("Ingrese el id del cliente que quiere modificar: ");
                    long id = s.nextLong();
                    s.nextLine();

                    ActualizarClienteJPA clienteJPA = new ActualizarClienteJPA(emf);
                    Cliente cliente = clienteJPA.buscarClientePorId(id);

                    if (cliente != null) {
                        String nuevoNombre;
                        while (true) {
                            System.out.print("Ingrese su nuevo nombre: ");
                            nuevoNombre = s.nextLine();
                            if (!nuevoNombre.isEmpty()) break;
                            System.out.println("Este campo es obligatorio. Intente de nuevo.");
                        }
                        String nuevoPrimerApellido;
                        while (true) {
                            System.out.print("Ingrese su nuevo Primer Apellido: ");
                            nuevoPrimerApellido = s.nextLine();
                            if (!nuevoPrimerApellido.isEmpty()) break;
                            System.out.println("Este campo es obligatorio. Intente de nuevo.");
                        }
                        String nuevoSegundoApellido;
                        while (true) {
                            System.out.print("Ingrese su nuevo Segundo Apellido: ");
                            nuevoSegundoApellido = s.nextLine();
                            if (!nuevoSegundoApellido.isEmpty()) break;
                            System.out.println("Este campo es obligatorio. Intente de nuevo.");
                        }
                        String nuevaCiudad;
                        while (true) {
                            System.out.print("Ingrese su nueva ciudad: ");
                            nuevaCiudad = s.nextLine();
                            if (!nuevaCiudad.isEmpty()) break;
                            System.out.println("Este campo es obligatorio. Intente de nuevo.");
                        }
                        String nuevoTelefono;
                        while (true) {
                            System.out.print("Ingrese su nuevo telefono: ");
                            nuevoTelefono = s.nextLine();
                            if (!nuevoTelefono.isEmpty()) break;
                            System.out.println("Este campo es obligatorio. Intente de nuevo.");
                        }
                        String nuevaEmail;
                        while (true) {
                            System.out.print("Ingrese su nueva email ");
                            nuevaEmail = s.nextLine();
                            if (!nuevaEmail.isEmpty()) break;
                            System.out.println("Este campo es obligatorio. Intente de nuevo.");
                        }
                        String nuevoSexo = null;
                        while (nuevoSexo == null) {
                            System.out.println("Elige el sexo:");
                            System.out.println("1. Masculino");
                            System.out.println("2. Femenino");
                            System.out.println("3. Otro");
                            System.out.print("Opción: ");

                            String elige = s.nextLine();

                            switch (elige) {
                                case "1":
                                    nuevoSexo = "Masculino";
                                    break;
                                case "2":
                                    nuevoSexo = "Femenino";
                                    break;
                                case "3":
                                    nuevoSexo = "Otro";
                                    break;
                                default:
                                    System.out.println("Opción inválida. Inténtalo de nuevo.");
                            }
                        }

                        LocalDate nuevaFechaDeNacimiento = null;
                        while (true) {
                            System.out.print("Ingrese su nueva fecha de nacimiento (YYYY-MM-DD): ");
                            String fechaIngresada = s.nextLine();

                            try {
                                nuevaFechaDeNacimiento = LocalDate.parse(fechaIngresada);
                                break;
                            } catch (Exception e) {
                                System.out.println("Formato inválido. Intente de nuevo (formato correcto: YYYY-MM-DD).");
                            }
                        }

                        // Actualizamos el objeto cliente con los nuevos valores
                        cliente.setNombre(nuevoNombre);
                        cliente.setPrimerApellido(nuevoPrimerApellido);
                        cliente.setSegundoApellido(nuevoSegundoApellido);
                        cliente.setCiudad(nuevaCiudad);
                        cliente.setEmail(nuevaEmail);
                        cliente.setTelefono(nuevoTelefono);
                        cliente.setFechaDeNacimiento(nuevaFechaDeNacimiento);
                        cliente.setSexo(nuevoSexo);

                        // Guardamos los cambios en la base de datos con JPA
                        clienteJPA.guardarCambios(cliente);

                        System.out.println("Cliente actualizado con éxito");
                    } else {
                        System.out.println("Cliente no encontrado");
                    }


                    break;

                case 4:
                    eliminarCliente();
                break;
                case 5:
                    buscarClientePorCiudad();
                break;
                case 6:
                    return;

                default:
                    System.out.println("opcion no valida");


            }
        }
    }
    private static void buscarClientePorCiudad() {
        System.out.print("Ingrese la ciudad: ");
        String ciudad = s.nextLine();

        EntityManager em = emf.createEntityManager();
        List<Cliente> clientes = em.createQuery(
                        "SELECT c FROM Cliente c WHERE c.ciudad = :ciudad", Cliente.class)
                .setParameter("ciudad", ciudad)
                .getResultList();

        if (clientes.isEmpty()) {
            System.out.println("No se encontraron clientes en la ciudad: " + ciudad);
        } else {
            for (Cliente cliente : clientes) {
                System.out.println(cliente);

            }


        }
     em.close();
    }

    private static void eliminarCliente() {
        System.out.println("ingresa el id del cliente que quiere eliminar");
        long id = s.nextLong();
        EntityManager em = emf.createEntityManager();
        Cliente cliente = em.find(Cliente.class,id);
   if(cliente!=null) {
       System.out.println("cliente eliminado con exito");

        em.getTransaction().begin();
        em.remove(cliente);

        em.getTransaction().commit();

   } else System.out.println("cliente no encontrado");
   em.close();
    }






