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
import com.omsdanone.distribuidores.model.Tienda_Unidad;
import com.omsdanone.distribuidores.repository.Tienda_UnidadRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name = "Tienda_Unidad", description = "Tienda_Unidad management endpoints")
@RestController
@RequestMapping("/api")
public class Tienda_UnidadController {

  @Autowired
  Tienda_UnidadRepository tienda_unidadRepository;

  @GetMapping("/tienda_unidad/{tiendaid}/{pedidotipoid}")
  public ResponseEntity<List<Tienda_Unidad>> getTienda_UnidadById
  (@PathVariable("tiendaid") Integer tiendaid, @PathVariable("pedidotipoid") Byte pedidotipoid) {
    List<Tienda_Unidad> tienda_unidads = tienda_unidadRepository.findById(tiendaid, pedidotipoid);
   
    if (tienda_unidads != null) {
      return new ResponseEntity<>(tienda_unidads, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping("/tienda_unidad/{usuarioid}")
  public ResponseEntity<RepositoryResult> createTienda_Unidad (@RequestBody Tienda_Unidad tienda_unidad, 
  @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = tienda_unidadRepository.insert(tienda_unidad, usuarioid);
         
      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);

      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);      
    }
  }


  @DeleteMapping("/tienda_unidad/{tiendaid}/{pedidotipoid}/{usuarioid}")
  public ResponseEntity<RepositoryResult> deletetienda_unidad(@PathVariable("tiendaid") Integer tiendaid, 
    @PathVariable("pedidotipoid") Byte pedidotipoid, @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = tienda_unidadRepository.deleteById(tiendaid, pedidotipoid, usuarioid);

      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }      

}
