package co.com.poli.appreservas.dao;

import co.com.poli.appreservas.model.Habitacion;
import java.util.List;

/**
 *
 * @author cgaop
 */
public interface IHabitacionDao {
    
    List<Habitacion> obtenerListaHabitaciones();
    String crearHabitacion(Habitacion habitacion);
    Habitacion obtenerHabitacion(String id); 
}
