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
import com.omsdanone.distribuidores.model.Tienda;
import com.omsdanone.distribuidores.repository.TiendaRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name = "Tienda", description = "Tienda management endpoints")
@RestController
@RequestMapping("/api")
public class TiendaController {

  @Autowired
  TiendaRepository tiendaRepository;

  @GetMapping("/tienda/{tiendaid}/{cadenacomercialid}/{cadenaformatoid}")
  public ResponseEntity<List<Tienda>> getTiendaById
  (@PathVariable("tiendaid") Integer tiendaid, @PathVariable("cadenacomercialid") Short cadenacomercialid,
    @PathVariable("cadenaformatoid") Short cadenaformatoid) {
    List<Tienda> tiendas = tiendaRepository.findById(tiendaid, cadenacomercialid, cadenaformatoid);
   
    if (tiendas != null) {
      return new ResponseEntity<>(tiendas, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping("/tienda/{usuarioid}")
  public ResponseEntity<RepositoryResult> createTienda (@RequestBody Tienda tienda, @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = tiendaRepository.insert(tienda, usuarioid);
         
      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);

      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);      
    }
  }


  @DeleteMapping("/tienda/{tiendaid}/{usuarioid}")
  public ResponseEntity<RepositoryResult> deletetienda(@PathVariable("tiendaid") Integer tiendaid, @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = tiendaRepository.deleteById(tiendaid, usuarioid);

      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);

      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }   
}
