package com.hgallgo.prueba.controller;

import com.hgallgo.prueba.model.TipoDocumento;
import com.hgallgo.prueba.service.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipoDocumentos")
public class TipoDocumentoController {
    private TipoDocumentoService tipoDocumentoService;

    @Autowired
    public TipoDocumentoController(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    @GetMapping
    public ResponseEntity<List<TipoDocumento>> findAll() {
        return ResponseEntity.ok(tipoDocumentoService.findAll());
    }
}
