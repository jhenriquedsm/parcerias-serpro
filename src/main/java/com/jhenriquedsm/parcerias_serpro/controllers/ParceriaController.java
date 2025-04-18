package com.jhenriquedsm.parcerias_serpro.controllers;

import com.jhenriquedsm.parcerias_serpro.model.Parceria;
import com.jhenriquedsm.parcerias_serpro.services.ParceriaService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Cria uma parceria", description = "Cria uma parceria recebendo uma parceria pelo JSON")
    public Parceria create(@RequestBody Parceria parceria) {
        return parceriaService.create(parceria);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Busca todas as parcerias", description = "Busca todas as parcerias persistidas no banco de dados")
    public List<Parceria> findAll() {
        return parceriaService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Busca uma parceria", description = "Busca uma parceria pelo id")
    public ResponseEntity<Parceria> findById(@PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.ok(parceriaService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Atualiza uma parceria", description = "Atualiza os dados de uma parceria existente pelo ID")
    public ResponseEntity<Parceria> update(@PathVariable(value = "id") Long id, @RequestBody Parceria parceria) {
        try {
            parceria.setId(id);
            return ResponseEntity.ok(parceriaService.update(parceria));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }


    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deleta uma parceria", description = "Deleta uma parceria pelo id")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        try {
            parceriaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}