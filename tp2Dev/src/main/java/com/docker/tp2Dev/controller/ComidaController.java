package com.docker.tp2Dev.controller;

import com.docker.tp2Dev.model.Comida;
import com.docker.tp2Dev.service.ComidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comidas")
public class ComidaController {

    @Autowired
    private ComidaService service;

    @PostMapping
    public ResponseEntity<Comida> criarComida(@RequestBody Comida comida) {
        Comida comidaCriada = service.criarComida(comida);
        return new ResponseEntity<>(comidaCriada, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Comida>> listarComidas() {
        List<Comida> comidas = service.listarComidas();
        return new ResponseEntity<>(comidas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comida> obterComida(@PathVariable Long id) {
        Optional<Comida> comida = service.obterComida(id);
        return comida.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comida> atualizarComida(@PathVariable Long id, @RequestBody Comida comida) {
        Comida comidaAtualizada = service.atualizarComida(id, comida);
        return new ResponseEntity<>(comidaAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirComida(@PathVariable Long id) {
        service.excluirComida(id);
        return new ResponseEntity<>("Item de comida excluído com sucesso.", HttpStatus.NO_CONTENT);
    }
}

