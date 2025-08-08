package com.fiap.projeto.controller;

import org.springframework.aot.generate.InMemoryGeneratedFiles;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/projetos")

public class ProjectController {

    private static Map<Integer, Projeto> projetos = new HashMap<>();

    public  ProjectController(){
        projetos.put(1, new Projeto(1, "Teste", "XXXX",690));
        projetos.put(2, new Projeto(1, "Teste", "XXXX",690));
    }
    @GetMapping
    public Map<Integer, Projeto> listar(){
        return projetos;
    }
    @GetMapping("/{id}")
    public Projeto byId(@PathVariable Integer id) {
        return projetos.get(id);
    }

    @PostMapping
    public ResponseEntity<Projeto> criar(@RequestBody Projeto projeto) {
        projetos.put(projeto.id, projeto);
        return new ResponseEntity<Projeto>(projeto,HttpStatus.CREATED);
    }

    @PutMapping("/{id")
    public ResponseEntity<Projeto> atualizar(@RequestBody Projeto projeto) {
        if (projetos.get(projeto.id) != null){
            projetos.put(projeto.id, projeto);
            return new ResponseEntity<Projeto>(projeto,HttpStatus.OK);
        };

        return new ResponseEntity<Projeto>(projeto,HttpStatus.NOT_FOUND);
    }
    record Projeto(int id, String nome, String responsavel, int horasEstimadas){}
}
