package com.restaurante.entidades;

import com.restaurante.anotaciones.FieldName;
import com.restaurante.anotaciones.AutoIncrement;
import com.restaurante.anotaciones.NotNull;
import com.restaurante.anotaciones.PrimaryKey;
import com.restaurante.anotaciones.Entity;

@Entity(table = "avion")
public class Avion {

    @PrimaryKey
    @AutoIncrement
    @FieldName(name = "idavion")
    private int idavion;
    @NotNull
    private int capacidad;
    @NotNull
    private String descripcion;

    public Avion() {
    }

    public Avion(int idavion, int capacidad, String descripcion) {
        this.idavion = idavion;
        this.capacidad = capacidad;
        this.descripcion = descripcion;
    }

    public int getIdavion() {
        return idavion;
    }

    public void setIdavion(int idavion) {
        this.idavion = idavion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
