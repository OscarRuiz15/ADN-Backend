package adn.oscar.reservascanchas.aplicacion.comando;

public class ComandoCliente {

    private final String nombre;
    private final String email;
    private final String telefono;
    private final String cedula;

    public ComandoCliente(String nombre, String email, String telefono, String cedula) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCedula() {
        return cedula;
    }
}
