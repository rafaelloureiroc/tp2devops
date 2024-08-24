package com.docker.tp2Dev.service;

import com.docker.tp2Dev.model.Comida;
import com.docker.tp2Dev.repository.ComidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComidaService {

    @Autowired
    private ComidaRepository repository;

    public Comida criarComida(Comida comida) {
        return repository.save(comida);
    }

    public List<Comida> listarComidas() {
        return repository.findAll();
    }

    public Optional<Comida> obterComida(Long id) {
        return repository.findById(id);
    }

    public Comida atualizarComida(Long id, Comida comidaAtualizada) {
        comidaAtualizada.setId(id);
        return repository.save(comidaAtualizada);
    }

    public void excluirComida(Long id) {
        repository.deleteById(id);
    }
}
