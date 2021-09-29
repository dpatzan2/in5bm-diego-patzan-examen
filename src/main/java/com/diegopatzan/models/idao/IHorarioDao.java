/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegopatzan.models.idao;

import com.diegopatzan.models.domain.Horario;
import java.util.List;

/**
 * @author Cristian Noe Cumez Morales
 * Codigo técnico:IN5BM
 * @date 9/1/2021
 * @time 07:55:02
 */

public interface IHorarioDao {
    
    //Declarion de variables para mostrar 
    public List<Horario> listar();// Obtener todos los estudiante.
    public Horario encontrar(Horario horario); // Busca a los estudiante es como mostrar.
    public int insertar(Horario horario); // Insertar 
    public int actualizar(Horario horario);// Actualizar
    public int eliminar(Horario horario); //Borrar
    
}
