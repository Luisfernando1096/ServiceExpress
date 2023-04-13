/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.entidades;

import com.restaurante.anotaciones.Entity;
import com.restaurante.anotaciones.NotNull;
import com.restaurante.anotaciones.PrimaryKey;
import java.sql.Date;

@Entity(table = "permiso")
public class Permisos {
    @NotNull
    private int idRol;
    @NotNull
    private int idComando;
    @NotNull
    private Date fechaCreacion;

    public Permisos() {
    }

    public Permisos(int idRol, int idComando, Date fechaCreacion) {
        this.idRol = idRol;
        this.idComando = idComando;
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getIdComando() {
        return idComando;
    }

    public void setIdComando(int idComando) {
        this.idComando = idComando;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
}
