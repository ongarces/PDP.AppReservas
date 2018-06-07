package co.com.poli.appreservas.dao;

import co.com.poli.appreservas.model.Reserva;
import java.util.List;

/**
 *
 * @author cgaop
 */
public interface IReservaDao {
    List<Reserva> obtenerListaReservas();
    String crearReserva(Reserva reservacion);
    Reserva obtenerReserva(String id); 
}
