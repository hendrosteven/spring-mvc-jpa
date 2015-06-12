/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.controller;

import core.dao.DepartemenDAO;
import entity.Departemen;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/departemen")
public class DepartemenController {

    @Autowired
    private DepartemenDAO departemenDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(ModelMap model) {
        model.addAttribute("departemens", departemenDAO.getAll());
        return "departemen";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/insert")
    public String insert(HttpServletRequest request) {
        String kode = request.getParameter("txtKode");
        String nama = request.getParameter("txtNama");
        Departemen dep = new Departemen();
        dep.setKode(kode);
        dep.setNama(nama);
        departemenDAO.insert(dep);
        return "redirect:/departemen";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(HttpServletRequest request) {
        long id = Long.valueOf(request.getParameter("id"));        
        departemenDAO.delete(id);        
        return "redirect:/departemen";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public String update(HttpServletRequest request) {
        long id = Long.valueOf(request.getParameter("txtId"));
        String kode = request.getParameter("txtKode");
        String nama = request.getParameter("txtNama");
        Departemen dep = new Departemen();
        dep.setId(id);
        dep.setKode(kode);
        dep.setNama(nama);
        departemenDAO.update(dep);
        return "redirect:/departemen";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/json")
    @ResponseBody
    public List<Departemen> getAllJSon() {
        return departemenDAO.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detail/json")
    @ResponseBody
    public Departemen getByIdJson(HttpServletRequest request) {
        long id = Long.valueOf(request.getParameter("id"));
        return departemenDAO.getById(id);
    }
}
