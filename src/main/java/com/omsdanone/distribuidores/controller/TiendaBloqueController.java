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
import com.omsdanone.distribuidores.model.TiendaBloque;
import com.omsdanone.distribuidores.repository.TiendaBloqueRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name = "TiendaBloque", description = "TiendaBloque management endpoints")
@RestController
@RequestMapping("/api")
public class TiendaBloqueController {

  @Autowired
  TiendaBloqueRepository tiendabloqueRepository;

  @GetMapping("/tiendabloque/{tiendabloqueid}")
  public ResponseEntity<List<TiendaBloque>> getTiendaBloqueById
  (@PathVariable("tiendabloqueid") Integer tiendabloqueid, @RequestParam("soloactivos") String solopendientes) {
    List<TiendaBloque> tiendabloques = tiendabloqueRepository.findById(tiendabloqueid,
    solopendientes == "1" || solopendientes.toUpperCase() == "YES");
   
    if (tiendabloques != null) {
      return new ResponseEntity<>(tiendabloques, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping("/tiendabloque")
  public ResponseEntity<RepositoryResult> createTiendaBloque (@RequestBody TiendaBloque tiendabloque) {
    try {
      RepositoryResult rresult = tiendabloqueRepository.insert(tiendabloque);
         
      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);

      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);  
    }
  }


  @DeleteMapping("/tiendabloque/{tiendabloqueid}/{usuarioid}")
  public ResponseEntity<RepositoryResult> deletetiendabloque(@PathVariable("tiendabloqueid") Integer tiendabloqueid, @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = tiendabloqueRepository.deleteById(tiendabloqueid, usuarioid);

      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);

      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);  
    }
  }      
}
