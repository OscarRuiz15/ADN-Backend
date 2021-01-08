package adn.oscar.reservascanchas.dominio.excepcion;

public class CanchaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CanchaException(String message) {
        super(message);
    }

}
