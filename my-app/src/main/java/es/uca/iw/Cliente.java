package es.uca.iw;

import jakarta.persistence.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", nullable = false, length = 64)
    private String nombre;
    @Column(name = "apellidos", nullable = false, length = 128)
    private String apellidos;
    @Column(name = "dni", nullable = false, length = 9, unique = true)
    private String dni;
    @Column(name = "email", nullable = false, length = 64)
    private String email;
    @Column(name = "password", nullable = false, length = 64)
    private String password;

    public String getNombre() {
        return nombre;
    }

    public String setNombre(String n) {
        return nombre = n;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String setApellidos(String a) {
        return apellidos = a;
    }

    public String getDni() {
        return dni;
    }

    public String setDni(String d) {
        return dni = d;
    }

    public String getEmail() {
        return email;
    }

    public String setEmail(String e) {
        return email = e;
    }

    public String getPassword() {
        return password;
    }

    public String setPassword(String p) {
        return password = p;
    }
}