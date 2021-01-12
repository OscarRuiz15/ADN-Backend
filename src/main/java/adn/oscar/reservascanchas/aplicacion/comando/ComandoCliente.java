package adn.oscar.reservascanchas.aplicacion.comando;

public class ComandoCliente {

    private final String cedula;
    private final String telefono;
    private final String correo;
    private final String nombre;

    public ComandoCliente(String cedula, String telefono, String correo, String nombre) {
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }
}
