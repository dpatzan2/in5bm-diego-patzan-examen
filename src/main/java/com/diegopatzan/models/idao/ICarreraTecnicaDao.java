/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegopatzan.models.idao;

import com.diegopatzan.models.domain.CarreraTecnica;
import java.util.List;

/**
 *
 * @author gabri
 */
public interface ICarreraTecnicaDao {
    public List<CarreraTecnica>listar();
    public CarreraTecnica encontrar(CarreraTecnica carreraTecnica);
    public int insertar(CarreraTecnica carreraTecnica);
    public int actualizar(CarreraTecnica carreraTecnica);
    public int eliminar(CarreraTecnica carreraTecnica);
}
