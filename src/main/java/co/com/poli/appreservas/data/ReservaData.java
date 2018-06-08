package co.com.poli.appreservas.data;

import co.com.poli.appreservas.model.Reserva;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cgaop
 */
public class ReservaData {

    private static List<Reserva> listaReservas;

    static {
        listaReservas = new ArrayList<Reserva>() {
            {
                add(new Reserva("9010", "1010", 2, 30000));     //  comp   5     
                add(new Reserva("9011", "1040", 5, 30000));   //      comp 6      
                add(new Reserva("9012", "1030", 4, 50000)); //          pv 4    

            }
        };
    }//fin static

//                add(new Habitacion("1010", "compartida", 5, "si"));
//                add(new Habitacion("1020", "privada", 3, "no"));
//                add(new Habitacion("1030", "privada", 4, "si"));
//                add(new Habitacion("1040", "compartida", 6, "si"));
//                add(new Habitacion("1050", "compartida", 4, "no")); 

    public static List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public static void setListaReservas(List<Reserva> aListaReservas) {
        listaReservas = aListaReservas;
    }
    
    
}
