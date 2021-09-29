/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegopatzan.models.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Diego Fernando Patzán Marroquín
 * @date 30/08/2021
 * @time 02:20:17 PM
 */
public class AsignacionAlumno implements Serializable {

    private static final long serialVersionUID = 1L;
    private String idAsignacion;
    private String carne;
    private int idCurso;
    private Timestamp fecha_asignacion;
    private String nombres;
    private String apellidos;
    private String descripcion;

    public AsignacionAlumno(String idAsignacion, String carne, int idCurso, Timestamp fecha_asignacion, String nombres, String apellidos, String descripcion) {
        this.idAsignacion = idAsignacion;
        this.carne = carne;
        this.idCurso = idCurso;
        this.fecha_asignacion = fecha_asignacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.descripcion = descripcion;
    }

    public AsignacionAlumno() {
    }

    public AsignacionAlumno(String idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public AsignacionAlumno(String carne, int idCurso, Timestamp fecha_asignacion) {
        this.carne = carne;
        this.idCurso = idCurso;
        this.fecha_asignacion = fecha_asignacion;
    }

    public AsignacionAlumno(String idAsignacion, String carne, int idCurso, Timestamp fecha_asignacion) {
        this.idAsignacion = idAsignacion;
        this.carne = carne;
        this.idCurso = idCurso;
        this.fecha_asignacion = fecha_asignacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(String idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public Timestamp getFecha_asignacion() {
        return fecha_asignacion;
    }

    public void setFecha_asignacion(Timestamp fecha_asignacion) {
        this.fecha_asignacion = fecha_asignacion;
    }

    @Override
    public String toString() {
        return "AsignacionAlumno{" + "idAsignacion=" + idAsignacion + ", carne=" + carne + ", idCurso=" + idCurso + ", fecha_asignacion=" + fecha_asignacion + '}';
    }

}
