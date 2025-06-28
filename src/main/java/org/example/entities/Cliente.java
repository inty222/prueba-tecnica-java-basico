package org.example.entities;
import java.time.LocalDate;
import jakarta.persistence.*;


@Table(name = "Clientes")
@Entity
public class Cliente {
    enum sexo{M,F,O}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)

    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String sexo;
    private String ciudad;
    private LocalDate fechaDeNacimiento;
    private String telefono;
    private String email;

    public Cliente() {
    }

    public Cliente(String nombre, String primerApellido, String segundoApellido, String sexo, String ciudad, LocalDate fechaDeNacimiento, String telefono, String email) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.sexo = sexo;
        this.ciudad = ciudad;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.telefono = telefono;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getSexo() {
        return sexo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", sexo=" + sexo +
                ", ciudad='" + ciudad + '\'' +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}