/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao.impl;

import core.dao.DepartemenDAO;
import entity.Departemen;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Repository("departemenDAO")
@Transactional
public class DepartemenDAOImpl implements DepartemenDAO{
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void insert(Departemen dep) {
        this.em.persist(dep);
   }

    @Override
    public void update(Departemen dep) {
        this.em.merge(dep);
    }

    @Override
    public void delete(long id) {
        this.em.remove(this.em.find(Departemen.class, id));
    }

    @Override
    public Departemen getById(long id) {
        return this.em.find(Departemen.class, id);
    }

    @Override
    public List<Departemen> getAll() {
        return this.em.createQuery("SELECT d FROM Departemen d")
                .getResultList();
    }
}
