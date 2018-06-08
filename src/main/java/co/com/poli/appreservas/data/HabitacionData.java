package co.com.poli.appreservas.data;

import co.com.poli.appreservas.model.Habitacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cgaop
 */
public class HabitacionData {
    
    private static List<Habitacion> listaHabitaciones;
    
    static{
        listaHabitaciones = new ArrayList<Habitacion>(){
            {
                add(new Habitacion("1010", "compartida", 5, "si"));
                add(new Habitacion("1020", "privada", 4, "no"));
                add(new Habitacion("1030", "privada", 4, "si"));
                add(new Habitacion("1040", "compartida", 6, "si"));
                add(new Habitacion("1050", "compartida", 4, "no"));                
                
            }            
        };
    }//fin static

    public static List<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public static void setListaHabitaciones(List<Habitacion> aListaHabitaciones) {
        listaHabitaciones = aListaHabitaciones;
    }
    
    
}
