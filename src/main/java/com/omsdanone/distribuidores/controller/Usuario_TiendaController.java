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
import com.omsdanone.distribuidores.model.Usuario_Tienda;
import com.omsdanone.distribuidores.repository.Usuario_TiendaRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name = "Usuario_Tienda", description = "Usuario_Tienda management endpoints")
@RestController
@RequestMapping("/api")
public class Usuario_TiendaController {

  @Autowired
  Usuario_TiendaRepository usuario_tiendaRepository;

  @GetMapping("/usuario_tienda/{usuarioid}/{tiendaid}")
  public ResponseEntity<List<Usuario_Tienda>> getUsuario_TiendaById
  (@PathVariable("usuarioid") Short usuarioid, @PathVariable("tiendaid") Integer tiendaid,
   @RequestParam("tiendassinusuario") String tiendassinusuario, @RequestParam("usuariossintienda") String usuariossintienda) {
    List<Usuario_Tienda> usuario_tiendas = usuario_tiendaRepository.findById(usuarioid, tiendaid,
    tiendassinusuario == "1" || tiendassinusuario.toUpperCase() == "YES",
    usuariossintienda == "1" || usuariossintienda.toUpperCase() == "YES");
   
    if (usuario_tiendas != null) {
      return new ResponseEntity<>(usuario_tiendas, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping("/usuario_tienda/{cadenaformatoid}/{usuarioid}")
  public ResponseEntity<RepositoryResult> createUsuario_Tienda (@RequestBody Usuario_Tienda usuario_tienda, 
  @PathVariable("cadenaformatoid") Short cadenaformatoid, @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = usuario_tiendaRepository.insert(usuario_tienda, cadenaformatoid, usuarioid);
         
      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);

      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @DeleteMapping("/usuario_tienda/{usuarioid}/{tiendaid}/{cadenaformatoid}/{usuarioidupd}")
  public ResponseEntity<RepositoryResult> deleteusuario_tienda(@PathVariable("usuarioid") Short usuarioid, 
  @PathVariable("tiendaid") Integer tiendaid, @PathVariable("cadenaformatoid") Short cadenaformatoid, 
  @PathVariable("usuarioidupd") Short usuarioidupd) {
    try {
      RepositoryResult rresult = usuario_tiendaRepository.deleteById(usuarioid, tiendaid, cadenaformatoid, usuarioidupd);

      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);

      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }      
  
}
