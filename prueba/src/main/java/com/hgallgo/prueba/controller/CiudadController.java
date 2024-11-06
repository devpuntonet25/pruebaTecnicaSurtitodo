package com.hgallgo.prueba.controller;

import com.hgallgo.prueba.model.Ciudad;
import com.hgallgo.prueba.service.CiudadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ciudades")
public class CiudadController {

    private CiudadService ciudadService;

    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @GetMapping
    public ResponseEntity<List<Ciudad>> findAll() {
        return ResponseEntity.ok(ciudadService.findAll());
    }

}
