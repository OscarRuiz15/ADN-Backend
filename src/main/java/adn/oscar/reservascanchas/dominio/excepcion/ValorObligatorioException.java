package adn.oscar.reservascanchas.dominio.excepcion;

public class ValorObligatorioException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ValorObligatorioException(String message) {
        super(message);
    }

}
