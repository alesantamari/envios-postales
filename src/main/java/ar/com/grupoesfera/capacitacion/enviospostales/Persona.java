package ar.com.grupoesfera.capacitacion.enviospostales;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Persona {
    private String nombre;
    private LocalDate fechaDeNacimiento;

    public int getEdadEnanios(){
        return (int) ChronoUnit.YEARS.between(this.fechaDeNacimiento, LocalDate.now());
    }

    public Integer getEdadEnMeses(){
        return (int)ChronoUnit.MONTHS.between(this.fechaDeNacimiento, LocalDate.now());
    }

    public Integer getEdadEnDias(){
        return (int)ChronoUnit.DAYS.between(this.fechaDeNacimiento, LocalDate.now());
    }

    public Integer getEdadEnHoras(){
        return this.getEdadEnDias()*24;
    }

    public Integer getEdadEnSegundos(){
        return this.getEdadEnHoras()*3600;
    }

    public Boolean esMayorQue(Persona persona2){
        return this.getEdadEnDias() > persona2.getEdadEnDias();
    }

    public Persona(String nombre, LocalDate fechaDeNacimiento) {
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
}
