package com.hgallgo.prueba.dao;

import com.hgallgo.prueba.model.TipoDocumento;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.hgallgo.prueba.dao.DB.getConnection;

public class TipoDocumentoDaoMySQL implements IDao<TipoDocumento>{

    private final static String SQL_FIND_ALL = """
            SELECT * FROM tipo_documento;
            """;
    @Override
    public TipoDocumento save(TipoDocumento tipoDocumento) {
        return null;
    }

    @Override
    public TipoDocumento findById(Integer id) {
        return null;
    }

    @Override
    public TipoDocumento update(TipoDocumento tipoDocumento) {
        return null;
    }

    @Override
    public TipoDocumento delete(Integer id) {
        return null;
    }

    @Override
    public List<TipoDocumento> findAll() {
        Connection connection = null;
        List<TipoDocumento> tipoDocumentoList = new ArrayList<>();

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(SQL_FIND_ALL);
            while(rs.next()) {
                tipoDocumentoList.add(
                        new TipoDocumento(
                                rs.getInt("ID"),
                                rs.getString("TIPO"),
                                rs.getString("DESCRIPCION")
                        )
                );
            }

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }

        return tipoDocumentoList;
    }
}
