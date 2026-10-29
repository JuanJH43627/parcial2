
package com.examen.parcial2.services;

import com.examen.parcial2.models.Proyectos;
import com.examen.parcial2.repository.ProyectoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {

    private final ProyectoRepository proyectoRepository;

    public ProyectoService(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    public List<Proyectos> listar() {
        return proyectoRepository.findAll();
    }

    public Optional<Proyectos> buscarPorId(Long id) {
        return proyectoRepository.findById(id);
    }

    public Proyectos crear(Proyectos proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public Optional<Proyectos> actualizar(
            Long id, Proyectos datos) {

        return proyectoRepository.findById(id)
                .map(proyecto -> {
                    proyecto.setNombre(datos.getNombre());
                    proyecto.setDescripcion(datos.getDescripcion());

                    return proyectoRepository.save(proyecto);
                });
    }

    public boolean eliminar(Long id) {
        if (!proyectoRepository.existsById(id)) {
            return false;
        }

        proyectoRepository.deleteById(id);
        return true;
    }
}
