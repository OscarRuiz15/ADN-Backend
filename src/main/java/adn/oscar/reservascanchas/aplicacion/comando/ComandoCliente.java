package adn.oscar.reservascanchas.aplicacion.comando;

public class ComandoCliente {

    private final String nombre;
    private final String correo;
    private final String telefono;
    private final String cedula;

    public ComandoCliente(String nombre, String correo, String telefono, String cedula) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCedula() {
        return cedula;
    }
}
