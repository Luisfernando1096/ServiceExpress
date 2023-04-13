/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.entidades;

import com.restaurante.anotaciones.*;

/**
 *
 * @author fruiz
 */
@Entity(table = "usuario")
public class Usuarios {
    @PrimaryKey
    private int idUsuario;
    @NotNull
    private int idRol;
    @NotNull
    private String pinCode;

    public Usuarios() {
    }

    public Usuarios(int idUsuario, int idRol, String pinCode) {
        this.idUsuario = idUsuario;
        this.idRol = idRol;
        this.pinCode = pinCode;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
    
}
