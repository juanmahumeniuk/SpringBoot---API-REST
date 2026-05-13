package com.example.demo.controllers;

import com.example.demo.entities.Localidad;
import com.example.demo.services.LocalidadService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/localidades")
public class LocalidadController extends BaseControllerImpl<Localidad, Long, LocalidadService> {

    public LocalidadController(LocalidadService localidadService) {
        super(localidadService);
    }
}
