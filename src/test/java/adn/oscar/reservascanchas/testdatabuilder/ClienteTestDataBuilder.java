package adn.oscar.reservascanchas.testdatabuilder;

import adn.oscar.reservascanchas.aplicacion.comando.ComandoCliente;
import adn.oscar.reservascanchas.dominio.modelos.Cliente;

public class ClienteTestDataBuilder {

    private static final String NOMBRE_CLIENTE = "Oscar Alexander Ruiz Palacio";
    private static final String EMAIL_CLIENTE = "oarp1996@gmail.com";
    private static final String TELEFONO_CLIENTE = "3158895616";
    private static final String CEDULA_CLIENTE = "3158895616";

    private String nombre;
    private String email;
    private String telefono;
    private String cedula;

    public ClienteTestDataBuilder() {
        this.nombre = NOMBRE_CLIENTE;
        this.email = EMAIL_CLIENTE;
        this.telefono = TELEFONO_CLIENTE;
        this.cedula = CEDULA_CLIENTE;
    }

    public ClienteTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ClienteTestDataBuilder conEmail(String email) {
        this.email = email;
        return this;
    }

    public ClienteTestDataBuilder conTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public ClienteTestDataBuilder conCedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public Cliente build() {
        return new Cliente(nombre, email, telefono, cedula);
    }

    public ComandoCliente buildComando() {
        return new ComandoCliente(nombre, email, telefono, cedula);
    }
}
