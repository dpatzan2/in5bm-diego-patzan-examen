/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegopatzan.models.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Diego Fernando Patzán Marroquín
 * @date 30/08/2021
 * @time 02:20:17 PM
 */

@Entity
@Table(name = "asignacion_alumno")
@NamedQueries({
    @NamedQuery(
            name = "AsignacionAlumno.findAll",
            query = "from AsignacionAlumno"
    )
})
public class AsignacionAlumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "asignacion_id")
    private String idAsignacion;
    @Column(name = "carne")
    private String carne;
    @Column(name = "curso_id")
    private int idCurso;
    @Column(name = "fecha_asignacion")
    private Timestamp fecha_asignacion;
    
    @OneToMany(mappedBy = "asignacionAlumno", fetch = FetchType.LAZY)
    private List<Nota> nota;
   

    public AsignacionAlumno(String idAsignacion, String carne, int idCurso, Timestamp fecha_asignacion) {
        this.idAsignacion = idAsignacion;
        this.carne = carne;
        this.idCurso = idCurso;
        this.fecha_asignacion = fecha_asignacion;

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

    public List<Nota> getNota() {
        return nota;
    }

    public void setNota(List<Nota> nota) {
        this.nota = nota;
    }

}
