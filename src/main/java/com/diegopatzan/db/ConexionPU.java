/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diegopatzan.db;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Diego Fernando
 */
public class ConexionPU {
    private static final String PERSISTENCE_UNIT_NAME = "ControlAcademicoPU";
    private EntityManager entityManager;
    private static ConexionPU instancia;
    
    private ConexionPU(){
        try {
            entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    public static ConexionPU getInstance(){
        if (instancia == null) {
            instancia = new ConexionPU();
        }
        return instancia;
    }
    
    public EntityManager getEntityManager(){
        return entityManager;
    }
}
