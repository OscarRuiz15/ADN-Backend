package adn.oscar.reservascanchas.aplicacion.comando;

import lombok.Getter;

@Getter
public class ComandoCliente {

    private final String nombre;
    private final String correo;
    private final String telefono;
    private final String cedula;

    public ComandoCliente(String cedula, String telefono, String correo, String nombre) {
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.nombre = nombre;
    }
}
