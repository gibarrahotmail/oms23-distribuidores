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
import com.omsdanone.distribuidores.model.CadenaFormato;
import com.omsdanone.distribuidores.repository.CadenaFormatoRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name = "CadenaFormato", description = "CadenaFormato management endpoints")
@RestController
@RequestMapping("/api")
public class CadenaFormatoController {

  @Autowired
  CadenaFormatoRepository cadenaformatoRepository;

  @GetMapping("/cadenaformato/{cadenaformatoid}")
  public ResponseEntity<List<CadenaFormato>> getCadenaFormatoById
  (@PathVariable("cadenaformatoid") Short cadenaformatoid) {
    List<CadenaFormato> cadenaformatos = cadenaformatoRepository.findById(cadenaformatoid);
   
    if (cadenaformatos != null) {
      return new ResponseEntity<>(cadenaformatos, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping("/cadenaformato/{usuarioid}")
  public ResponseEntity<RepositoryResult> createCadenaFormato (@RequestBody CadenaFormato cadenaformato, @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = cadenaformatoRepository.insert(cadenaformato, usuarioid);
         
      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);
      
      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);      
    }
  }


  @DeleteMapping("/cadenaformato/{cadenaformatoid}/{usuarioid}")
  public ResponseEntity<RepositoryResult> deletecadenaformato(@PathVariable("cadenaformatoid") Short cadenaformatoid, @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = cadenaformatoRepository.deleteById(cadenaformatoid, usuarioid);

      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }      

}
