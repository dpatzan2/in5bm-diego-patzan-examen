package com.diegopatzan.models.domain;

import java.io.Serializable;

/**
 * @author Gabriel Enrique Hurtarte Garcia Codigo técnico:IN5BM
 * @date 1/09/2021
 * @time 10:17:36 PM
 */
public class CarreraTecnica implements Serializable {

    private static final long serialVersionUID = 1L;
    private String codigo_carrera;
    private String nombre;

    public CarreraTecnica(String codigo_carrera, String nombre) {
        this.codigo_carrera = codigo_carrera;
        this.nombre = nombre;
    }

    public CarreraTecnica() {
    }

    public CarreraTecnica(String codigo_carrera) {
        this.codigo_carrera = codigo_carrera;
    }

    public String getCodigo_carrera() {
        return codigo_carrera;
    }

    public void setCodigo_carrera(String codigo_carrera) {
        this.codigo_carrera = codigo_carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "CarreraTecnica{" + "codigo_carrera=" + codigo_carrera + ", nombre=" + nombre + '}';
    }
}
