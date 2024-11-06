package com.hgallgo.prueba.controller;

import com.hgallgo.prueba.model.Persona;
import com.hgallgo.prueba.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping
    public ResponseEntity<Persona> save(@RequestBody Persona persona) {
            return ResponseEntity.ok(personaService.save(persona));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Persona personaBuscada = personaService.findById(id);

        if (personaBuscada != null) {
            return ResponseEntity.ok(personaBuscada);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró una persona con el id " + id);

    }

    @PutMapping
    public ResponseEntity<Persona> update(@RequestBody Persona persona) {
        return ResponseEntity.ok(personaService.update(persona));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Persona personaEliminada = personaService.delete(id);

        if (personaEliminada != null) {
            return ResponseEntity.ok(personaEliminada);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró una persona con el id " + id +
                " por tanto no se eliminó");

    }

    @GetMapping
    public ResponseEntity<List<Persona>> findAll() {
        return ResponseEntity.ok(personaService.findAll());
    }
}
