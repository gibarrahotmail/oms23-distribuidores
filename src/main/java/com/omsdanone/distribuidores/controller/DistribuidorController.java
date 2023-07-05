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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omsdanone.distribuidores.model.RepositoryResult;
import com.omsdanone.distribuidores.model.Distribuidor;
import com.omsdanone.distribuidores.repository.DistribuidorRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin  //(origins = {"http://localhost:9092", "http://localhost:4200"})
@Tag(name = "Distribuidor", description = "Distribuidor management endpoints")
@RestController
@RequestMapping("/api")
public class DistribuidorController {
   
  @Autowired
  DistribuidorRepository distribuidorRepository;

  @GetMapping("/distribuidor/{distribuidorid}")
  public ResponseEntity<List<Distribuidor>> getDistribuidorById
  (@PathVariable("distribuidorid") Short distribuidorid, @RequestParam("soloactivos") String soloactivos) {
    List<Distribuidor> distribuidors = distribuidorRepository.findById(distribuidorid, 
      soloactivos == "1" || soloactivos.toUpperCase() == "YES");
   
    if (distribuidors != null) {
      return new ResponseEntity<>(distribuidors, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping("/distribuidor/{usuarioid}")
  public ResponseEntity<RepositoryResult> createDistribuidor (@RequestBody Distribuidor distribuidor, 
  @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = distribuidorRepository.insert(distribuidor, usuarioid);
         
      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);

      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @DeleteMapping("/distribuidor/{distribuidorid}/{usuarioid}")
  public ResponseEntity<RepositoryResult> deletedistribuidor(@PathVariable("distribuidorid") Short distribuidorid, 
  @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = distribuidorRepository.deleteById(distribuidorid, usuarioid);

      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);

      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
}
