/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegopatzan.models.dao;

import com.diegopatzan.db.ConexionPU;
import com.diegopatzan.models.domain.Nota;
import com.diegopatzan.models.idao.INotaDao;
import java.util.List;

/**
 *
 * @author Diego Fernando
 */
public class NotaDaoJPA implements INotaDao {

    private ConexionPU conn = ConexionPU.getInstance();

    @Override
    public List<Nota> listar() {
        return conn.getEntityManager().createNamedQuery("Nota.findAll").getResultList();
    }

    @Override
    public Nota encontrar(Nota nota) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertar(Nota nota) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(Nota nota) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Nota nota) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
