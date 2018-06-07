package co.com.poli.appreservas.business.impl;

import co.com.poli.appreservas.business.IHabitacionBusiness;
import co.com.poli.appreservas.dao.imp.HabitacionDaoImpl;
import co.com.poli.appreservas.model.Habitacion;
import java.util.List;

/**
 *
 * @author cgaop
 */
public class HabitacionBusinessImpl implements IHabitacionBusiness{

    private HabitacionDaoImpl hDaoImpl = new HabitacionDaoImpl();
    
    @Override
    public List<Habitacion> obtenerListaHabitaciones() {
      return hDaoImpl.obtenerListaHabitaciones();
    }

    @Override
    public String crearHabitacion(Habitacion habitacion) {        
        return hDaoImpl.crearHabitacion(habitacion);
    }

    @Override
    public Habitacion obtenerHabitacion(String id) {
       return hDaoImpl.obtenerHabitacion(id);
    }

    @Override
    public Boolean validarHabitacion(String idHabitacion) {
        Boolean sw = false;
        List<Habitacion> listaHabitaciones = hDaoImpl.obtenerListaHabitaciones();
        for (Habitacion hab : listaHabitaciones) {
            if (hab.getIdHabitacion().equals(idHabitacion)) {//si existe
              sw = true;  
            }
        }
        return sw;  //false=crear   true=existe      
    }
    
}
