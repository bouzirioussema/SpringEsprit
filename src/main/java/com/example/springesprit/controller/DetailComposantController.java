package com.example.springesprit.controller;


import com.example.springesprit.services.IDetailComposantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class DetailComposantController {
    private IDetailComposantService detailComposantService;
}
