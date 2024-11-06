package com.hgallgo.prueba.dao;

import com.hgallgo.prueba.model.Ciudad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.hgallgo.prueba.dao.DB.getConnection;

public class CiudadDaoMySQL implements IDao<Ciudad> {

    private final static String SQL_FIND_ALL = """
            SELECT * FROM ciudad;
            """;

    @Override
    public Ciudad save(Ciudad ciudad) {
        return null;
    }

    @Override
    public Ciudad findById(Integer id) {
        return null;
    }

    @Override
    public Ciudad update(Ciudad ciudad) {
        return null;
    }

    @Override
    public Ciudad delete(Integer id) {
        return null;
    }

    @Override
    public List<Ciudad> findAll() {
        Connection connection = null;
        List<Ciudad> ciudadList = new ArrayList<>();
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(SQL_FIND_ALL);

            while(rs.next()) {
                ciudadList.add(
                  new Ciudad(rs.getInt("ID"), rs.getString("NOMBRE"))
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ciudadList;
    }
}
