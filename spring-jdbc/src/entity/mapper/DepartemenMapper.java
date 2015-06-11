/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.mapper;

import entity.Departemen;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author user
 */
public class DepartemenMapper implements RowMapper<Departemen> {

    @Override
    public Departemen mapRow(ResultSet rs, int i) throws SQLException {
        Departemen temp = new Departemen();
        temp.setId(rs.getLong("id"));
        temp.setKode(rs.getString("kode"));
        temp.setNama(rs.getString("nama"));
        return temp;
    }

}
