/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegopatzan.models.idao;

import com.diegopatzan.models.domain.Cursos;
import java.util.List;
/**
 *
 * @author doazm
 */
public interface ICursosDao {
    //Declarar los metodos para poder ingresar la base de datos
    
    public List<Cursos>listar();
    public Cursos encontrar(Cursos cursos);
    public int insertar(Cursos cursos);
    public int actualizar(Cursos cursos);
    public int eliminar(Cursos cursos);
}
