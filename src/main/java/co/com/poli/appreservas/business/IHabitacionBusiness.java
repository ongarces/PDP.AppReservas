package co.com.poli.appreservas.business;

import co.com.poli.appreservas.model.Habitacion;
import java.util.List;

/**
 *
 * @author cgaop
 */
public interface IHabitacionBusiness {
    List<Habitacion> obtenerListaHabitaciones();
    String crearHabitacion(Habitacion habitacion);
    Habitacion obtenerHabitacion(String id); 
    
    Boolean validarHabitacion(String idHabitacion);
}
