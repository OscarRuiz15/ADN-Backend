package adn.oscar.reservascanchas.infraestructura.configuracion;

import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCancha;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCliente;
import adn.oscar.reservascanchas.dominio.servicio.cancha.ServicioCrearCancha;
import adn.oscar.reservascanchas.dominio.servicio.cliente.ServicioCrearCliente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearCancha servicioCrearCancha(RepositorioCancha repositorioCancha) {
        return new ServicioCrearCancha(repositorioCancha);
    }

    @Bean
    public ServicioCrearCliente servicioCrearCliente(RepositorioCliente repositorioCliente) {
        return new ServicioCrearCliente(repositorioCliente);
    }
}
