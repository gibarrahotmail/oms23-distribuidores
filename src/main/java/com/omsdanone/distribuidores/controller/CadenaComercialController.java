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
import com.omsdanone.distribuidores.model.CadenaComercial;
import com.omsdanone.distribuidores.repository.CadenaComercialRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name = "CadenaComercial", description = "CadenaComercial management endpoints")
@RestController
@RequestMapping("/api")
public class CadenaComercialController {
   
  @Autowired
  CadenaComercialRepository cadenacomercialRepository;

  @GetMapping("/cadenacomercial/{cadenacomercialid}")
  public ResponseEntity<List<CadenaComercial>> getCadenaComercialById
  (@PathVariable("cadenacomercialid") Short cadenacomercialid) {
    List<CadenaComercial> cadenacomercials = cadenacomercialRepository.findById(cadenacomercialid);
   
    if (cadenacomercials != null) {
      return new ResponseEntity<>(cadenacomercials, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping("/cadenacomercial/{usuarioid}")
  public ResponseEntity<RepositoryResult> createCadenaComercial (@RequestBody CadenaComercial cadenacomercial, @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = cadenacomercialRepository.insert(cadenacomercial, usuarioid);
         
      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);
      //return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);      
    }
  }


  @DeleteMapping("/cadenacomercial/{cadenacomercialid}/{usuarioid}")
  public ResponseEntity<RepositoryResult> deletecadenacomercial(@PathVariable("cadenacomercialid") Short cadenacomercialid, @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = cadenacomercialRepository.deleteById(cadenacomercialid, usuarioid);

      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
