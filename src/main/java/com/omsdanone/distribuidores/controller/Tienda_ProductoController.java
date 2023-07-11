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
import com.omsdanone.distribuidores.model.Tienda_Producto;
import com.omsdanone.distribuidores.repository.Tienda_ProductoRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name = "Tienda_Producto", description = "Tienda_Producto management endpoints")
@RestController
@RequestMapping("/api")
public class Tienda_ProductoController {

  @Autowired
  Tienda_ProductoRepository tienda_productoRepository;

  @GetMapping("/tienda_producto/{tiendaid}")
  public ResponseEntity<List<Tienda_Producto>> getTienda_ProductoById
  (@PathVariable("tiendaid") Integer tiendaid) {
    List<Tienda_Producto> tienda_productos = tienda_productoRepository.findById(tiendaid);
   
    if (tienda_productos != null) {
      return new ResponseEntity<>(tienda_productos, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping("/tienda_producto/{usuarioid}")
  public ResponseEntity<RepositoryResult> createTienda_Producto (@RequestBody Tienda_Producto tienda_producto, 
  @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = tienda_productoRepository.insert(tienda_producto, usuarioid);
         
      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);

      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @DeleteMapping("/tienda_producto/{tiendaid}/{productoid}/{usuarioid}/{submarcaid}")
  public ResponseEntity<RepositoryResult> deletetienda_producto(@PathVariable("tiendaid") Integer tiendaid, 
  @PathVariable("productoid") Short productoid, @PathVariable("usuarioid") Short usuarioid, 
  @PathVariable("submarcaid") Short submarcaid) {
    try {
      RepositoryResult rresult = tienda_productoRepository.deleteById(tiendaid, productoid, usuarioid, submarcaid);

      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);

      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
