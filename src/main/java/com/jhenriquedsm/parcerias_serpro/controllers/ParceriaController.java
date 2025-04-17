package com.jhenriquedsm.parcerias_serpro.controllers;

import com.jhenriquedsm.parcerias_serpro.model.Parceria;
import com.jhenriquedsm.parcerias_serpro.services.ParceriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/parcerias")
public class ParceriaController {

    @Autowired
    ParceriaService parceriaService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Parceria create(@RequestBody Parceria parceria) {
        return parceriaService.create(parceria);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Parceria> findAll() {
        return parceriaService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Parceria> findById(@PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.ok(parceriaService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Parceria> update(@PathVariable(value = "id") Long id, @RequestBody Parceria parceria) {
        try {
            if (!id.equals(parceria.getId())) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(parceriaService.update(parceria));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        try {
            parceriaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}