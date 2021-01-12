package adn.oscar.reservascanchas.dominio.excepcion;

public class ValorInvalidoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ValorInvalidoException(String message) {
        super(message);
    }

}
