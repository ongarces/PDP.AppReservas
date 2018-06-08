package co.com.poli.appreservas.model;

import java.util.Objects;

/**
 *
 * @author cgaop
 */
public class Habitacion {
    
    private String idHabitacion;
    private String tipoHabitacion;
    private int camasHabitacion;
    private String banioPv;

    public Habitacion() {
    }

    public Habitacion(String idHabitacion, String tipoHabitacion, int camasHabitacion, String banioPv) {
        this.idHabitacion = idHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.camasHabitacion = camasHabitacion;
        this.banioPv = banioPv;
    }

    public String getBanioPv() {
        return banioPv;
    }

    public void setBanioPv(String banioPv) {
        this.banioPv = banioPv;
    }

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getCamasHabitacion() {
        return camasHabitacion;
    }

    public void setCamasHabitacion(int camasHabitacion) {
        this.camasHabitacion = camasHabitacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.idHabitacion);
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
        final Habitacion other = (Habitacion) obj;
        if (!Objects.equals(this.idHabitacion, other.idHabitacion)) {
            return false;
        }
        return true;
    }
    
    
}
