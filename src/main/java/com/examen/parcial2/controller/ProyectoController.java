
package com.examen.parcial2.controller;

import com.examen.parcial2.models.Proyectos;
import com.examen.parcial2.services.ProyectoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {

    private final ProyectoService proyectoService;

    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    @PostMapping
    public ResponseEntity<Proyectos> crear(
            @RequestBody Proyectos proyecto) {

        Proyectos nuevo = proyectoService.crear(proyecto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<Proyectos>> listar() {
        return ResponseEntity.ok(
                proyectoService.listar()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyectos> buscarPorId(
            @PathVariable Long id) {

        return proyectoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyectos> actualizar(
            @PathVariable Long id,
            @RequestBody Proyectos proyecto) {

        return proyectoService.actualizar(id, proyecto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id) {

        boolean eliminado = proyectoService.eliminar(id);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
