package com.example.demo.controllers;

import com.example.demo.entities.Domicilio;
import com.example.demo.services.DomicilioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/domicilios")
public class DomicilioController extends BaseControllerImpl<Domicilio, Long, DomicilioService> {

    public DomicilioController(DomicilioService domicilioService) {
        super(domicilioService);
    }
}
