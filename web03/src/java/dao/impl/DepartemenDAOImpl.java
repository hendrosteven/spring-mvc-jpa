/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DepartemenDAO;
import entity.Departemen;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author user
 */
public class DepartemenDAOImpl extends GenericDAOImpl implements DepartemenDAO {

    public DepartemenDAOImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Departemen getById(long id) {
        Departemen dep = null;
        try {
            dep = this.em.find(Departemen.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dep;
    }

    @Override
    public List<Departemen> getAll() {
        List<Departemen> departemens = new ArrayList<Departemen>();
        try {
            departemens = this.em.createQuery("SELECT d From Departemen d")
                    .getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return departemens;
    }

}
