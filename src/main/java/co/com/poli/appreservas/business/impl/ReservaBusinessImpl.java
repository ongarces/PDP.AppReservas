package co.com.poli.appreservas.business.impl;

import co.com.poli.appreservas.business.IReservaBusiness;
import co.com.poli.appreservas.dao.imp.ReservaDaoImpl;
import co.com.poli.appreservas.model.Reserva;
import java.util.List;

/**
 *
 * @author cgaop
 */
public class ReservaBusinessImpl implements IReservaBusiness{

    private ReservaDaoImpl rDaoImpl = new ReservaDaoImpl();
    
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
    
}
