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
import com.omsdanone.distribuidores.model.Presentacion;
import com.omsdanone.distribuidores.repository.PresentacionRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = {"http://localhost:9092", "http://localhost:4200"})
@Tag(name = "Presentacion", description = "Presentacion management endpoints")
@RestController
@RequestMapping("/api")
public class PresentacionController {
   
  @Autowired
  PresentacionRepository presentacionRepository;

  @GetMapping("/presentacion/{presentacionid}/{marcaid}")
  public ResponseEntity<List<Presentacion>> getPresentacionById
  (@PathVariable("presentacionid") Short presentacionid, @PathVariable("marcaid") Byte marcaid) {
    List<Presentacion> presentacions = presentacionRepository.findById(presentacionid, marcaid);
   
    if (presentacions != null) {
      return new ResponseEntity<>(presentacions, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping("/presentacion/{usuarioid}")
  public ResponseEntity<RepositoryResult> createPresentacion (@RequestBody Presentacion presentacion,
    @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = presentacionRepository.insert(presentacion, usuarioid);
         
      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println("Exception:");
      System.out.println(e);      
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @DeleteMapping("/presentacion/{presentacionid}/{usuarioid}")
  public ResponseEntity<RepositoryResult> deletepresentacion(@PathVariable("presentacionid") Short presentacionid,
    @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = presentacionRepository.deleteById(presentacionid, usuarioid);

      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println("Exception:");
      System.out.println(e);      
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }      
}

