package com.hgallgo.prueba.service;

import com.hgallgo.prueba.dao.IDao;
import com.hgallgo.prueba.dao.TipoDocumentoDaoMySQL;
import com.hgallgo.prueba.model.TipoDocumento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDocumentoService {

    private IDao<TipoDocumento> tipoDocumentoIDao;

    public TipoDocumentoService() {
        this.tipoDocumentoIDao = new TipoDocumentoDaoMySQL();
    }

    public List<TipoDocumento> findAll() {
        return tipoDocumentoIDao.findAll();
    }
}
