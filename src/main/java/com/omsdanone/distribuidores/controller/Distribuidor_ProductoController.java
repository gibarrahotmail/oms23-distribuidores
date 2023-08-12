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
import com.omsdanone.distribuidores.model.Distribuidor_Producto;
import com.omsdanone.distribuidores.repository.Distribuidor_ProductoRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name = "Distribuidor_Producto", description = "Distribuidor_Producto management endpoints")
@RestController
@RequestMapping("/api")

public class Distribuidor_ProductoController {

  @Autowired
  Distribuidor_ProductoRepository distribuidor_productoRepository;

  @GetMapping("/distribuidor_producto/{distribuidorid}")
  public ResponseEntity<List<Distribuidor_Producto>> getDistribuidor_ProductoById
  (@PathVariable("distribuidorid") Short distribuidorid) {
    List<Distribuidor_Producto> distribuidor_productos = distribuidor_productoRepository.findById(distribuidorid);
   
    if (distribuidor_productos != null) {
      return new ResponseEntity<>(distribuidor_productos, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping("/distribuidor_producto/{usuarioid}")
  public ResponseEntity<RepositoryResult> createDistribuidor_Producto 
  (@RequestBody Distribuidor_Producto distribuidor_producto, @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = distribuidor_productoRepository.insert(distribuidor_producto, usuarioid);
         
      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);

      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @DeleteMapping("/distribuidor_producto/{id}/{productoid}/{usuarioid}/{submarcaid}/{sku}")
  public ResponseEntity<RepositoryResult> deletedistribuidor_producto(@PathVariable("id") Short distribuidorid,
  @PathVariable("productoid") Short productoid, @PathVariable("usuarioid") Short usuarioid, 
  @PathVariable("submarcaid") Short submarcaid, @PathVariable("sku") String sku) {
    try {
      RepositoryResult rresult = distribuidor_productoRepository.deleteById(distribuidorid, productoid, usuarioid, submarcaid, sku);

      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);

      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }    
}
