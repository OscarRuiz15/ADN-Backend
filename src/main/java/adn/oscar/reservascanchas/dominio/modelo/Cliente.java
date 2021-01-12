package adn.oscar.reservascanchas.dominio.modelo;

import static adn.oscar.reservascanchas.dominio.Validaciones.*;

public class Cliente {

    public static final String EL_NOMBRE_DEL_CLIENTE_NO_PUEDE_ESTAR_VACIO = "El nombre del cliente no puede estar vacio.";
    public static final String EL_NUMERO_DE_TELEFONO_NO_PUEDE_ESTAR_VACIO = "El número de teléfono no puede estar vacio.";
    public static final String EL_NUMERO_DE_TELEFONO_DEBE_SER_NUMERICO = "El número de teléfono debe ser númerico.";
    public static final String EL_NUMERO_DE_TELEFONO_NO_ES_CORRECTO = "El número de teléfono no es correcto.";
    public static final String EL_NUMERO_DE_CEDULA_NO_PUEDE_ESTAR_VACIO = "El número de cedula no puede estar vacio.";
    public static final String EL_NUMERO_DE_CEDULA_DEBE_SER_NUMERICO = "El número de cedula debe ser númerico.";
    public static final String EL_NUMERO_DE_CEDULA_NO_ES_CORRECTO = "El número de cedula no es correcto.";

    private final String nombre;
    private final String correo;
    private final String telefono;
    private final String cedula;

    public Cliente(String nombre, String correo, String telefono, String cedula) {
        validarObligatorio(nombre, EL_NOMBRE_DEL_CLIENTE_NO_PUEDE_ESTAR_VACIO);
        validarObligatorio(telefono, EL_NUMERO_DE_TELEFONO_NO_PUEDE_ESTAR_VACIO);
        validarObligatorio(telefono, EL_NUMERO_DE_TELEFONO_NO_PUEDE_ESTAR_VACIO);
        validarNumerico(telefono, EL_NUMERO_DE_TELEFONO_DEBE_SER_NUMERICO);
        validarPositivo(telefono, EL_NUMERO_DE_TELEFONO_NO_ES_CORRECTO);
        validarObligatorio(cedula, EL_NUMERO_DE_CEDULA_NO_PUEDE_ESTAR_VACIO);
        validarNumerico(cedula, EL_NUMERO_DE_CEDULA_DEBE_SER_NUMERICO);
        validarPositivo(cedula, EL_NUMERO_DE_CEDULA_NO_ES_CORRECTO);

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
