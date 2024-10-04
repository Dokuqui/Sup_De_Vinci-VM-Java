package com.formation.hellospring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.formation.hellospring.models.DessinModel;
import com.formation.hellospring.services.JmsSenderService;
import com.formation.hellospring.services.PersistDessinService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/dessins")
public class DessinController {

    @Autowired
    PersistDessinService serviceDessin;

    private Logger logger = LoggerFactory.getLogger(DessinController.class);

    @GetMapping("/get-list")
    public ResponseEntity<List<String>> getAllDessin() {
        List<String> returnList = serviceDessin.getAllDraw();
        logger.info("Call List of dessins");
        return new ResponseEntity(returnList, HttpStatus.OK);
    }
    

    @GetMapping("/get-one")
    public ResponseEntity<DessinModel> getOneDessin(String name) {
        DessinModel dessinByName = serviceDessin.getDrawOnebyName(name);
        logger.info("Call one dessin");
        if (dessinByName != null) {
            return new ResponseEntity(dessinByName, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        
    }

    @PostMapping("/create")
    public ResponseEntity createDessin(@RequestBody DessinModel dessinFromClient) {
        serviceDessin.createDraw(dessinFromClient);
        logger.info("Call to create new dessin data");
        JmsSenderService.sendMessage(String.format("Dessin: %1$s created", dessinFromClient.getNom()));
        return new ResponseEntity(dessinFromClient, HttpStatus.CREATED);
    }

}