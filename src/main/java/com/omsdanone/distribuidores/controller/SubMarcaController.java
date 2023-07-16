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
import com.omsdanone.distribuidores.model.SubMarca;
import com.omsdanone.distribuidores.repository.SubMarcaRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin    //(origins = {"http://localhost:9092", "http://localhost:4200"})
@Tag(name = "SubMarca", description = "SubMarca management endpoints")
@RestController
@RequestMapping("/api")
public class SubMarcaController {
   
  @Autowired
  SubMarcaRepository submarcaRepository;

  @GetMapping("/submarca/{submarcaid}/{marcaid}/{tiendaid}")
  public ResponseEntity<List<SubMarca>> getSubMarcaById
  (@PathVariable("submarcaid") Short submarcaid, @PathVariable("marcaid") Byte marcaid,
  @PathVariable("tienaid") int tiendaid) {
    List<SubMarca> submarcas = submarcaRepository.findById(submarcaid, marcaid, tiendaid);
   
    if (submarcas != null) {
      return new ResponseEntity<>(submarcas, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping("/submarca/{usuarioid}")
  public ResponseEntity<RepositoryResult> createSubMarca (@RequestBody SubMarca submarca, 
  @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = submarcaRepository.insert(submarca, usuarioid);
         
      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);

      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @DeleteMapping("/submarca/{submarcaid}/{usuarioid}")
  public ResponseEntity<RepositoryResult> deletesubmarca(@PathVariable("submarcaid") Short submarcaid, 
  @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = submarcaRepository.deleteById(submarcaid, usuarioid);

      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);

      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }      
}

