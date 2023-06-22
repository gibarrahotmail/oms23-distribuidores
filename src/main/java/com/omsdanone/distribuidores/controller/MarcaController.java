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
import com.omsdanone.distribuidores.model.Marca;
import com.omsdanone.distribuidores.repository.MarcaRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin    //(origins = {"http://localhost:9092", "http://localhost:4200"})  //(origins = "http://localhost:9092")
@Tag(name = "Marca", description = "Marca management endpoints")
@RestController
@RequestMapping("/api")
public class MarcaController {
   
  @Autowired
  MarcaRepository marcaRepository;

  @GetMapping("/marca/{marcaid}/{companiaid}")
  public ResponseEntity<List<Marca>> getMarcaById
  (@PathVariable("marcaid") Byte marcaid, @PathVariable("companiaid") Byte companiaid) {
    List<Marca> marcas = marcaRepository.findById(marcaid, companiaid);
   
    if (marcas != null) {
      return new ResponseEntity<>(marcas, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping("/marca/{usuarioid}")
  public ResponseEntity<RepositoryResult> createMarca (@RequestBody Marca marca, @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = marcaRepository.insert(marca, usuarioid);
         
      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);

      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @DeleteMapping("/marca/{marcaid}/{usuarioid}")
  public ResponseEntity<RepositoryResult> deletemarca(@PathVariable("marcaid") Byte marcaid, 
  @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = marcaRepository.deleteById(marcaid, usuarioid);

      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);

      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }      
}

