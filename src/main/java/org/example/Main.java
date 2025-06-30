package org.example;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.controllers.ClienteControllers;
import org.example.entities.Cliente;
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
            System.out.println("3. Actualizar informacion de un cliente");
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
                        System.out.print("Ingresa tu nombre: ");
                        nombre = s.nextLine();
                        if (!nombre.isEmpty()) {
                            break;
                        }
                        System.out.println("Este campo es obligatorio. intenta de nuevo");
                    }
                    String primerApellido;
                    while (true) {
                        System.out.print("Ingresa tu Primer Apellido: ");
                        primerApellido = s.nextLine();
                        if (!primerApellido.isEmpty()) {
                            break;
                        }
                        System.out.println("Este campo es obligatorio. intenta de nuevo");
                    }
                    String segundoApellido;
                    while (true) {
                        System.out.print("Ingresa tu Segundo Apellido: ");
                        segundoApellido = s.nextLine();
                        if (!segundoApellido.isEmpty()) {
                            break;
                        }
                        System.out.println("Este campo es obligatorio. intenta de nuevo");
                    }
                    String sexo = null;
                    while (sexo == null) {
                        System.out.println("Elige el sexo:");
                        System.out.println("1. Masculino");
                        System.out.println("2. Femenino");
                        System.out.println("3. Otro");
                        System.out.print("Opcion: ");

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
                                System.out.println("Opcion invalida. Intenta de nuevo.");
                        }
                    }

                    LocalDate fechaDeNacimiento = null;

                    while (true) {
                        System.out.print("Ingresa tu fecha de nacimiento (YYYY-MM-DD): ");
                        String fechaIngresada = s.nextLine();

                        try {
                            fechaDeNacimiento = LocalDate.parse(fechaIngresada);
                            break;
                        } catch (Exception e) {
                            System.out.println("Formato invalido. Intenta de nuevo (formato correcto: YYYY-MM-DD).");
                        }
                    }

                    String ciudad;
                    while (true) {
                        System.out.print("Ingresa tu ciudad: ");
                        ciudad = s.nextLine();
                        if (!ciudad.isEmpty()) {
                            break;
                        }
                        System.out.println("Este campo es obligatorio. intenta de nuevo");
                    }
                    String telefono;
                    while (true) {
                        System.out.print("Ingresa tu telefono: ");
                        telefono = s.nextLine();
                        if (!telefono.isEmpty()) {
                            break;
                        }
                        System.out.println("Este campo es obligatorio. intenta de nuevo");
                    }
                    String email;
                    while (true) {
                        System.out.print("Ingresa tu email ");
                        email = s.nextLine();
                        if (!email.isEmpty()) {
                            break;
                        }
                        System.out.println("Este campo es obligatorio. intenta de nuevo");
                    }

                    Cliente cliente1 = new Cliente(nombre, primerApellido, segundoApellido, sexo, ciudad, fechaDeNacimiento, telefono, email);
                    clienteControllers.agregar(cliente1);
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
                    System.out.print("Ingresa el id del cliente que quieres modificar: ");
                    long id = s.nextLong();
                    s.nextLine();

                    String nuevoNombre;
                    while (true) {
                        System.out.print("Ingresa tu nuevo nombre: ");
                        nuevoNombre = s.nextLine();
                        if (!nuevoNombre.isEmpty()) break;
                        System.out.println("Este campo es obligatorio. Intenta de nuevo.");
                    }

                    String nuevoPrimerApellido;
                    while (true) {
                        System.out.print("Ingresa tu nuevo Primer Apellido: ");
                        nuevoPrimerApellido = s.nextLine();
                        if (!nuevoPrimerApellido.isEmpty()) break;
                        System.out.println("Este campo es obligatorio. Intenta de nuevo.");
                    }

                    String nuevoSegundoApellido;
                    while (true) {
                        System.out.print("Ingresa tu nuevo Segundo Apellido: ");
                        nuevoSegundoApellido = s.nextLine();
                        if (!nuevoSegundoApellido.isEmpty()) break;
                        System.out.println("Este campo es obligatorio. Intenta de nuevo.");
                    }

                    String nuevaCiudad;
                    while (true) {
                        System.out.print("Ingresa tu nueva ciudad: ");
                        nuevaCiudad = s.nextLine();
                        if (!nuevaCiudad.isEmpty()) break;
                        System.out.println("Este campo es obligatorio. intenta de nuevo");
                    }

                    String nuevoTelefono;
                    while (true) {
                        System.out.print("Ingresa tu nuevo telefono: ");
                        nuevoTelefono = s.nextLine();
                        if (!nuevoTelefono.isEmpty()) break;
                        System.out.println("Este campo es obligatorio. intenta de nuevo");
                    }

                    String nuevaEmail;
                    while (true) {
                        System.out.print("Ingresa tu nuevo email: ");
                        nuevaEmail = s.nextLine();
                        if (!nuevaEmail.isEmpty()) break;
                        System.out.println("Este campo es obligatorio. intenta de nuevo");
                    }

                    String nuevoSexo = null;
                    while (nuevoSexo == null) {
                        System.out.println("Elige el sexo:");
                        System.out.println("1. Masculino");
                        System.out.println("2. Femenino");
                        System.out.println("3. Otro");
                        System.out.print("Opcion: ");
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
                                System.out.println("Opcion invalida. Intenta de nuevo.");
                        }
                    }

                    LocalDate nuevaFechaDeNacimiento;
                    while (true) {
                        System.out.print("Ingresa tu nueva fecha de nacimiento (YYYY-MM-DD): ");
                        String fechaIngresada = s.nextLine();
                        try {
                            nuevaFechaDeNacimiento = LocalDate.parse(fechaIngresada);
                            break;
                        } catch (Exception e) {
                            System.out.println("Formato invalido. Intenta de nuevo.");
                        }
                    }


                    Cliente nuevoCliente = new Cliente(
                            nuevoNombre,
                            nuevoPrimerApellido,
                            nuevoSegundoApellido,
                            nuevoSexo,
                            nuevaCiudad,
                            nuevaFechaDeNacimiento,
                            nuevoTelefono,
                            nuevaEmail
                    );

                    clienteControllers.actualizar(id,nuevoCliente);

                    break;
                case 4:
                    System.out.print("Ingresa el ID del cliente que deseas eliminar: ");
                    long idEliminar = s.nextLong();
                    s.nextLine();

                    clienteControllers.eliminar(idEliminar);
                    break;


                case 5: {
                    System.out.print("Ingresa la ciudad: ");
                    String c = s.nextLine();
                    clientes = clienteControllers.buscarCiudad(c);

                    if (clientes.isEmpty()) {
                        System.out.println("cliente no encontrado en la ciudad: " + c);
                    } else {
                        for (Cliente cliente : clientes) {
                            System.out.println(cliente);
                        }
                    }
                }
                        break;

                case 6:
                    return;

                default:
                    System.out.println("opcion no valida");


            }
        }
    }

}





