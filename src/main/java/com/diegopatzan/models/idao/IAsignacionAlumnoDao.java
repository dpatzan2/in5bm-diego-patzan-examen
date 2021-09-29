/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.diegopatzan.models.idao;

import com.diegopatzan.models.domain.AsignacionAlumno;
import java.util.List;

/**
 *
 * @author Diego Fernando Patzán Marroquín
 * @date 30/08/2021
 * @time 02:19:05 PM
 */
public interface IAsignacionAlumnoDao {
    public List<AsignacionAlumno> listar();
    public AsignacionAlumno encontrar(AsignacionAlumno asignacionAlumno);
    public int insertar(AsignacionAlumno asignacionAlumno);
    public int actualizar(AsignacionAlumno asignacionAlumno);
    public int eliminar(AsignacionAlumno asignacionAlumno);
}
