/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegopatzan.models.domain;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * @author Cristian Noe Cumez Morales Codigo técnico:IN5BM
 * @date 9/1/2021
 * @time 07:55:02
 */
public class Horario implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idHorario;
    private Time horarioInicio;
    private Time horarioFinal;
    private Date dateInicio;
    private Date dateFinal;

    public Horario() {

    }

    public Horario(Time horarioInicio, Time horarioFinal) {
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
    }

    public Horario(int idHorario, Time horarioInicio, Time horarioFinal) {
        this.idHorario = idHorario;
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
    }

    public Horario(Date dateInicio, Date dateFinal) {
        this.dateInicio = dateInicio;
        this.dateFinal = dateFinal;
    }

    public Horario(int idHorario) {
        this.idHorario = idHorario;
    }

    public Horario(int idHorario, Date dateInicio, Date dateFinal) {
        this.idHorario = idHorario;
        this.dateInicio = dateInicio;
        this.dateFinal = dateFinal;
    }



    /*
    public Horario(int idHorario) {
       
    }
     */
    public Date getDateIncio() {
        return dateInicio;
    }

    public void setDateInicio(Date dateInicio) {
        this.dateInicio = dateInicio;
    }

    public Date getDateFinal() {
        return dateFinal;
    }

    public void setDateFinal(Date dateFinal) {
        this.dateFinal = dateFinal;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public Time getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Time horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Time getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(Time horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    @Override
    public String toString() {
        return "Horario{" + "idHorario=" + idHorario + ", horarioInicio=" + horarioInicio + ", horarioFinal=" + horarioFinal + '}';
    }

}
