/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import javax.persistence.EntityManager;

/**
 *
 * @author user
 */
public class GenericDAOImpl implements GenericDAO {

    protected EntityManager em;

    public GenericDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insert(Object obj) {
        this.em.getTransaction().begin();
        try {
            this.em.persist(obj);
            this.em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

    @Override
    public void update(Object obj) {
        this.em.getTransaction().begin();
        try {
            this.em.merge(obj);
            this.em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Object obj) {
        this.em.getTransaction().begin();
        try {
            this.em.remove(this.em.merge(obj));
            this.em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

}
