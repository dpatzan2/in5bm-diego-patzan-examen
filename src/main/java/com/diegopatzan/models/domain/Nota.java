/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegopatzan.models.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Diego Fernando
 */
@Entity
@Table(name="nota")
@NamedQueries({
    @NamedQuery(
            name = "Nota.findAll",
            query = "from Nota"
    
    )
})
public class Nota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_nota")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idNota;
    @Column(name = "nombre_actividad")
    private String nombreActividad;
    @Column(name = "nota_actividad")
    private int notaActividad;
    @Column(name = "fecha_entrega")
    private Date fechaEntrega;
    @Column(name = "asignacion_id")
    private String idAsignacion;

    /*private int carne;
    private String nombres;
    private String apellidos;
    private String descripcion;
    private Timestamp fecha_asignacion;*/

    /*public Timestamp getFecha_asignacion() {
        return fecha_asignacion;
    }

    public void setFecha_asignacion(Timestamp fecha_asignacion) {
        this.fecha_asignacion = fecha_asignacion;
    }*/

    public Nota() {
    }

    public Nota(int idNota) {
        this.idNota = idNota;
    }

    public Nota(String nombreActividad, int notaActividad, Date fechaEntrega, String idAsignacion) {
        this.nombreActividad = nombreActividad;
        this.notaActividad = notaActividad;
        this.fechaEntrega = fechaEntrega;
        this.idAsignacion = idAsignacion;
    }

    public Nota(int idNota, String nombreActividad, int notaActividad, Date fechaEntrega, String idAsignacion) {
        this.idNota = idNota;
        this.nombreActividad = nombreActividad;
        this.notaActividad = notaActividad;
        this.fechaEntrega = fechaEntrega;
        this.idAsignacion = idAsignacion;
    }

    /*public Nota(int idNota, String nombreActividad, int notaActividad, Date fechaEntrega, String idAsignacion, int carne, String nombres, String apellidos, String descripcion) {
        this.idNota = idNota;
        this.nombreActividad = nombreActividad;
        this.notaActividad = notaActividad;
        this.fechaEntrega = fechaEntrega;
        this.idAsignacion = idAsignacion;
        this.carne = carne;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.descripcion = descripcion;
    }*/
    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public int getNotaActividad() {
        return notaActividad;
    }

    public void setNotaActividad(int notaActividad) {
        this.notaActividad = notaActividad;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(String idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    /*public int getCarne() {
        return carne;
    }

    public void setCarne(int carne) {
        this.carne = carne;
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
    }*/

    @Override
    public String toString() {
        return "Nota{" + "idNota=" + idNota + ", nombreActividad=" + nombreActividad + ", notaActividad=" + notaActividad + ", fechaEntrega=" + fechaEntrega + ", idAsignacion=" + idAsignacion /*+ ", carne=" + carne + ", nombres=" + nombres + ", apellidos=" + apellidos + ", descripcion=" + descripcion + '}'*/;
    }

}
