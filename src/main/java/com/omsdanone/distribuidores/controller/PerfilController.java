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
import com.omsdanone.distribuidores.model.Perfil;
import com.omsdanone.distribuidores.repository.PerfilRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name = "Perfil", description = "Perfil management endpoints")
@RestController
@RequestMapping("/api")
public class PerfilController {
  @Autowired
  PerfilRepository perfilRepository;

  @GetMapping("/perfil/{perfilid}")
  public ResponseEntity<List<Perfil>> getPerfilById
  (@PathVariable("perfilid") Byte perfilid) {
    List<Perfil> perfils = perfilRepository.findById(perfilid);
   
    if (perfils != null) {
      return new ResponseEntity<>(perfils, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}
