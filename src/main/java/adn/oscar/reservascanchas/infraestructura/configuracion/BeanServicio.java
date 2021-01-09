package adn.oscar.reservascanchas.infraestructura.configuracion;

import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCancha;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCliente;
import adn.oscar.reservascanchas.dominio.servicio.cancha.ServicioCrearCancha;
import adn.oscar.reservascanchas.dominio.servicio.cancha.ServicioObtenerCancha;
import adn.oscar.reservascanchas.dominio.servicio.cliente.ServicioCrearCliente;
import adn.oscar.reservascanchas.dominio.servicio.cliente.ServicioObtenerCliente;
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

    @Bean
    public ServicioObtenerCancha servicioObtenerCancha(RepositorioCancha repositorioCancha) {
        return new ServicioObtenerCancha(repositorioCancha);
    }

    @Bean
    public ServicioObtenerCliente servicioObtenerCliente(RepositorioCliente repositorioCancha) {
        return new ServicioObtenerCliente(repositorioCancha);
    }
}
