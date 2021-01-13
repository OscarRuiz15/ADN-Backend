package adn.oscar.reservascanchas.dominio.excepcion;

public class FormatoFechaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FormatoFechaException(String message) {
        super(message);
    }
}
