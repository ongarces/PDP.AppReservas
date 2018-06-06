package co.com.poli.appreservas.model;

import java.util.Objects;

/**
 *
 * @author cgaop
 */
public class Reserva {
    
    private String idReserva;
    private String idHabitacionR;
    private int camasR;
    private int precioCama;

    public Reserva() {
    }

    public Reserva(String idReserva, String idHabitacionR, int camasR, int precioCama) {
        this.idReserva = idReserva;
        this.idHabitacionR = idHabitacionR;
        this.camasR = camasR;
        this.precioCama = precioCama;
    }

    public int getPrecioCama() {
        return precioCama;
    }

    public void setPrecioCama(int precioCama) {
        this.precioCama = precioCama;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public String getIdHabitacionR() {
        return idHabitacionR;
    }

    public void setIdHabitacionR(String idHabitacionR) {
        this.idHabitacionR = idHabitacionR;
    }

    public int getCamasR() {
        return camasR;
    }

    public void setCamasR(int camasR) {
        this.camasR = camasR;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.idReserva);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reserva other = (Reserva) obj;
        if (!Objects.equals(this.idReserva, other.idReserva)) {
            return false;
        }
        return true;
    }
    
    
}
