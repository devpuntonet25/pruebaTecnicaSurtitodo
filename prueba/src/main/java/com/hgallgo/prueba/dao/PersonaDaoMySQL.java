package com.hgallgo.prueba.dao;

import com.hgallgo.prueba.model.Ciudad;
import com.hgallgo.prueba.model.Persona;
import com.hgallgo.prueba.model.TipoDocumento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.hgallgo.prueba.dao.DB.getConnection;

public class PersonaDaoMySQL implements IDao<Persona>{

    private final static String SQL_INSERT = """
            INSERT INTO persona(TIPO_DOCUMENTO, CIUDAD, NOMBRE, APELLIDO, NUMERO_DOCUMENTO, DIRECCION, FECHA_INGRESO)
            VALUES(?, ?, ?, ?, ?, ?, ?);
            """;

    private final static String SQL_FIND_BY_ID = """
            SELECT
            p.ID as 'ID_PERSONA',
            p.NOMBRE,
            p.APELLIDO,
            p.NUMERO_DOCUMENTO,
            p.DIRECCION,
            p.FECHA_INGRESO,
            p.TIPO_DOCUMENTO,
            t.TIPO,
            t.DESCRIPCION,
            p.CIUDAD,
            c.NOMBRE as 'NOMBRE_CIUDAD'
            FROM PERSONA p JOIN TIPO_DOCUMENTO t
            ON p.TIPO_DOCUMENTO = t.ID
            JOIN CIUDAD c
            ON p.CIUDAD = c.ID
            WHERE P.ID = ?
            """;
    private static final String SQL_UDPATE = """
            UPDATE PERSONA SET
            NOMBRE = ?,
            APELLIDO = ?,
            NUMERO_DOCUMENTO = ?,
            DIRECCION = ?,
            FECHA_INGRESO = ?,
            TIPO_DOCUMENTO = ?,
            CIUDAD = ?
            WHERE ID = ?;
            """;
    private static final String SQL_DELETE = """
            DELETE FROM PERSONA WHERE ID = ?;
            """;
    private static final String SQL_SELECT_ALL = """
            SELECT
            p.ID as 'ID_PERSONA',
            p.NOMBRE,
            p.APELLIDO,
            p.NUMERO_DOCUMENTO,
            p.DIRECCION,
            p.FECHA_INGRESO,
            p.TIPO_DOCUMENTO,
            t.TIPO,
            t.DESCRIPCION,
            p.CIUDAD,
            c.NOMBRE as 'NOMBRE_CIUDAD'
            FROM PERSONA p JOIN TIPO_DOCUMENTO t
            ON p.TIPO_DOCUMENTO = t.ID
            JOIN CIUDAD c
            ON p.CIUDAD = c.ID
            """;

    @Override
    public Persona save(Persona persona) {
        Connection connection = null;
        Persona personaGuardada = null;

        try {
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, persona.getTipoDocumento().getId());
            ps.setInt(2, persona.getCiudad().getId());
            ps.setString(3, persona.getNombre());
            ps.setString(4, persona.getApellido());
            ps.setString(5, persona.getNumeroDocumento());
            ps.setString(6, persona.getDireccion());
            ps.setDate(7, Date.valueOf(persona.getFechaIngreso()));

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                persona.setId(rs.getInt(1));
                personaGuardada = persona;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return personaGuardada;
    }

    @Override
    public Persona findById(Integer id) {
        Connection connection = null;
        Persona personaBuscada = null;

        try {
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_FIND_BY_ID);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                personaBuscada = new Persona(
                        rs.getInt("ID_PERSONA"),
                        rs.getString("NOMBRE"),
                        rs.getString("APELLIDO"),
                        rs.getString("NUMERO_DOCUMENTO"),
                        rs.getString("DIRECCION"),
                        rs.getDate("FECHA_INGRESO").toLocalDate(),
                        new TipoDocumento(
                                rs.getInt("TIPO_DOCUMENTO"),
                                rs.getString("TIPO"),
                                rs.getString("DESCRIPCION")
                        ),
                        new Ciudad(
                                rs.getInt("CIUDAD"),
                                rs.getString("NOMBRE_CIUDAD")
                        )
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return personaBuscada;
    }

    @Override
    public Persona update(Persona persona) {
        Connection connection = null;
        Persona personaBuscada = findById(persona.getId());

        if (personaBuscada != null) {
            try {
                connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(SQL_UDPATE);
                ps.setString(1, persona.getNombre());
                ps.setString(2, persona.getApellido());
                ps.setString(3, persona.getNumeroDocumento());
                ps.setString(4, persona.getDireccion());
                ps.setDate(5, Date.valueOf(persona.getFechaIngreso()));
                ps.setInt(6, persona.getTipoDocumento().getId());
                ps.setInt(7, persona.getCiudad().getId());
                ps.setInt(8, persona.getId());

                ps.execute();

                personaBuscada = persona;

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return personaBuscada;
    }

    @Override
    public Persona delete(Integer id) {
        Connection connection = null;
        Persona personaBuscada = findById(id);

        if (personaBuscada != null) {
            try {
                connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(SQL_DELETE);
                ps.setInt(1, id);
                ps.execute();

            } catch (Exception e) {
                e.printStackTrace();
                personaBuscada = null;
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return personaBuscada;
    }

    @Override
    public List<Persona> findAll() {
        Connection connection = null;
        List<Persona> personaList = new ArrayList<>();
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL);
            while (rs.next()) {
                personaList.add(
                        new Persona(
                                rs.getInt("ID_PERSONA"),
                                rs.getString("NOMBRE"),
                                rs.getString("APELLIDO"),
                                rs.getString("NUMERO_DOCUMENTO"),
                                rs.getString("DIRECCION"),
                                rs.getDate("FECHA_INGRESO").toLocalDate(),
                                new TipoDocumento(
                                        rs.getInt("TIPO_DOCUMENTO"),
                                        rs.getString("TIPO"),
                                        rs.getString("DESCRIPCION")
                                ),
                                new Ciudad(
                                        rs.getInt("CIUDAD"),
                                        rs.getString("NOMBRE_CIUDAD")
                                )
                        )
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return personaList;
    }
}
