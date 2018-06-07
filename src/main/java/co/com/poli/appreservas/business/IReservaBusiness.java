package co.com.poli.appreservas.business;

import co.com.poli.appreservas.model.Reserva;
import java.util.List;

/**
 *
 * @author cgaop
 */
public interface IReservaBusiness {
    List<Reserva> obtenerListaReservas();
    String crearReserva(Reserva reservacion);
    Reserva obtenerReserva(String id);
    
    
}
