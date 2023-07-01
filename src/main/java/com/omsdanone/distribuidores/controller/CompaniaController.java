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
import com.omsdanone.distribuidores.model.Compania;
import com.omsdanone.distribuidores.repository.CompaniaRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name = "Compania", description = "Compania management endpoints")
@RestController
@RequestMapping("/api")
public class CompaniaController {

  @Autowired
  CompaniaRepository companiaRepository;

  @GetMapping("/compania/{companiaid}")
  public ResponseEntity<List<Compania>> getCompaniaById
  (@PathVariable("companiaid") Byte companiaid) {
    List<Compania> companias = companiaRepository.findById(companiaid);
   
    if (companias != null) {
      return new ResponseEntity<>(companias, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  /*
  @PostMapping("/compania/{usuarioid}")
  public ResponseEntity<RepositoryResult> createCompania (@RequestBody Compania compania, @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = companiaRepository.insert(compania, usuarioid);
         
      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @DeleteMapping("/compania/{companiaid}/{usuarioid}")
  public ResponseEntity<RepositoryResult> deletecompania(@PathVariable("companiaid") Byte companiaid, @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = companiaRepository.deleteById(companiaid, usuarioid);

      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }   
  */     
}
