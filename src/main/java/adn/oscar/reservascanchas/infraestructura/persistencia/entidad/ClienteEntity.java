package adn.oscar.reservascanchas.infraestructura.persistencia.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Cliente")
@Getter
@Setter
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String nombre;

    private String correo = "";

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false, unique = true)
    private String cedula;
}
