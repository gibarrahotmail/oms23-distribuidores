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
import com.omsdanone.distribuidores.model.RolDePedido;
import com.omsdanone.distribuidores.repository.RolDePedidoRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name = "RolDePedido", description = "RolDePedido management endpoints")
@RestController
@RequestMapping("/api")
public class RolDePedidoController {
  @Autowired
  RolDePedidoRepository roldepedidoRepository;

  @GetMapping("/roldepedido/{roldepedidoid}")
  public ResponseEntity<List<RolDePedido>> getRolDePedidoById
  (@PathVariable("roldepedidoid") Short roldepedidoid) {
    List<RolDePedido> roldepedidos = roldepedidoRepository.findById(roldepedidoid);
   
    if (roldepedidos != null) {
      return new ResponseEntity<>(roldepedidos, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping("/roldepedido/{usuarioid}")
  public ResponseEntity<RepositoryResult> createRolDePedido (@RequestBody RolDePedido roldepedido, 
  @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = roldepedidoRepository.insert(roldepedido, usuarioid);
         
      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);

      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @DeleteMapping("/roldepedido/{roldepedidoid}/{usuarioid}")
  public ResponseEntity<RepositoryResult> deleteroldepedido(@PathVariable("roldepedidoid") Short roldepedidoid, 
  @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = roldepedidoRepository.deleteById(roldepedidoid, usuarioid);

      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);

      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
}
