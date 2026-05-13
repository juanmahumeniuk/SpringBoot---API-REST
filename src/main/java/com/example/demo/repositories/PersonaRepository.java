package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Persona;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    boolean existsByDni(int dni);

    //Anotación JPQL parametros indexados
    @Query("SELECT p FROM Persona p WHERE p.nombre LIKE CONCAT('%', :filtro, '%') OR p.apellido LIKE CONCAT('%', :filtro, '%')")
    List<Persona> search(@Param("filtro") String filtro);

    @Query(
            value = "SELECT p FROM Persona p WHERE p.nombre LIKE CONCAT('%', :filtro, '%') OR p.apellido LIKE CONCAT('%', :filtro, '%')",
            countQuery = "SELECT count(p) FROM Persona p WHERE p.nombre LIKE CONCAT('%', :filtro, '%') OR p.apellido LIKE CONCAT('%', :filtro, '%')"
    )
    Page<Persona> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE '%?1%' OR persona.apellido LIKE '%?1%'",
            nativeQuery = true
    )
    List<Persona> search1(String filtro);

    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE CONCAT('%', :filtro, '%') OR persona.apellido LIKE CONCAT('%', :filtro, '%')",
            countQuery = "SELECT count(*) FROM persona WHERE persona.nombre LIKE CONCAT('%', :filtro, '%') OR persona.apellido LIKE CONCAT('%', :filtro, '%')",
            nativeQuery = true
    )
    Page<Persona> search1(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM persona WHERE nombre LIKE CONCAT('%', :filtro, '%') OR apellido LIKE CONCAT('%', :filtro, '%')",
            nativeQuery = true
    )
    List<Persona> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM persona WHERE nombre LIKE CONCAT('%', :filtro, '%') OR apellido LIKE CONCAT('%', :filtro, '%')",
            countQuery = "SELECT count(*) FROM persona WHERE nombre LIKE CONCAT('%', :filtro, '%') OR apellido LIKE CONCAT('%', :filtro, '%')",
            nativeQuery = true
    )
    Page<Persona> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
