package adn.oscar.reservascanchas.dominio;

import adn.oscar.reservascanchas.dominio.excepcion.ClienteException;

public class Cliente {

    public static final String EL_NOMBRE_DEL_CLIENTE_NO_PUEDE_ESTAR_VACIO = "El nombre del cliente no puede estar vacio.";
    public static final String EL_NUMERO_DE_TELEFONO_NO_PUEDE_ESTAR_VACIO = "El número de teléfono no puede estar vacio.";
    public static final String EL_NUMERO_DE_TELEFONO_DEBE_SER_NUMERICO = "El número de teléfono debe ser númerico.";

    private final String nombre;
    private final String email;
    private final String telefono;
    private final String cedula;

    public Cliente(String nombre, String email, String telefono, String cedula) {
        validarObligatorio(nombre, EL_NOMBRE_DEL_CLIENTE_NO_PUEDE_ESTAR_VACIO);
        validarObligatorio(telefono, EL_NUMERO_DE_TELEFONO_NO_PUEDE_ESTAR_VACIO);
        validarNumerico(telefono, EL_NUMERO_DE_TELEFONO_DEBE_SER_NUMERICO);

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

    private void validarObligatorio(Object valor, String error) {
        if (valor == null || valor.toString().trim().length() <= 0)
            throw new ClienteException(error);
    }

    public void validarNumerico(String valor, String mensaje) {
        try {
            Long.parseLong(valor);
        } catch (NumberFormatException numberFormatException) {
            throw new ClienteException(mensaje);
        }
    }
}
