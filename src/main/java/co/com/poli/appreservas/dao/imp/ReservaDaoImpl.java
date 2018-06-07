package co.com.poli.appreservas.dao.imp;

import co.com.poli.appreservas.dao.IReservaDao;
import co.com.poli.appreservas.data.ReservaData;
import co.com.poli.appreservas.model.Reserva;
import java.util.List;

/**
 *
 * @author cgaop
 */
public class ReservaDaoImpl implements IReservaDao {

    @Override
    public List<Reserva> obtenerListaReservas() {
        return ReservaData.getListaReservas();
    }

    @Override
    public String crearReserva(Reserva reservacion) {
        List<Reserva> listaReservas = ReservaData.getListaReservas();
        listaReservas.add(reservacion);
        ReservaData.setListaReservas(listaReservas);
        return "Reserva creada";
    }

    @Override
    public Reserva obtenerReserva(String id) {
        Reserva reserva = null;

        List<Reserva> listaReservas = ReservaData.getListaReservas();

        for (Reserva res : listaReservas) {
            if (res.getIdReserva().equals(id)) {
                reserva = res;
            }
        }
        return reserva;
    }

}
