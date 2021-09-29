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
        return (Nota) conn.getEntityManager().createNamedQuery("Nota.find").setParameter("id", nota.getIdNota()).getSingleResult();
    }

    @Override
    public int insertar(Nota nota) {
        int rows = 0;
        try {
            conn.getEntityManager().getTransaction().begin();
            conn.getEntityManager().persist(nota);
            conn.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            conn.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

    @Override
    public int actualizar(Nota nota) {
        int rows = 0;
        try {
            conn.getEntityManager().getTransaction().begin();
            conn.getEntityManager().merge(nota);
            conn.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            conn.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

    @Override
    public int eliminar(Nota nota) {
        int rows = 0;
        try {
            conn.getEntityManager().getTransaction().begin();
            conn.getEntityManager().remove(nota);
            conn.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            conn.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

}
