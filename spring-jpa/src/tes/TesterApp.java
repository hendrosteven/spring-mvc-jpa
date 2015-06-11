/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tes;

import dao.DepartemenDAO;
import dao.impl.DepartemenDAOImpl;
import entity.Departemen;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author user
 */
public class TesterApp {

    public static void main(String[] args) {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("appconfig.xml");
        DepartemenDAO dao
                = (DepartemenDAO) ctx.getBean("departemenDAO");
        for (Departemen dep : dao.getAll()) {
            System.out.println(dep.getNama());
        }
    }
}
