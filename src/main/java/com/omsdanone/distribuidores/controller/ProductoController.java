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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omsdanone.distribuidores.model.RepositoryResult;
import com.omsdanone.distribuidores.model.Producto;
import com.omsdanone.distribuidores.repository.ProductoRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = {"http://localhost:9092", "http://localhost:4200"})
@Tag(name = "Producto", description = "Producto management endpoints")
@RestController
@RequestMapping("/api")
public class ProductoController {
   
  @Autowired
  ProductoRepository productoRepository;

  @GetMapping("/producto/{productoid}")
  public ResponseEntity<List<Producto>> getProductoById
  (@PathVariable("productoid") Short productoid, @RequestParam("submarcaid") Short submarcaid, 
  @RequestParam("presentacionid") Short presentacionid, @RequestParam("familiaid") Short familiaid,
  @RequestParam("soloactivos") String soloactivos) 
  {
    List<Producto> productos = productoRepository.findById(productoid, submarcaid, presentacionid, familiaid,
      soloactivos == "1" || soloactivos.toUpperCase() == "YES");  //Byte.parseByte(soloactivos == "1" || soloactivos.toUpperCase() == "YES" ? "1" : "0")
   
    if (productos != null) {
      return new ResponseEntity<>(productos, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping("/producto/{usuarioid}")
  public ResponseEntity<RepositoryResult> createProducto (@RequestBody Producto producto, @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = productoRepository.insert(producto, usuarioid);
         
      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);

      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @DeleteMapping("/producto/{productoid}/{usuarioid}")
  public ResponseEntity<RepositoryResult> deleteproducto(@PathVariable("productoid") Short productoid, 
  @PathVariable("usuarioid") Short usuarioid) 
  {
    try {
      RepositoryResult rresult = productoRepository.deleteById(productoid, usuarioid);

      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);

      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}

