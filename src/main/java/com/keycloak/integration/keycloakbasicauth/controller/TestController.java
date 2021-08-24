package com.keycloak.integration.keycloakbasicauth.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "test")
@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
public class TestController {


    @GetMapping
    public ResponseEntity<String> testController() {
        var result = "it workds";
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
