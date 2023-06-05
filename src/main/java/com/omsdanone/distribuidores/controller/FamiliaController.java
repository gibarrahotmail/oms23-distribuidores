package com.omsdanone.distribuidores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omsdanone.distribuidores.model.RepositoryResult;
import com.omsdanone.distribuidores.model.Familia;
import com.omsdanone.distribuidores.repository.FamiliaRepository;

import io.swagger.v3.oas.annotations.tags.Tag;


@CrossOrigin(origins = {"http://localhost:9092", "http://localhost:4200"})
@Tag(name = "Familia", description = "Familia management endpoints")
@RestController
@RequestMapping("/api")
public class FamiliaController {
   
  @Autowired
  FamiliaRepository familiaRepository;

  @GetMapping("/familia/{familiaid}/{marcaid}")
  public ResponseEntity<List<Familia>> getFamiliaById
  (@PathVariable("familiaid") Byte familiaid, @PathVariable("marcaid") Byte marcaid) {
    List<Familia> familias = familiaRepository.findById(familiaid, marcaid);
   
    if (familias != null) {
      return new ResponseEntity<>(familias, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping("/familia/{usuarioid}")
  public ResponseEntity<RepositoryResult> createFamilia (@RequestBody Familia familia, @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = familiaRepository.insert(familia, usuarioid);
         
      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @DeleteMapping("/familia/{familiaid}/{usuarioid}")
  public ResponseEntity<RepositoryResult> deletefamilia(@PathVariable("familiaid") Byte familiaid, @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = familiaRepository.deleteById(familiaid, usuarioid);

      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }      
}
