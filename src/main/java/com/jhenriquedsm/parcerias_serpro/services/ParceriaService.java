package com.jhenriquedsm.parcerias_serpro.services;

import com.jhenriquedsm.parcerias_serpro.exceptions.ParceriaAlreadyExistsException;
import com.jhenriquedsm.parcerias_serpro.exceptions.ParceriaNotFound;
import com.jhenriquedsm.parcerias_serpro.model.Parceria;
import com.jhenriquedsm.parcerias_serpro.repositories.ParceriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParceriaService {

    @Autowired
    ParceriaRepository parceriaRepository;

    public List<Parceria> findAll() {
        return parceriaRepository.findAll();
    }

    public Parceria findById(Long id) {
        return parceriaRepository.findById(id)
                .orElseThrow(() -> new ParceriaNotFound("Parceria não encontrada com ID: " + id));
    }

    public Parceria create(Parceria parceria) {
        if (parceriaRepository.existsByTitle(parceria.getTitle())) {
            throw new ParceriaAlreadyExistsException("Parceria já existente com título: " + parceria.getTitle());
        }

        parceria.setId(null);
        return parceriaRepository.save(parceria);
    }

    public Parceria update(Parceria parceria) {
        var foundParceria = parceriaRepository.findById(parceria.getId())
                .orElseThrow(() -> new ParceriaNotFound("Parceria não encontrada!"));

        foundParceria.setTitle(parceria.getTitle());
        foundParceria.setUrl(parceria.getUrl());
        foundParceria.setNewsDate(parceria.getNewsDate());

        return parceriaRepository.save(foundParceria);
    }

    public void delete(Long id) {
        var foundParceria = parceriaRepository.findById(id)
                .orElseThrow(() -> new ParceriaNotFound("Parceria não encontrada!"));

        parceriaRepository.delete(foundParceria);
    }
}