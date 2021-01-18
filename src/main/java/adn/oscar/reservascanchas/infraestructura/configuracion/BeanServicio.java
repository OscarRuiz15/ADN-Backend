package adn.oscar.reservascanchas.infraestructura.configuracion;

import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCancha;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioCliente;
import adn.oscar.reservascanchas.dominio.repositorio.RepositorioReserva;
import adn.oscar.reservascanchas.dominio.servicio.cancha.ServicioActualizarCancha;
import adn.oscar.reservascanchas.dominio.servicio.cancha.ServicioCrearCancha;
import adn.oscar.reservascanchas.dominio.servicio.cancha.ServicioListarCanchas;
import adn.oscar.reservascanchas.dominio.servicio.cancha.ServicioObtenerCancha;
import adn.oscar.reservascanchas.dominio.servicio.cliente.ServicioActualizarCliente;
import adn.oscar.reservascanchas.dominio.servicio.cliente.ServicioCrearCliente;
import adn.oscar.reservascanchas.dominio.servicio.cliente.ServicioListarClientes;
import adn.oscar.reservascanchas.dominio.servicio.cliente.ServicioObtenerCliente;
import adn.oscar.reservascanchas.dominio.servicio.reserva.ServicioCrearReserva;
import adn.oscar.reservascanchas.dominio.servicio.reserva.ServicioEliminarReserva;
import adn.oscar.reservascanchas.dominio.servicio.reserva.ServicioListarReservas;
import adn.oscar.reservascanchas.dominio.servicio.reserva.ServicioObtenerReserva;
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

    @Bean
    public ServicioCrearReserva servicioCrearReserva(RepositorioReserva repositorioReserva) {
        return new ServicioCrearReserva(repositorioReserva);
    }

    @Bean
    public ServicioObtenerReserva servicioObtenerReserva(RepositorioReserva repositorioReserva) {
        return new ServicioObtenerReserva(repositorioReserva);
    }

    @Bean
    public ServicioListarCanchas servicioListarCanchas(RepositorioCancha repositorioCancha) {
        return new ServicioListarCanchas(repositorioCancha);
    }

    @Bean
    public ServicioListarClientes servicioListarClientes(RepositorioCliente repositorioCliente) {
        return new ServicioListarClientes(repositorioCliente);
    }

    @Bean
    public ServicioListarReservas servicioListarReservas(RepositorioReserva repositorioReserva) {
        return new ServicioListarReservas(repositorioReserva);
    }

    @Bean
    public ServicioEliminarReserva servicioEliminarCancha(RepositorioReserva repositorioReserva) {
        return new ServicioEliminarReserva(repositorioReserva);
    }

    @Bean
    public ServicioActualizarCliente servicioActualizarCliente(RepositorioCliente repositorioCliente) {
        return new ServicioActualizarCliente(repositorioCliente);
    }

    @Bean
    public ServicioActualizarCancha servicioActualizarCancha(RepositorioCancha repositorioCancha) {
        return new ServicioActualizarCancha(repositorioCancha);
    }
}
