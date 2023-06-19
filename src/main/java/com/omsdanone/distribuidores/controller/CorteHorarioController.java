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
import com.omsdanone.distribuidores.model.CorteHorario;
import com.omsdanone.distribuidores.repository.CorteHorarioRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name = "CorteHorario", description = "CorteHorario management endpoints")
@RestController
@RequestMapping("/api")
public class CorteHorarioController {
  @Autowired
  CorteHorarioRepository cortehorarioRepository;

  @GetMapping("/cortehorario/{cortehorarioid}")
  public ResponseEntity<List<CorteHorario>> getCorteHorarioById
  (@PathVariable("cortehorarioid") String cortehorarioid) {
    List<CorteHorario> cortehorarios = cortehorarioRepository.findById(cortehorarioid);
   
    if (cortehorarios != null) {
      return new ResponseEntity<>(cortehorarios, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping("/cortehorario/{usuarioid}")
  public ResponseEntity<RepositoryResult> createCorteHorario (@RequestBody CorteHorario cortehorario, 
  @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = cortehorarioRepository.insert(cortehorario, usuarioid);
         
      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @DeleteMapping("/cortehorario/{cortehorarioid}/{usuarioid}")
  public ResponseEntity<RepositoryResult> deletecortehorario(@PathVariable("cortehorarioid") String cortehorarioid, 
  @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = cortehorarioRepository.deleteById(cortehorarioid, usuarioid);

      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }      

}
