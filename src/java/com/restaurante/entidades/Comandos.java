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
@Entity(table = "comando")
public class Comandos {
    @PrimaryKey
    private int idComando;
    @NotNull
    private String comando;

    public Comandos() {
    }

    public Comandos(int idComando, String comando) {
        this.idComando = idComando;
        this.comando = comando;
    }

    public int getIdComando() {
        return idComando;
    }

    public void setIdComando(int idComando) {
        this.idComando = idComando;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }
    
}
