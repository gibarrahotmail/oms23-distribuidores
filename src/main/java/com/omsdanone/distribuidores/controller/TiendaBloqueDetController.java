package com.omsdanone.distribuidores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omsdanone.distribuidores.model.RepositoryResult;
import com.omsdanone.distribuidores.model.TiendaBloqueDet;
import com.omsdanone.distribuidores.repository.TiendaBloqueDetRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name = "TiendaBloqueDet", description = "TiendaBloqueDet management endpoints")
@RestController
@RequestMapping("/api")

public class TiendaBloqueDetController {
  @Autowired
  TiendaBloqueDetRepository tiendabloquedetRepository;

  @GetMapping("/tiendabloquedet/{tiendabloqueid}")
  public ResponseEntity<List<TiendaBloqueDet>> getTiendaBloqueDetById
  (@PathVariable("tiendabloqueid") Integer tiendabloqueid) {
    List<TiendaBloqueDet> tiendabloquedets = tiendabloquedetRepository.findById(tiendabloqueid);
   
    if (tiendabloquedets != null) {
      return new ResponseEntity<>(tiendabloquedets, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping("/tiendabloquedet/{usuarioid}")
  public ResponseEntity<RepositoryResult> createTiendaBloqueDet (@RequestBody TiendaBloqueDet tiendabloquedet, 
  @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = tiendabloquedetRepository.insert(tiendabloquedet, usuarioid);
         
      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);

      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);  
    }
  }

/* 
  @DeleteMapping("/tiendabloquedet/{}/{usuarioid}")
  public ResponseEntity<RepositoryResult> deletetiendabloquedet(@PathVariable("") void , @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = tiendabloquedetRepository.deleteById(, usuarioid);

      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  } 
  */
}
