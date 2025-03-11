package com.example.springesprit.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ComposantController {
    private ClientController clientController;
}
