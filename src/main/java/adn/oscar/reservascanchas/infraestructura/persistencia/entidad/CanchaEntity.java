package adn.oscar.reservascanchas.infraestructura.persistencia.entidad;

import adn.oscar.reservascanchas.dominio.modelo.TipoCancha;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Cancha")
@Getter
@Setter
public class CanchaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String telefono;

    @Enumerated(EnumType.STRING)
    private TipoCancha tipoCancha;

    @Column(nullable = false)
    private double precioReserva;
}
