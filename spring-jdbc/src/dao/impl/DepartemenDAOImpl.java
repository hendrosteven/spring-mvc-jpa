/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DepartemenDAO;
import entity.Departemen;
import entity.mapper.DepartemenMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository("departemenDAO")
public class DepartemenDAOImpl implements DepartemenDAO {

    @Autowired
    private JdbcTemplate template;

    public DepartemenDAOImpl() {
    }

    public DepartemenDAOImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void insert(Departemen dep) {
        this.template
                .update("INSERT INTO departemen(kode,nama) VALUES(?,?)",
                        dep.getKode(), dep.getNama());

    }

    @Override
    public void update(Departemen dep) {
        this.template
                .update("UPDATE departemen SET kode=?, nama=? WHERE id=?",
                        dep.getKode(), dep.getNama(), dep.getId());
    }

    @Override
    public void delete(long id) {
        this.template.update("DELETE FROM depertemen WHERE id=?", id);
    }

    @Override
    public Departemen getById(long id) {
        String sql = "SELECT id,kode,nama FROM departemen WHERE id=?";
        return this.template.queryForObject(sql, new Object[]{id}, 
                new DepartemenMapper());
    }

    @Override
    public List<Departemen> getAll() {
        String sql = "SELECT id,kode,nama FROM departemen";
        return this.template.query(sql, new DepartemenMapper());
    }

}
