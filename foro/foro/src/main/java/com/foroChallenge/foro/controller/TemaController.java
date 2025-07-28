package com.foroChallenge.foro.controller;


import com.foroChallenge.foro.domain.tema.*;
import com.foroChallenge.foro.repository.TemaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tema")
public class TemaController {

    @Autowired
    private TemaRepository repository;

    @Transactional
    @PostMapping
    public void registrar(@RequestBody DatosTema datos) {
        System.out.println(datos);
        repository.save(new Tema(datos));
    }

    @GetMapping
    public List<DatosListaTema> listar() {
        return repository.findAll().stream().map(DatosListaTema::new).toList();
    }
    // DELETE LOGICO

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTema(@PathVariable Long id) {
        Tema tema = repository.getReferenceById(id);
        tema.desactivarTema();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosTema> retornaDatosTema(@PathVariable Long id) {
        Tema tema = repository.getReferenceById(id);
        var datosTema = new DatosTema( tema.getTitulo(),
                tema.getMensaje(),
                tema.getAutor(),
                tema.getCurso(),
                tema.getStatus().toString());
        return ResponseEntity.ok(datosTema);
    }
    @PutMapping
    @Transactional
    public ResponseEntity actualizarTema(@RequestBody @Valid DatosActualizarTema datosActualizarTema) {
        Tema tema = repository.getReferenceById(datosActualizarTema.id());
        tema.actualizarDatos(datosActualizarTema);
        return ResponseEntity.ok(new DatosTema(tema.getTitulo(),
                tema.getMensaje(),
                tema.getAutor(),
                tema.getCurso(),
                tema.getStatus().toString()));
    }

}
