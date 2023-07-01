package com.omsdanone.distribuidores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.omsdanone.distribuidores.model.RepositoryResult;
import com.omsdanone.distribuidores.model.TipoUnidad;
import com.omsdanone.distribuidores.repository.TipoUnidadRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name = "TipoUnidad", description = "TipoUnidad management endpoints")
@RestController
@RequestMapping("/api")
public class TipoUnidadController {

  @Autowired
  TipoUnidadRepository tipounidadRepository;

  @GetMapping("/tipounidad/{tipounidadid}")
  public ResponseEntity<List<TipoUnidad>> getTipoUnidadById
  (@PathVariable("tipounidadid") Byte tipounidadid) {
    List<TipoUnidad> tipounidads = tipounidadRepository.findById(tipounidadid);
   
    if (tipounidads != null) {
      return new ResponseEntity<>(tipounidads, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}
