package com.example.demo.services;

import com.example.demo.entities.Persona;

import java.util.List;

public interface PersonaService extends BaseService<Persona, Long>{

    List<Persona> search(String filtro) throws Exception;
}
