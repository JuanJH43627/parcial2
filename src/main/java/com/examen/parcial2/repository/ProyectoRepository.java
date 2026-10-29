
package com.examen.parcial2.repository;

import com.examen.parcial2.models.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository
        extends JpaRepository<Proyectos, Long> {
}
