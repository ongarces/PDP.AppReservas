package co.com.poli.appreservas.business.impl;

import co.com.poli.appreservas.business.IReservaBusiness;
import co.com.poli.appreservas.dao.imp.HabitacionDaoImpl;
import co.com.poli.appreservas.dao.imp.ReservaDaoImpl;
import co.com.poli.appreservas.model.Habitacion;
import co.com.poli.appreservas.model.Reserva;
import java.util.List;

/**
 *
 * @author cgaop
 */
public class ReservaBusinessImpl implements IReservaBusiness {

    private ReservaDaoImpl rDaoImpl = new ReservaDaoImpl();
    private HabitacionDaoImpl hDaoImpl = new HabitacionDaoImpl();

    @Override
    public List<Reserva> obtenerListaReservas() {
        return rDaoImpl.obtenerListaReservas();
    }

    @Override
    public String crearReserva(Reserva reservacion) {
        return rDaoImpl.crearReserva(reservacion);
    }

    @Override
    public Reserva obtenerReserva(String id) {
        return rDaoImpl.obtenerReserva(id);
    }

    @Override
    public Boolean validarDisponibilidad(String idHabitacion) {
        Boolean sw = false;
        return sw;
    }

    @Override
    public Boolean validarReserva(String idReserva) {
        Boolean sw = false;//no existe
        List<Reserva> listaReservas = rDaoImpl.obtenerListaReservas();
        for (Reserva res : listaReservas) {
            if (res.getIdReserva().equals(idReserva)) {//si existe
                sw = true;//existe  
            }
        }
        return sw;
    }

    @Override
    public Boolean validarReservaPrivada(String idHabitacionR) {
        Boolean sw = false;
        List<Reserva> listaReservas = rDaoImpl.obtenerListaReservas();
        for (Reserva res : listaReservas) {
            if (res.getIdHabitacionR().equals(idHabitacionR)) {//si existe
                sw = true;//existe  
            }
        }
        return sw;
    }

    @Override
    public int buscarOcupadas(String idHabitacionR) {
        int ocupadas = 0;
        List<Reserva> listaReservas = rDaoImpl.obtenerListaReservas();
        for (Reserva res : listaReservas) {
            if (res.getIdHabitacionR().equals(idHabitacionR)) {//si existe
                ocupadas += res.getCamasR();//acumula ocupadas
            }
        }
        return ocupadas;
    }

    @Override
    public String valorPrivadasOcupadas() {

        int cantidadPrivadas=0, camas=0, valortotal=0;
        List<Reserva> listaReservas = rDaoImpl.obtenerListaReservas();
        List<Habitacion> listaHabitaciones = hDaoImpl.obtenerListaHabitaciones();
        
        for (Habitacion hab : listaHabitaciones) {            
            for (Reserva res : listaReservas) {                
                if (res.getIdHabitacionR().equals(hab.getIdHabitacion()) 
                        && hab.getTipoHabitacion().equalsIgnoreCase("privada")) {//si existe reserva de habitacion privada
                    cantidadPrivadas++; 
                }                
            }            
        }
        
        camas = cantidadPrivadas*4;
        valortotal=camas*50000;
        
        return "La cantidad de habitaciones privadas reservadas es: " + cantidadPrivadas 
                + " en total serian: " + camas + " camas, dando asi un costo total de: $" + valortotal;

    }

    @Override
    public String calcularCostosa() {
       
        int costoMayor=0, costoActual=0;
        String numeroHabitacion ="xxxx";
        
        List<Reserva> listaReservas = rDaoImpl.obtenerListaReservas();
        List<Habitacion> listaHabitaciones = hDaoImpl.obtenerListaHabitaciones();
        for (Reserva res : listaReservas) {
            costoActual = res.getCamasR()*res.getPrecioCama();
            if (costoActual>costoMayor) {
                costoMayor=costoActual;
                numeroHabitacion=res.getIdHabitacionR();
            }
        }        
        return "La habitacion reservada mas costosa es: " + numeroHabitacion + " con un valor de: $" + costoMayor;
    }

}
