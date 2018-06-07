package co.com.poli.appreservas.dao.imp;

import co.com.poli.appreservas.dao.IHabitacionDao;
import co.com.poli.appreservas.data.HabitacionData;
import co.com.poli.appreservas.model.Habitacion;
import java.util.List;

/**
 *
 * @author cgaop
 */
public class HabitacionDaoImpl implements IHabitacionDao{

    @Override
    public List<Habitacion> obtenerListaHabitaciones() {
        return HabitacionData.getListaHabitaciones();
    }

    @Override
    public String crearHabitacion(Habitacion habitacion) {
        List<Habitacion> listaHabitaciones = HabitacionData.getListaHabitaciones();
        listaHabitaciones.add(habitacion);
        HabitacionData.setListaHabitaciones(listaHabitaciones);        
        return "Habitacion creada";
    }

    @Override
    public Habitacion obtenerHabitacion(String id) {
        Habitacion habitacion = null;

        List<Habitacion> listaHabitaciones = HabitacionData.getListaHabitaciones();

        for (Habitacion hab : listaHabitaciones) {
            if (hab.getIdHabitacion().equals(id)) {
                habitacion = hab;
            }
        }
        return habitacion;
    }
    
}
