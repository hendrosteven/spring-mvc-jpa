/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Departemen;
import java.util.List;

/**
 *
 * @author user
 */
public interface DepartemenDAO {
    public void insert(Departemen dep);
    public void update(Departemen dep);
    public void delete(long id);
    public Departemen getById(long id);
    public List<Departemen> getAll();
}
