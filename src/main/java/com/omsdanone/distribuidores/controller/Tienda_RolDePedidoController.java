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
import com.omsdanone.distribuidores.model.Tienda_RolDePedido;
import com.omsdanone.distribuidores.repository.Tienda_RolDePedidoRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name = "Tienda_RolDePedido", description = "Tienda_RolDePedido management endpoints")
@RestController
@RequestMapping("/api")
public class Tienda_RolDePedidoController {

  @Autowired
  Tienda_RolDePedidoRepository tienda_roldepedidoRepository;

  @GetMapping("/tienda_roldepedido/{tiendaid}/{pedidotipoid}")
  public ResponseEntity<List<Tienda_RolDePedido>> getTienda_RolDePedidoById
  (@PathVariable("tiendaid") Integer tiendaid, @PathVariable("pedidotipoid") Byte pedidotipoid) {
    List<Tienda_RolDePedido> tienda_roldepedidos = tienda_roldepedidoRepository.findById(tiendaid, pedidotipoid);
   
    if (tienda_roldepedidos != null) {
      return new ResponseEntity<>(tienda_roldepedidos, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping("/tienda_roldepedido/{usuarioid}")
  public ResponseEntity<RepositoryResult> createTienda_RolDePedido (@RequestBody Tienda_RolDePedido tienda_roldepedido, 
    @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = tienda_roldepedidoRepository.insert(tienda_roldepedido, usuarioid);
         
      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);

      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);    
    }
  }


  @DeleteMapping("/tienda_roldepedido/{tiendaid}/{pedidotipoid}/{usuarioid}")
  public ResponseEntity<RepositoryResult> deletetienda_roldepedido(@PathVariable("tiendaid") Integer tiendaid, 
    @PathVariable("pedidotipoid") Byte pedidotipoid, @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = tienda_roldepedidoRepository.deleteById(tiendaid, pedidotipoid, usuarioid);

      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }      

}
